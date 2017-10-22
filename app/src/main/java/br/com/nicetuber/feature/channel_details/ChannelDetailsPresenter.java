package br.com.nicetuber.feature.channel_details;

import java.util.List;

import javax.inject.Inject;

import br.com.nicetuber.base.BasePresenter;
import br.com.nicetuber.feature.home.HomeInteractor;
import br.com.nicetuber.feature.home.HomeMVP;
import br.com.nicetuber.model.Channel;

/**
 * Created by thiagozg on 15/10/2017.
 */

public class ChannelDetailsPresenter extends BasePresenter<HomeInteractor>
    implements HomeMVP.Callback {

    private HomeMVP.View view;

    @Inject
    public ChannelDetailsPresenter() {
    }

    public void searchChannel(HomeMVP.View view, String query) {
        this.view = view;
        interactor.searchChannel(this, query);
    }

    @Override
    public void onSearchChannelSuccess(List<Channel> response) {
        view.showList(response);
    }

    @Override
    public void onSearchChannelError(String message) {
        view.showErrorMessage(message);
    }
}
