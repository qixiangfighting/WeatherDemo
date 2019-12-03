package com.test.foundationlib.presenter.view

/**
 * It is the base view using in presenter
 *
 */
interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun onError(text:String)
}
