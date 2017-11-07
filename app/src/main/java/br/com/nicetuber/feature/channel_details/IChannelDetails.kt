package br.com.nicetuber.feature.channel_details

import br.com.nicetuber.base.IView
import br.com.nicetuber.model.ChannelStatistics

/**
 * Created by thiagozg on 15/10/2017.
 */

interface IChannelDetails {

    interface View : IView {
        fun showChannelStatistics(channelStatistics: ChannelStatistics)
        fun showErrorMessage(message: String)
    }

    interface Callback {
        fun getChannelStatisticsSuccess(channelStatistics: ChannelStatistics)
        fun getChannelStatisticsError(message: String)
    }

}
