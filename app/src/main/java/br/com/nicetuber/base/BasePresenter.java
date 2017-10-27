package br.com.nicetuber.base;

import javax.inject.Inject;

/**
 * Created by thiagozg on 14/10/2017.
 */

public class BasePresenter<V extends IView, I extends BaseInteractor> {

    protected V view;

    @Inject
    protected I interactor;

    public void attachView(V view) {
        this.view = view;
    }

    public void detachView() {
        this.view = null;
    }

}
