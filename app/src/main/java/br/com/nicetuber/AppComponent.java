package br.com.nicetuber;

import javax.inject.Singleton;

import br.com.nicetuber.feature.channel_details.ChannelDetailsActivity;
import br.com.nicetuber.feature.home.HomeActivity;
import br.com.nicetuber.modules.AndroidModule;
import br.com.nicetuber.modules.ApiModule;
import br.com.nicetuber.modules.NetModule;
import br.com.nicetuber.modules.RetrofitModule;
import dagger.Component;

@Component(modules = {
        NetModule.class,
        RetrofitModule.class,
        ApiModule.class,
        AndroidModule.class,
})
@Singleton
public interface AppComponent {

    void inject(HomeActivity activity);

    void inject(ChannelDetailsActivity channelDetailsActivity);

}
