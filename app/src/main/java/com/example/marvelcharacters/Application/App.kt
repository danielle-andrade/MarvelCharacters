package com.example.marvelcharacters.Application

import android.app.Application
import com.example.marvelcharacters.AppInjection
import org.kodein.di.DI
import org.kodein.di.DIAware

class App : Application(), DIAware {

    override val di = DI {
        import(AppInjection.injections)
    }
}