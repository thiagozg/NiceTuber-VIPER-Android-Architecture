package br.com.nicetuber.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import br.com.nicetuber.AppComponent;
import br.com.nicetuber.CustomApplication;

/**
 * Created by thiagozg on 14/10/2017.
 */

public abstract class BaseFragment<B extends ViewDataBinding, P extends BasePresenter> extends Fragment {

    private Context context;
    private String tag;
    private int idContainer;

    protected B binding;

    @Inject
    protected P presenter;

    /**
     * Lifecyle methods
     */

    protected View createInheritView() {
        return this.binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setRetainInstance(true);
        this.injectDagger();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        // To avoid recreation of View
        if (this.binding == null) {
            this.binding = DataBindingUtil.inflate(inflater, this.getXmlLayout(), container, false);
            this.tag = getFragmentManager().getBackStackEntryAt(
                    getFragmentManager().getBackStackEntryCount() - 1).getName();

            return this.createInheritView();
        }

        return this.binding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    protected void setTitle(int stringId) {
        super.getActivity().setTitle(getResources().getString(stringId));
    }

    protected BaseActivity getBaseActivity() {
        return (BaseActivity) context;
    }

    protected AppComponent getAppComponent() {
        CustomApplication application = (CustomApplication) getBaseActivity().getApplication();

        return application.getAppComponent();
    }

    /**
     * Architecture Method's
     */
    protected abstract void injectDagger();
    protected abstract int getXmlLayout();


    /**
     * Control Fragment Method's
     */
    protected void pushFragment(BaseFragment fragment, String tag, int idContainer) {
        getFragmentManager()
                .beginTransaction()
                .replace(idContainer, fragment, tag)
                .addToBackStack(tag)
                .commit();
    }

    protected void popFragmentToTag(String tag) {
        getFragmentManager().popBackStack(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    protected void popCurrentFragment() {
        getFragmentManager().popBackStack(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    protected void pushFragmentFromBackStack(String tag) {
        Fragment fragment = getFragmentManager().findFragmentByTag(tag);
        pushFragment((BaseFragment) fragment, tag, idContainer);
    }

}
