package br.com.nicetuber.modules

import br.com.nicetuber.model.api.YoutubeApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by ismael on 3/20/17.
 */
@Module
class ApiModule {

    @Provides
    @Singleton
    fun providesYoutubeApi(retrofit: Retrofit): YoutubeApi {
        return retrofit.create(YoutubeApi::class.java)
    }

}
