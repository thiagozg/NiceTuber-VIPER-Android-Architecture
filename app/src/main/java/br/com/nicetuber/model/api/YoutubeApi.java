package br.com.nicetuber.model.api;

import com.google.gson.JsonObject;

import br.com.nicetuber.BuildConfig;
import br.com.nicetuber.model.SearchChannelResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by thiagozg on 14/10/2017.
 */

public interface YoutubeApi {

    @GET("search?part=snippet&type=channel&maxResults=20&order=viewCount&key=" + BuildConfig.API_KEY)
    Single<SearchChannelResponse> searchChannel(@Query("q") String query,
                                                @Query("regionCode") String regionCode);

    @GET("channels?part=statistics&key=" + BuildConfig.API_KEY)
    Single<JsonObject> getChannelStatistics(@Query("id") String channelId);

}
