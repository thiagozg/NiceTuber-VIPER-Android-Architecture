package br.com.nicetuber.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Developed by.:   @thiagozg on 01/04/2017.
 * E-mail.:         thiagozg1995@gmail.com
 * GitHub.:         https://github.com/thiagozg/
 * Google Play.:    https://play.google.com/store/apps/developer?id=Thiago+Giacomini
 */

public class SearchChannelResult {

    @SerializedName("items")
    private List<Channel> listChannels;

    public List<Channel> getListChannels() {
        return listChannels;
    }

    public void setListChannels(List<Channel> listChannels) {
        this.listChannels = listChannels;
    }
}
