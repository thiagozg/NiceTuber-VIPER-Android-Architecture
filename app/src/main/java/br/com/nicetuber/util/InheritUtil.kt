package br.com.nicetuber.util

import android.widget.ImageView
import br.com.nicetuber.model.ChannelStatistics
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.Gson
import com.google.gson.JsonObject

/**
 * Created by thiagozg on 31/10/2017.
 */

fun ImageView.loadCircleGlide(url: String? = null) {
    Glide.with(this.context)
            .load(url)
            .apply(RequestOptions.circleCropTransform())
            .into(this)
}

fun String.formatThousand(): String {
    return if (!this.isEmpty())
        String.format("%,d", Integer.valueOf(this))
                .replace(",", ".")
    else "0"
}

fun JsonObject.deserializeToChannelStatistics(gson: Gson): ChannelStatistics {
    val jsonObject = this.get("items").asJsonArray
                            .get(0).asJsonObject
                            .get("statistics").asJsonObject
    return gson.fromJson(jsonObject, ChannelStatistics::class.java)
}
