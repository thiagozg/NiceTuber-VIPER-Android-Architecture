package br.com.nicetuber.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import br.com.nicetuber.model.ChannelStatistics;

/**
 * Created by thiagozg on 23/10/2017.
 */

public final class JsonDeserializer {

    public static ChannelStatistics deserializeChannelStatistics(Gson gson, JsonObject json) {
        JsonObject jsonObject = json.get("items").getAsJsonArray()
                                .get(0).getAsJsonObject()
                                .get("statistics").getAsJsonObject();
        return gson.fromJson(jsonObject, ChannelStatistics.class);
    }

}
