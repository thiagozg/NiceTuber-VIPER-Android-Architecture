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
class Thumbnails {

    @SerializedName("default")
    var imageDefault: ChannelImage? = null

    @SerializedName("medium")
    var imageMedium: ChannelImage? = null

    @SerializedName("high")
    var imageHigh: ChannelImage? = null
}
