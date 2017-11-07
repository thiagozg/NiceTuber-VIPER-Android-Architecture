package br.com.nicetuber.base

import javax.inject.Inject

/**
 * Created by thiagozg on 14/10/2017.
 */

open class BasePresenter<V : IView, I : BaseInteractor> {

    protected var view: V? = null

    @Inject
    protected lateinit var interactor: I

    fun attachView(view: V) {
        this.view = view
    }

    fun detachView() {
        this.view = null
    }

}
