package br.com.nicetuber.feature.main;

import javax.inject.Inject;

import br.com.nicetuber.base.BasePresenter;

/**
 * Created by thiagozg on 15/10/2017.
 */

public class MainPresenter extends BasePresenter<MainInteractor> {

    @Inject
    public MainPresenter() {
    }

    public void teste() {
        interactor.teste();
    }
}
