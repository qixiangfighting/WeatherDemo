package com.test.foundationlib.presenter

import com.test.foundationlib.common.BaseApplication
import com.test.foundationlib.presenter.view.BaseView
import com.trello.rxlifecycle2.LifecycleProvider
import javax.inject.Inject

/**
 * It is base presenter
 *
 */
open class BasePresenter<T: BaseView>{

    lateinit var mView:T

    /**
     * avoid memory leak
     */
    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>


    @Inject
    lateinit var context:BaseApplication

}
