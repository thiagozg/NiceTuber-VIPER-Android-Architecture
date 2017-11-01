package br.com.nicetuber.feature.home

import br.com.nicetuber.base.BaseInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

/**
 * Created by thiagozg on 15/10/2017.
 */

class HomeInteractor @Inject
constructor() : BaseInteractor() {

    fun searchChannel(callback: IHome.Callback, query: String) {
        youtubeApi.searchChannel(query, Locale.getDefault().country)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { response ->
                            val listChannelsFiltered = response.listChannelSearcheds!!
                                    .filter { channel -> !channel.snippet!!.description!!.isEmpty() }
                                    .toList()
                            callback.onSearchChannelSuccess(listChannelsFiltered)
                        } , { throwable ->
                            callback.onSearchChannelError(throwable.message!!)
                            throwable.printStackTrace()
                        })
    }
}
