package br.com.nicetuber.feature.channel_details;

import com.google.gson.Gson;

import javax.inject.Inject;

import br.com.nicetuber.base.BaseInteractor;
import br.com.nicetuber.util.JsonDeserializer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by thiagozg on 15/10/2017.
 */

public class ChannelDetailsInteractor extends BaseInteractor {

    @Inject
    Gson gson;

    @Inject
    public ChannelDetailsInteractor() {
    }

    public void getChannelStatistics(IChannelDetails.Callback callback, String channelId) {
        youtubeApi.getChannelStatistics(channelId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                    response -> callback.getChannelStatisticsSuccess(
                            JsonDeserializer.deserializeChannelStatistics(gson, response)),
                    throwable -> {
                        callback.getChannelStatisticsError(throwable.getMessage());
                        throwable.printStackTrace();
                    }
            );
    }
}
