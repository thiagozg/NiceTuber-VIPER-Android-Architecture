package br.com.nicetuber.feature.channel_details;

import br.com.nicetuber.base.IView;
import br.com.nicetuber.model.ChannelStatistics;

/**
 * Created by thiagozg on 15/10/2017.
 */

public interface IChannelDetails {

    interface View extends IView {
        void showChannelStatistics(ChannelStatistics channelStatistics);
        void showErrorMessage(String message);
    }

    interface Callback {
        void getChannelStatisticsSuccess(ChannelStatistics channelStatistics);
        void getChannelStatisticsError(String message);
    }

}
