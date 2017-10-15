package br.com.nicetuber.modules;

import com.google.gson.Gson;

import javax.inject.Singleton;

import br.com.nicetuber.BuildConfig;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by ismael on 3/20/17.
 */
@Module
public class RetrofitModule {

    @Provides
    @Singleton
    public Retrofit providesRetrofit(OkHttpClient client, Gson gson) {
        return builder(gson)
                .baseUrl(BuildConfig.ENDPOINT)
                .client(client)
                .build();
    }

    private Retrofit.Builder builder(Gson gson) {
        return new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
    }

}
