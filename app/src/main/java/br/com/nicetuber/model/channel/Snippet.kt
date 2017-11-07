package br.com.nicetuber.model.channel

import com.google.gson.annotations.SerializedName

import org.parceler.Parcel

/**
 * Developed by.:   @thiagozg on 01/04/2017.
 * E-mail.:         thiagozg1995@gmail.com
 * GitHub.:         https://github.com/thiagozg/
 * Google Play.:    https://play.google.com/store/apps/developer?id=Thiago+Giacomini
 */
@Parcel(Parcel.Serialization.BEAN)
class Snippet {

    @SerializedName("channelId")
    var channelId: String? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("thumbnails")
    var thumbnails: Thumbnails? = null
}

