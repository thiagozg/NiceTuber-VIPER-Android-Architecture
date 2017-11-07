package br.com.nicetuber.feature.channel_details;

import android.support.v7.app.AlertDialog;

import org.parceler.Parcels;

import br.com.nicetuber.R;
import br.com.nicetuber.base.BaseActivity;
import br.com.nicetuber.databinding.ActivityChannelDetailsBinding;
import br.com.nicetuber.model.ChannelSearched;
import br.com.nicetuber.model.ChannelStatistics;
import br.com.nicetuber.util.ParamKey;

/**
 * Created by thiagozg on 22/10/2017.
 */

public class ChannelDetailsActivity
        extends BaseActivity<ActivityChannelDetailsBinding, ChannelDetailsPresenter>
        implements IChannelDetails.View {

    @Override
    protected void onStart() {
        super.onStart();
        ChannelSearched channelSearched =
                Parcels.unwrap(getIntent().getParcelableExtra(ParamKey.KEY_CHANNEL));
        binding.setChannelSearched(channelSearched);
        presenter.getChannelStatistics(channelSearched.getSnippet().getChannelId());
    }

    @Override
    protected void injectDagger() {
        getAppComponent().inject(this);
    }

    @Override
    protected int getXmlLayout() {
        return R.layout.activity_channel_details;
    }

    @Override
    protected void attachView() {
        presenter.attachView(this);
    }

    @Override
    protected void detachView() {
        presenter.detachView();
    }

    @Override
    public void showChannelStatistics(ChannelStatistics channelStatistics) {
        binding.setChannelStatistics(channelStatistics);
    }

    @Override
    public void showErrorMessage(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.title_error_dialog))
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton(getString(R.string.ok), (dialog, id) -> finish())
                .show();
    }

}
