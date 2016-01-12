package com.cobblestonestudios.cobblesms.mobile.server

import fi.iki.elonen.NanoHTTPD
import fi.iki.elonen.NanoHTTPD.{IHTTPSession, Response}

trait Route {

    val uri: String

    def get(server: CobblestoneServer, session: IHTTPSession): Response = server.response404

    def put(server: CobblestoneServer, session: IHTTPSession): Response = server.response404

    def post(server: CobblestoneServer, session: IHTTPSession): Response = server.response404

    def delete(server: CobblestoneServer, session: IHTTPSession): Response = server.response404

    def head(server: CobblestoneServer, session: IHTTPSession): Response = server.response404

    def options(server: CobblestoneServer, session: IHTTPSession): Response = server.response404

    def trace(server: CobblestoneServer, session: IHTTPSession): Response = server.response404

    def connect(server: CobblestoneServer, session: IHTTPSession): Response = server.response404

    def patch(server: CobblestoneServer, session: IHTTPSession): Response = server.response404

}
