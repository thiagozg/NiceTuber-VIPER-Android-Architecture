package br.com.nicetuber.feature.channel_details

import br.com.nicetuber.base.BaseInteractor
import br.com.nicetuber.util.deserializeToChannelStatistics
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by thiagozg on 15/10/2017.
 */

class ChannelDetailsInteractor @Inject
constructor() : BaseInteractor() {

    @Inject
    lateinit var gson: Gson

    fun getChannelStatistics(callback: IChannelDetails.Callback, channelId: String) {
        youtubeApi.getChannelStatistics(channelId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { response -> callback.getChannelStatisticsSuccess(
                                        response.deserializeToChannelStatistics(gson))
                        }, {
                            throwable -> callback.getChannelStatisticsError(throwable.message!!)
                                            throwable.printStackTrace()
                        })
    }
}
