package com.cobblestonestudios.cobblesms.mobile.server

import android.util.Log
import fi.iki.elonen.NanoHTTPD
import fi.iki.elonen.NanoHTTPD.{Response, IHTTPSession}

import scala.collection.immutable.HashMap

abstract class CobblestoneServer(port: Int, tag: String) extends NanoHTTPD(port) {
    start()
    Log.i(tag, "Server is running")

    val response404 = newFixedLengthResponse(NanoHTTPD.Response.Status.NOT_FOUND, "text/html", "<html><head><title>Not Found</title></head><body>Sorry, the object you requested was not found.</body><html>")

    var routes: HashMap[String, Route] = new HashMap[String, Route]

    def addRoute(route: Route): Unit = {
        routes += route.uri -> route
    }

    override def serve(session: IHTTPSession): Response = {
        Log.i(tag, session.getMethod.toString)
        val route = routes.getOrElse(session.getUri, null)
        if (route != null)
            session.getMethod match {
                case NanoHTTPD.Method.GET => route.get(this, session)
                case NanoHTTPD.Method.PUT => route.put(this, session)
                case NanoHTTPD.Method.POST => route.post(this, session)
                case NanoHTTPD.Method.DELETE => route.delete(this, session)
                case NanoHTTPD.Method.HEAD => route.head(this, session)
                case NanoHTTPD.Method.OPTIONS => route.options(this, session)
                case NanoHTTPD.Method.TRACE => route.trace(this, session)
                case NanoHTTPD.Method.CONNECT => route.connect(this, session)
                case NanoHTTPD.Method.PATCH => route.patch(this, session)
                case _ => response404
            }
        else
            response404
    }
}
