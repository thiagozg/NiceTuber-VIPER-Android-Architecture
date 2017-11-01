package br.com.nicetuber

import br.com.nicetuber.feature.channel_details.ChannelDetailsActivity
import br.com.nicetuber.feature.home.HomeActivity
import br.com.nicetuber.modules.AndroidModule
import br.com.nicetuber.modules.ApiModule
import br.com.nicetuber.modules.NetModule
import br.com.nicetuber.modules.RetrofitModule
import dagger.Component
import javax.inject.Singleton



@Component(modules = arrayOf(
        NetModule::class,
        RetrofitModule::class,
        ApiModule::class,
        AndroidModule::class)
)
@Singleton
interface AppComponent {

    fun inject(activity: HomeActivity)

    fun inject(channelDetailsActivity: ChannelDetailsActivity)

}
