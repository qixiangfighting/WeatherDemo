package com.test.foundationlib.ui.activity

import android.os.Bundle
import com.kotlin.base.ui.activity.BaseActivity
import com.test.foundationlib.common.BaseApplication
import com.test.foundationlib.injection.component.ActivityComponent
import com.test.foundationlib.injection.component.DaggerActivityComponent
import com.test.foundationlib.injection.module.ActivityModule
import com.test.foundationlib.injection.module.LifecycleProviderModule
import com.test.foundationlib.presenter.BasePresenter
import com.test.foundationlib.presenter.view.BaseView
import com.test.foundationlib.ui.widget.ProgressLoading
import javax.inject.Inject

/**
 * BaseMvpActivity contains presenter and do logic
 *
 */
 abstract class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {


    @Inject
    lateinit var mPresenter: T

    lateinit var mActivityComponent: ActivityComponent

    private lateinit var mLoadingDialog: ProgressLoading

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()
        mLoadingDialog = ProgressLoading.create(this)
    }


    /**
     * For subclass to inject
     *
     */
    protected abstract fun injectComponent()


    /**
     * Provide ActivityComponent
     *
     */
    private fun initActivityInjection() {
        mActivityComponent =
            DaggerActivityComponent.builder().appComponent((application as BaseApplication).appComponent)
                .activityModule(ActivityModule(this))
                .lifecycleProviderModule(LifecycleProviderModule(this))
                .build()

    }


    /**
     * show dialog
     *
     */
    override fun showLoading() {
        mLoadingDialog.showLoading()
    }


    /**
     * Dismiss dialog
     *
     */
    override fun hideLoading() {
        mLoadingDialog.hideLoading()
    }

    override fun onError(text: String) {

    }
}
