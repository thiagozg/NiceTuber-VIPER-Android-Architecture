package br.com.nicetuber.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import br.com.nicetuber.model.channel.Snippet;

/**
 * Developed by.:   @thiagozg on 01/04/2017.
 * E-mail.:         thiagozg1995@gmail.com
 * GitHub.:         https://github.com/thiagozg/
 * Google Play.:    https://play.google.com/store/apps/developer?id=Thiago+Giacomini
 */

@Parcel(Parcel.Serialization.BEAN)
public class ChannelSearched {

    @SerializedName("snippet")
    private Snippet snippet;

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }
}
