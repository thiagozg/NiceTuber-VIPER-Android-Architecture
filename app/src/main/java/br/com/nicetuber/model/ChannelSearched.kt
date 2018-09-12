package br.com.nicetuber.model

import android.os.Parcelable
import br.com.nicetuber.model.channel.Snippet
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Developed by.:   @thiagozg on 01/04/2017.
 * E-mail.:         thiagozg1995@gmail.com
 * GitHub.:         https://github.com/thiagozg/
 * Google Play.:    https://play.google.com/store/apps/developer?id=Thiago+Giacomini
 */

@Parcelize
class ChannelSearched(
        @SerializedName("snippet") val snippet: Snippet
) : Parcelable
