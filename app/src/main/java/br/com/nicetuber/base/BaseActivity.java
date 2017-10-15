package br.com.nicetuber.base;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import javax.inject.Inject;

/**
 * Created by thiagozg on 14/10/2017.
 */

public abstract class BaseActivity<B extends ViewDataBinding, P extends BasePresenter> extends AppCompatActivity {

    protected B binding;

    @Inject
    protected P presenter;

    /**
     * Architecture Method's
     */
    protected abstract void injectDagger();
    protected abstract int getXmlLayout();

    @Override
    public void onResume() {
        super.onResume();

        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    protected View createInheritView() {
        return this.binding.getRoot();
    }

}
