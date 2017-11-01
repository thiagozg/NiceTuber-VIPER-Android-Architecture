package br.com.nicetuber.model.api

import br.com.nicetuber.BuildConfig
import br.com.nicetuber.model.SearchChannelResponse
import com.google.gson.JsonObject
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by thiagozg on 14/10/2017.
 */

interface YoutubeApi {

    @GET("search?part=snippet&type=channel&maxResults=20&order=viewCount&key=" + BuildConfig.API_KEY)
    fun searchChannel(@Query("q") query: String,
                      @Query("regionCode") regionCode: String): Single<SearchChannelResponse>

    @GET("channels?part=statistics&key=" + BuildConfig.API_KEY)
    fun getChannelStatistics(@Query("id") channelId: String): Single<JsonObject>

}
