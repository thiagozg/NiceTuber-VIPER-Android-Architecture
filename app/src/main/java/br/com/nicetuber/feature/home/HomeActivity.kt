package br.com.nicetuber.feature.home

import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import br.com.nicetuber.R
import br.com.nicetuber.base.BaseActivity
import br.com.nicetuber.databinding.ActivityHomeBinding
import br.com.nicetuber.model.ChannelSearched
import br.com.nicetuber.util.UIListeners

class HomeActivity : BaseActivity<ActivityHomeBinding, HomePresenter>(),
        IHome.View, UIListeners.OnClickListener, SearchView.OnQueryTextListener {

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)

        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        searchItem.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(menuItem: MenuItem): Boolean {
                return true
            }

            override fun onMenuItemActionCollapse(menuItem: MenuItem): Boolean {
                super@HomeActivity.closeKeyboard()
                return true
            }
        })

        return true
    }

    override fun injectDagger() {
        appComponent?.inject(this)
    }

    override fun getXmlLayout(): Int {
        return R.layout.activity_home
    }

    override fun attachView() {
        presenter?.attachView(this)
    }

    override fun detachView() {
        presenter?.detachView()
    }

    override fun showList(response: List<ChannelSearched>) {
        super.closeKeyboard()

        val recyclerView = binding?.rvChannelList
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.setHasFixedSize(true)

        val adapter = HomeChannelAdapter(response, this)
        recyclerView?.adapter = adapter
    }

    override fun showErrorMessage(message: String) {
        Snackbar.make(binding?.clActivityMain as View, message, Snackbar.LENGTH_LONG).show()
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        presenter?.searchChannel(query)
        return true
    }

    override fun onQueryTextChange(s: String): Boolean {
        return false
    }

    override fun onClick(channelSearched: ChannelSearched) {
        HomeRouter.goToChannelDetailsView(this, channelSearched)
    }
}
