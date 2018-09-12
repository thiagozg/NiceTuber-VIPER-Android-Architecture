package br.com.nicetuber.feature.channel_details

import android.support.v7.app.AlertDialog
import br.com.nicetuber.R
import br.com.nicetuber.base.BaseActivity
import br.com.nicetuber.model.ChannelSearched
import br.com.nicetuber.model.ChannelStatistics
import br.com.nicetuber.util.formatThousand
import br.com.nicetuber.util.loadCircleGlide
import kotlinx.android.synthetic.main.activity_channel_details.*

/**
 * Created by thiagozg on 22/10/2017.
 */

class ChannelDetailsActivity : BaseActivity<ChannelDetailsPresenter>(),
        IChannelDetails.View {

    override fun onStart() {
        super.onStart()
        val channelSearched = intent.getParcelableExtra<ChannelSearched>(KEY_CHANNEL_SELECTED)
        bindData(channelSearched)
        presenter.getChannelStatistics(channelSearched.snippet?.channelId!!)
    }

    private fun bindData(channelSearched: ChannelSearched) {
        iv_channel.loadCircleGlide(channelSearched.snippet?.thumbnails?.imageHigh?.url)
        tv_title.text = channelSearched.snippet?.title
        tv_description.text = channelSearched.snippet?.description
    }

    override fun injectDagger() {
        appComponent?.inject(this)
    }

    override fun getXmlLayout(): Int {
        return R.layout.activity_channel_details
    }

    override fun attachView() {
        presenter.attachView(this)
    }

    override fun detachView() {
        presenter.detachView()
    }

    override fun showChannelStatistics(channelStatistics: ChannelStatistics) {
        tv_videos.text = channelStatistics.videoCount.formatThousand()
        tv_subscriber.text = channelStatistics.subscriberCount.formatThousand()
        tv_views.text = channelStatistics.viewCount.formatThousand()
        tv_comments.text = channelStatistics.commentCount.formatThousand()
    }

    override fun showErrorMessage(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.title_error_dialog))
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton(getString(R.string.ok)) { dialog, id -> finish() }
                .show()
    }

    companion object {
        const val KEY_CHANNEL_SELECTED = "keyChannelSelected"
    }

}
