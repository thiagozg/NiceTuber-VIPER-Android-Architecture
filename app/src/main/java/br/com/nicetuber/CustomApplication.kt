package br.com.nicetuber

import android.app.Application
import br.com.nicetuber.modules.AndroidModule
import br.com.nicetuber.modules.ApiModule
import br.com.nicetuber.modules.NetModule
import br.com.nicetuber.modules.RetrofitModule

/**
 * Created by thiagozg on 15/10/2017.
 */

class CustomApplication : Application() {


    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .androidModule(AndroidModule(this))
                .netModule(NetModule())
                .retrofitModule(RetrofitModule())
                .apiModule(ApiModule())
                .build()
    }

}
