package br.com.nicetuber.feature.home

import android.app.Activity
import android.content.Intent
import br.com.nicetuber.feature.channel_details.ChannelDetailsActivity
import br.com.nicetuber.feature.channel_details.ChannelDetailsActivity.Companion.KEY_CHANNEL_SELECTED
import br.com.nicetuber.model.ChannelSearched

/**
 * Created by thiagozg on 22/10/2017.
 */

object HomeRouter {

    fun goToChannelDetailsView(activity: Activity, channelSearched: ChannelSearched) {
        val intent = Intent(activity, ChannelDetailsActivity::class.java)
        intent.putExtra(KEY_CHANNEL_SELECTED, channelSearched)
        activity.startActivity(intent)
    }

}
