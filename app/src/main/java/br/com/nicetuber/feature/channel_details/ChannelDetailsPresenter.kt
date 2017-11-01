package br.com.nicetuber.feature.channel_details

import br.com.nicetuber.base.BasePresenter
import br.com.nicetuber.model.ChannelStatistics
import javax.inject.Inject

/**
 * Created by thiagozg on 15/10/2017.
 */

class ChannelDetailsPresenter @Inject
constructor() : BasePresenter<IChannelDetails.View, ChannelDetailsInteractor>(), IChannelDetails.Callback {

    fun getChannelStatistics(channelId: String) {
        interactor.getChannelStatistics(this, channelId)
    }

    override fun getChannelStatisticsSuccess(channelStatistics: ChannelStatistics) {
        view?.showChannelStatistics(channelStatistics)
    }

    override fun getChannelStatisticsError(message: String) {
        view?.showErrorMessage(message)
    }

}
