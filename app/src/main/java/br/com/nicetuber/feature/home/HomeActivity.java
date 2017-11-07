package br.com.nicetuber.feature.home;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import br.com.nicetuber.R;
import br.com.nicetuber.base.BaseActivity;
import br.com.nicetuber.databinding.ActivityHomeBinding;
import br.com.nicetuber.model.ChannelSearched;
import br.com.nicetuber.util.UIListeners;

public class HomeActivity extends BaseActivity<ActivityHomeBinding, HomePresenter>
        implements IHome.View, UIListeners.OnClickListener, SearchView.OnQueryTextListener {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(this);
        searchItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                HomeActivity.super.closeKeyboard();
                return true;
            }
        });

        return true;
    }

    @Override
    protected void injectDagger() {
        getAppComponent().inject(this);
    }

    @Override
    protected int getXmlLayout() {
        return R.layout.activity_home;
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
    public void showList(List<ChannelSearched> response) {
        super.closeKeyboard();

        RecyclerView recyclerView = binding.rvChannelList;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        HomeChannelAdapter adapter = new HomeChannelAdapter(response, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showErrorMessage(String message) {
        Snackbar.make(binding.clActivityMain, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        presenter.searchChannel(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }

    @Override
    public void onClick(ChannelSearched channelSearched) {
        HomeRouter.goToChannelDetailsView(this, channelSearched);
    }
}
