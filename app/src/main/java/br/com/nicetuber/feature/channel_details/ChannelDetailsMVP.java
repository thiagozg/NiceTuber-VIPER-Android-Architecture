package br.com.nicetuber.feature.channel_details;

import java.util.List;

import br.com.nicetuber.model.Channel;

/**
 * Created by thiagozg on 15/10/2017.
 */

public interface ChannelDetailsMVP {

    interface View {
        void showErrorMessage(String message);
        void showList(List<Channel> response);
    }

    interface Callback {
        void onSearchChannelSuccess(List<Channel> response);
        void onSearchChannelError(String message);
    }

}
