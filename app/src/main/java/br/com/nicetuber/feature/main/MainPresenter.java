package br.com.nicetuber.feature.main;

import java.util.List;

import javax.inject.Inject;

import br.com.nicetuber.base.BasePresenter;
import br.com.nicetuber.model.Channel;

/**
 * Created by thiagozg on 15/10/2017.
 */

public class MainPresenter extends BasePresenter<MainInteractor>
    implements MainMVP.Callback {

    private MainMVP.View view;

    @Inject
    public MainPresenter() {
    }

    public void searchChannel(MainMVP.View view, String query) {
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
