package br.com.nicetuber.feature.home;

import java.util.List;

import javax.inject.Inject;

import br.com.nicetuber.base.BasePresenter;
import br.com.nicetuber.model.ChannelSearched;

/**
 * Created by thiagozg on 15/10/2017.
 */

public class HomePresenter extends BasePresenter<IHome.View, HomeInteractor>
    implements IHome.Callback {

    @Inject
    public HomePresenter() {
    }

    public void searchChannel(String query) {
        interactor.searchChannel(this, query);
    }

    @Override
    public void onSearchChannelSuccess(List<ChannelSearched> response) {
        view.showList(response);
    }

    @Override
    public void onSearchChannelError(String message) {
        view.showErrorMessage(message);
    }
}
