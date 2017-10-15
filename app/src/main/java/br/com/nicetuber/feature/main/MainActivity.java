package br.com.nicetuber.feature.main;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;

import br.com.nicetuber.R;
import br.com.nicetuber.base.BaseActivity;
import br.com.nicetuber.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding, Void> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    protected void injectDagger() {
    }

    @Override
    protected int getXmlLayout() {
        return R.layout.activity_main;
    }

}
