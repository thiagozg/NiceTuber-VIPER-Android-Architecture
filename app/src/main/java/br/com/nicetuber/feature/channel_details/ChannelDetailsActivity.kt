package br.com.nicetuber.feature.channel_details

import android.os.Parcelable
import android.support.v7.app.AlertDialog
import br.com.nicetuber.R
import br.com.nicetuber.base.BaseActivity
import br.com.nicetuber.databinding.ActivityChannelDetailsBinding
import br.com.nicetuber.model.ChannelSearched
import br.com.nicetuber.model.ChannelStatistics
import br.com.nicetuber.util.ParamKey
import org.parceler.Parcels

/**
 * Created by thiagozg on 22/10/2017.
 */

class ChannelDetailsActivity : BaseActivity<ActivityChannelDetailsBinding, ChannelDetailsPresenter>(),
        IChannelDetails.View {

    override fun onStart() {
        super.onStart()
        val channelSearched =
                Parcels.unwrap<ChannelSearched>(intent.getParcelableExtra<Parcelable>(ParamKey.KEY_CHANNEL))
        binding?.channelSearched = channelSearched
        presenter?.getChannelStatistics(channelSearched.snippet?.channelId!!)
    }

    override fun injectDagger() {
        appComponent?.inject(this)
    }

    override fun getXmlLayout(): Int {
        return R.layout.activity_channel_details
    }

    override fun attachView() {
        presenter?.attachView(this)
    }

    override fun detachView() {
        presenter?.detachView()
    }

    override fun showChannelStatistics(channelStatistics: ChannelStatistics) {
        binding?.channelStatistics = channelStatistics
    }

    override fun showErrorMessage(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.title_error_dialog))
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton(getString(R.string.ok)) { dialog, id -> finish() }
                .show()
    }

}
