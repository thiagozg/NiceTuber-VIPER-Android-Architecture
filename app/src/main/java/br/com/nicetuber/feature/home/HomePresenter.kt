package br.com.nicetuber.feature.home

import br.com.nicetuber.base.BasePresenter
import br.com.nicetuber.model.ChannelSearched
import javax.inject.Inject

/**
 * Created by thiagozg on 15/10/2017.
 */

class HomePresenter @Inject
constructor() : BasePresenter<IHome.View, HomeInteractor>(), IHome.Callback {

    fun searchChannel(query: String) {
        interactor.searchChannel(this, query)
    }

    override fun onSearchChannelSuccess(response: List<ChannelSearched>) {
        view?.showList(response)
    }

    override fun onSearchChannelError(message: String) {
        view?.showErrorMessage(message)
    }
}
