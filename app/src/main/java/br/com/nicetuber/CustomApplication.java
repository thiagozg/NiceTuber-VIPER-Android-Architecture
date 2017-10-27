package br.com.nicetuber;

import android.app.Application;

import br.com.nicetuber.modules.AndroidModule;
import br.com.nicetuber.modules.ApiModule;
import br.com.nicetuber.modules.NetModule;
import br.com.nicetuber.modules.RetrofitModule;

/**
 * Created by thiagozg on 15/10/2017.
 */

public class CustomApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                        .androidModule(new AndroidModule(this))
                        .netModule(new NetModule())
                        .retrofitModule(new RetrofitModule())
                        .apiModule(new ApiModule())
                        .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}
