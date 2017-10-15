package br.com.nicetuber.feature.main;

import br.com.nicetuber.R;
import br.com.nicetuber.base.BaseActivity;
import br.com.nicetuber.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainPresenter> {


    @Override
    protected void injectDagger() {
        getAppComponent().inject(this);
    }

    @Override
    protected int getXmlLayout() {
        return R.layout.activity_main;
    }

}
