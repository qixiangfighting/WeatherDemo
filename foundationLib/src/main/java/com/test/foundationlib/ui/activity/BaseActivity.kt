package com.kotlin.base.ui.activity

import android.os.Bundle
import com.test.foundationlib.common.AppManager
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

/**
 * It is base Activity which do nothing about logic
 *
 */
open class BaseActivity : RxAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppManager.instance.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.finishActivity(this)
    }
}
