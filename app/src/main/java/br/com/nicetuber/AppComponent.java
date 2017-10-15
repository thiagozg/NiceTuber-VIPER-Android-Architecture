package br.com.nicetuber;

import javax.inject.Singleton;

import br.com.nicetuber.feature.search.SearchChannelActivity;
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

    void inject(SearchChannelActivity activity);

}
