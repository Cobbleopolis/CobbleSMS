package com.cobblestonestudios.cobblesms.mobile

import java.io.IOException

import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import android.view.{Menu, MenuItem}

class MainActivity extends ActionBarActivity {

    var server: SMSServer = _

    protected override def onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override def onResume(): Unit = {
        super.onResume()
        try {
            server = new SMSServer(8080)
        } catch {
            case e: IOException => e.printStackTrace()
        }
    }

    override def onPause(): Unit = {
        super.onPause()
        if (server != null) {
            server.stop()
        }
    }

    override def onCreateOptionsMenu(menu: Menu): Boolean = {
        getMenuInflater.inflate(R.menu.menu_main, menu)
        true
    }

    override def onOptionsItemSelected(item: MenuItem): Boolean = {
        val id = item.getItemId
        if (id == R.id.action_settings)
            return true
        super.onOptionsItemSelected(item)
    }
}