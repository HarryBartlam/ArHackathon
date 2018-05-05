package com.mandatoryfun.harrybartlam

import android.app.Application
import com.mandatoryfun.harrybartlam.arch.AppModule
import timber.log.Timber

open class ArHackathon : Application() {
    override fun onCreate() {
        AppModule.application = this
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
