package com.test.foundationlib.rx

import com.test.foundationlib.presenter.view.BaseView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Using it for default subscriber for presenter
 *
 */
open class BaseSubscriber<T>(val baseView: BaseView) : Observer<T> {
    override fun onComplete() {
        baseView.hideLoading()
    }

    override fun onSubscribe(d: Disposable) {

    }

    override fun onNext(result: T) {

    }

    override fun onError(e: Throwable) {
        baseView.hideLoading()
        baseView.onError(e.toString())
    }

}
