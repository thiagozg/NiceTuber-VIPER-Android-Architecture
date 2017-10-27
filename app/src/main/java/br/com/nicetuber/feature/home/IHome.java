package br.com.nicetuber.feature.home;

import java.util.List;

import br.com.nicetuber.base.IView;
import br.com.nicetuber.model.ChannelSearched;

/**
 * Created by thiagozg on 15/10/2017.
 */

public interface IHome {

    interface View extends IView {
        void showErrorMessage(String message);
        void showList(List<ChannelSearched> response);
    }

    interface Callback {
        void onSearchChannelSuccess(List<ChannelSearched> response);
        void onSearchChannelError(String message);
    }

}
