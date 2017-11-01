package br.com.nicetuber.base

import br.com.nicetuber.model.api.YoutubeApi
import javax.inject.Inject

/**
 * Created by thiagozg on 14/10/2017.
 */

open class BaseInteractor {

    @Inject
    protected lateinit var youtubeApi: YoutubeApi

}
