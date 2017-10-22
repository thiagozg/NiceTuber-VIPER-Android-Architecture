package br.com.nicetuber.feature.channel_details;

import br.com.nicetuber.R;
import br.com.nicetuber.base.BaseActivity;
import br.com.nicetuber.databinding.ActivityChannelDetailsBinding;

/**
 * Created by thiagozg on 22/10/2017.
 */

public class ChannelDetailsActivity extends BaseActivity<ActivityChannelDetailsBinding, Void> {

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void injectDagger() {
//        getAppComponent().inject(this);
    }

    @Override
    protected int getXmlLayout() {
        return R.layout.activity_channel_details;
    }
}
