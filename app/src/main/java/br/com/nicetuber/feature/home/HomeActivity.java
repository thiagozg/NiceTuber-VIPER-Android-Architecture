package br.com.nicetuber.feature.home;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import java.util.List;

import br.com.nicetuber.R;
import br.com.nicetuber.base.BaseActivity;
import br.com.nicetuber.databinding.ActivityHomeBinding;
import br.com.nicetuber.model.Channel;
import br.com.nicetuber.util.UIListeners;

public class HomeActivity extends BaseActivity<ActivityHomeBinding, HomePresenter>
        implements HomeMVP.View, UIListeners.OnClickListener, SearchView.OnQueryTextListener {

    //TODO : trazer teclado já para digitar
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
    public void showList(List<Channel> response) {
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
        presenter.searchChannel(this, query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }

    @Override
    public void onClick(Channel channel) {
        HomeRouter.goToChannelDetailsView(this, channel);
    }
}
