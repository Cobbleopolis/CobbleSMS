package com.cobblestonestudios.cobblesms.mobile.server

import fi.iki.elonen.NanoHTTPD.{Response, IHTTPSession}

class RouteIndex extends Route {

    val uri: String = "/"

    override def get(server: CobblestoneServer, session: IHTTPSession): Response = {
        server.newFixedLengthResponse("<html><body><p>This is the home page</p></body></html>")
    }
    
}
