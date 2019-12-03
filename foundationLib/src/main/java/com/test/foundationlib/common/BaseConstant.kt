package com.test.foundationlib.common

/**
 * Put constant here
 *
 * For example base url
 */
class BaseConstant {

    companion object {
        private const val DARK_SKY_KEY = "3c7ee1bd3338bb7954adc2571b57999c"
        const val SERVER_ADDRESS = "https://api.darksky.net/forecast/${DARK_SKY_KEY}/"
    }
}
