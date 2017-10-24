package br.com.nicetuber.util;

import br.com.nicetuber.model.ChannelSearched;

/**
 * Created by thiagozg on 15/10/2017.
 */

public interface UIListeners {

    interface OnClickListener {
        void onClick(ChannelSearched channelSearched);
    }

}
