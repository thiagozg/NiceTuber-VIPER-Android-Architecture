package br.com.nicetuber.base;

import javax.inject.Inject;

import br.com.nicetuber.model.api.YoutubeApi;

/**
 * Created by thiagozg on 14/10/2017.
 */

public class BaseInteractor {

    @Inject
    protected YoutubeApi youtubeApi;

}
