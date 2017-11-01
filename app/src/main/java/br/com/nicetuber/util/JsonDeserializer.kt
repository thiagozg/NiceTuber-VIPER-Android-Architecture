package br.com.nicetuber.util

import br.com.nicetuber.model.ChannelStatistics
import com.google.gson.Gson
import com.google.gson.JsonObject

/**
 * Created by thiagozg on 23/10/2017.
 */

object JsonDeserializer {

    fun deserializeChannelStatistics(gson: Gson, json: JsonObject): ChannelStatistics {
        val jsonObject = json.get("items").asJsonArray
                .get(0).asJsonObject
                .get("statistics").asJsonObject
        return gson.fromJson(jsonObject, ChannelStatistics::class.java)
    }

}
