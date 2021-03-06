package com.example.loginapplication

import android.app.Application
import appModule
import employeesModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@MyApp)
           modules(appModule, employeesModel)
        }
    }
}