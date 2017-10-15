package br.com.nicetuber.feature.search;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;

import br.com.nicetuber.R;
import br.com.nicetuber.base.BaseActivity;
import br.com.nicetuber.databinding.ActivitySearchBinding;
import br.com.nicetuber.feature.main.MainPresenter;

/**
 * Created by thiagozg on 15/10/2017.
 */

public class SearchChannelActivity extends BaseActivity<ActivitySearchBinding, MainPresenter> {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            //use the query to search your data somehow
        }
    }

    @Override
    protected void injectDagger() {
        getAppComponent().inject(this);
    }

    @Override
    protected int getXmlLayout() {
        return R.layout.activity_search;
    }

}
