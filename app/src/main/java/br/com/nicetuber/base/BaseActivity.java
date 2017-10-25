package br.com.nicetuber.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import javax.inject.Inject;

import br.com.nicetuber.AppComponent;
import br.com.nicetuber.CustomApplication;

/**
 * Created by thiagozg on 14/10/2017.
 */

public abstract class BaseActivity<B extends ViewDataBinding, P> extends AppCompatActivity {

    protected B binding;

    @Inject
    protected P presenter;

    /**
     * Architecture Method's
     */
    protected abstract void injectDagger();
    protected abstract int getXmlLayout();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDagger();

        // To avoid recreation of View
        if (this.binding == null) {
            this.binding = DataBindingUtil.setContentView(this, getXmlLayout());
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        this.closeKeyboard();
    }

    protected AppComponent getAppComponent() {
        CustomApplication application = (CustomApplication) getApplication();
        return application.getAppComponent();
    }

    protected void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null)
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}
