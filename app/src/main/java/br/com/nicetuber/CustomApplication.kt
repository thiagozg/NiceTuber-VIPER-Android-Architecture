package br.com.nicetuber

import android.app.Application

/**
 * Created by thiagozg on 15/10/2017.
 */

class CustomApplication : Application() {


    companion object {
        @JvmStatic lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

//        appComponent = DaggerAppComponent.builder()
//                .androidModule(AndroidModule(this))
//                .netModule(NetModule())
//                .retrofitModule(RetrofitModule())
//                .apiModule(ApiModule())
//                .build()
    }

}
