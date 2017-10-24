package br.com.nicetuber.feature.home;

import java.util.List;

import br.com.nicetuber.model.ChannelSearched;

/**
 * Created by thiagozg on 15/10/2017.
 */

public interface HomeMVP {

    interface View {
        void showErrorMessage(String message);
        void showList(List<ChannelSearched> response);
    }

    interface Callback {
        void onSearchChannelSuccess(List<ChannelSearched> response);
        void onSearchChannelError(String message);
    }

}
