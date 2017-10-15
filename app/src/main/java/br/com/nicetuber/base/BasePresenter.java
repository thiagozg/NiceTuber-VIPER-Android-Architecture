package br.com.nicetuber.base;

import javax.inject.Inject;

/**
 * Created by thiagozg on 14/10/2017.
 */

public class BasePresenter<I extends BaseInteractor> {

    @Inject
    protected I interactor;

    @Inject
    public BasePresenter() {
    }

}
