package br.com.nicetuber.model.api;

import br.com.nicetuber.BuildConfig;
import br.com.nicetuber.model.SearchChannelResult;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by thiagozg on 14/10/2017.
 */

public interface YoutubeApi {

    @GET("search?part=snippet&type=channel&key=" + BuildConfig.API_KEY + "&maxResults=20")
    Single<SearchChannelResult> search(@Query("query") String query);

}
