package br.com.nicetuber.feature.home;

import com.annimon.stream.Stream;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import br.com.nicetuber.base.BaseInteractor;
import br.com.nicetuber.model.ChannelSearched;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by thiagozg on 15/10/2017.
 */

public class HomeInteractor extends BaseInteractor {

    @Inject
    public HomeInteractor() {
    }

    public void searchChannel(IHome.Callback callback, String query) {
        youtubeApi.searchChannel(query, Locale.getDefault().getCountry())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                    response -> {
                        List<ChannelSearched> listChannelsFiltered =
                                Stream.of(response.getListChannelSearcheds())
                                        .filter(channel -> !channel.getSnippet().getDescription().isEmpty())
                                        .toList();
                        callback.onSearchChannelSuccess(listChannelsFiltered);
                    },
                    throwable -> {
                        callback.onSearchChannelError(throwable.getMessage());
                        throwable.printStackTrace();
                    }
            );
    }
}
