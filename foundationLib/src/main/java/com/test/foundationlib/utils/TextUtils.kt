package com.test.foundationlib.utils

/**
 * Do text check
 */
object TextUtils {
    fun isEmpty(str: CharSequence?): Boolean {
        return str == null || str.length == 0
    }
}