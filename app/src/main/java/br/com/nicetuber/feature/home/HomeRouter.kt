package br.com.nicetuber.feature.home

import android.content.Context
import android.content.Intent
import br.com.nicetuber.feature.channel_details.ChannelDetailsActivity
import br.com.nicetuber.model.ChannelSearched
import br.com.nicetuber.util.ParamKey.KEY_CHANNEL
import org.parceler.Parcels

/**
 * Created by thiagozg on 22/10/2017.
 */

object HomeRouter {

    fun goToChannelDetailsView(context: Context, channelSearched: ChannelSearched) {
        val intent = Intent(context, ChannelDetailsActivity::class.java)
        intent.putExtra(KEY_CHANNEL, Parcels.wrap(channelSearched))
        context.startActivity(intent)
    }

}
