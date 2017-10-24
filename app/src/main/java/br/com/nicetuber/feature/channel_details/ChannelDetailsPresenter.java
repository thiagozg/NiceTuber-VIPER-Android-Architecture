package br.com.nicetuber.feature.channel_details;

import javax.inject.Inject;

import br.com.nicetuber.base.BasePresenter;
import br.com.nicetuber.model.ChannelStatistics;

/**
 * Created by thiagozg on 15/10/2017.
 */

public class ChannelDetailsPresenter extends BasePresenter<ChannelDetailsInteractor>
    implements ChannelDetailsMVP.Callback {

    private ChannelDetailsMVP.View view;

    @Inject
    public ChannelDetailsPresenter() {
    }

    public void getChannelStatistics(ChannelDetailsMVP.View view, String channelId) {
        this.view = view;
        interactor.getChannelStatistics(this, channelId);
    }

    @Override
    public void getChannelStatisticsSuccess(ChannelStatistics channelStatistics) {
        view.showChannelStatistics(channelStatistics);
    }

    @Override
    public void getChannelStatisticsError(String message) {
        view.showErrorMessage(message);
    }

}
