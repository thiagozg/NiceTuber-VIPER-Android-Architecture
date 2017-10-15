package br.com.nicetuber.modules;

import javax.inject.Singleton;

import br.com.nicetuber.model.api.YoutubeApi;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by ismael on 3/20/17.
 */
@Module
public class ApiModule {

    @Provides
    @Singleton
    public YoutubeApi providesProductApi(Retrofit retrofit) {
        return retrofit.create(YoutubeApi.class);
    }

}
