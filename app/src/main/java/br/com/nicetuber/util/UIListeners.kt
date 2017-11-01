package br.com.nicetuber.util

import br.com.nicetuber.model.ChannelSearched

/**
 * Created by thiagozg on 15/10/2017.
 */

interface UIListeners {

    interface OnClickListener {
        fun onClick(channelSearched: ChannelSearched)
    }

}
