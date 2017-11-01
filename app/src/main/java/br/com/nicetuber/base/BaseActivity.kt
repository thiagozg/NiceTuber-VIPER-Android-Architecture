package br.com.nicetuber.base

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import br.com.nicetuber.AppComponent
import br.com.nicetuber.CustomApplication
import javax.inject.Inject

/**
 * Created by thiagozg on 14/10/2017.
 */

abstract class BaseActivity<B : ViewDataBinding, P> : AppCompatActivity() {

    protected var binding: B? = null

    @Inject
    protected var presenter: P? = null

    protected val appComponent: AppComponent?
        get() {
            val application = application as CustomApplication
            return application.appComponent
        }

    /**
     * Architecture Method's
     */
    protected abstract fun injectDagger()
    protected abstract fun getXmlLayout(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.injectDagger()
        this.attachView()

        // To avoid recreation of View
        if (this.binding == null) {
            this.binding = DataBindingUtil.setContentView(this, getXmlLayout())
        }
    }

    protected abstract fun attachView()
    protected abstract fun detachView()

    public override fun onResume() {
        super.onResume()
        this.closeKeyboard()
    }

    protected fun closeKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm?.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        this.detachView()
    }

}
