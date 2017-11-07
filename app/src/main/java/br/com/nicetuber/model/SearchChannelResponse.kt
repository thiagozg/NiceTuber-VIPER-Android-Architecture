package br.com.nicetuber.model

import com.google.gson.annotations.SerializedName

/**
 * Developed by.:   @thiagozg on 01/04/2017.
 * E-mail.:         thiagozg1995@gmail.com
 * GitHub.:         https://github.com/thiagozg/
 * Google Play.:    https://play.google.com/store/apps/developer?id=Thiago+Giacomini
 */

class SearchChannelResponse {

    @SerializedName("items")
    var listChannelSearcheds: List<ChannelSearched>? = null

}
