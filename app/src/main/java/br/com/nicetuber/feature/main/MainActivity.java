package br.com.nicetuber.feature.main;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import java.util.List;

import br.com.nicetuber.R;
import br.com.nicetuber.base.BaseActivity;
import br.com.nicetuber.databinding.ActivityMainBinding;
import br.com.nicetuber.model.Channel;
import br.com.nicetuber.util.UIListeners;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainPresenter>
        implements MainMVP.View, UIListeners.OnClickListener, SearchView.OnQueryTextListener {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    protected void injectDagger() {
        getAppComponent().inject(this);
    }

    @Override
    protected int getXmlLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showList(List<Channel> response) {
        RecyclerView recyclerView = binding.rvChannelList;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        ChannelAdapter adapter = new ChannelAdapter(response, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showErrorMessage(String message) {
        Snackbar.make(binding.clActivityMain, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        presenter.searchChannel(this, query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }

    @Override
    public void onClick(Channel channel) {
        // TODO : router call ActivityChannelDetails
    }
}
