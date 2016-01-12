package com.cobblestonestudios.cobblesms.mobile

import com.cobblestonestudios.cobblesms.mobile.server.{RouteIndex, CobblestoneServer}

class SMSServer(port: Int) extends CobblestoneServer(port, "SMS Server") {
    addRoute(new RouteIndex())
}
