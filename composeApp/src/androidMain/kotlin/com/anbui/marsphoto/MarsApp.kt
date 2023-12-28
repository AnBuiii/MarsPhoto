package com.anbui.marsphoto

import android.app.Application
import di.initKoin

class MarsApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {

        }
    }
}