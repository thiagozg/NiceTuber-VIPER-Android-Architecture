package br.com.nicetuber.feature.main;

import javax.inject.Inject;

import br.com.nicetuber.base.BaseInteractor;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by thiagozg on 15/10/2017.
 */

public class MainInteractor extends BaseInteractor {

    @Inject
    public MainInteractor() {
    }

    public void search(MainMVP.Callback callback, String query) {
        youtubeApi.search(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                    response -> callback.onSearchChannelSuccess(response.getListChannels()),
                    throwable -> {
                        callback.onSearchChannelError(throwable.getMessage());
                        throwable.printStackTrace();
                    }
            );
    }
}
