package br.com.nicetuber.feature.home

import br.com.nicetuber.base.IView
import br.com.nicetuber.model.ChannelSearched

/**
 * Created by thiagozg on 15/10/2017.
 */

interface IHome {

    interface View : IView {
        fun showErrorMessage(message: String)
        fun showList(response: List<ChannelSearched>)
    }

    interface Callback {
        fun onSearchChannelSuccess(response: List<ChannelSearched>)
        fun onSearchChannelError(message: String)
    }

}
