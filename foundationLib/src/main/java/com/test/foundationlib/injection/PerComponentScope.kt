package com.test.foundationlib.injection

import javax.inject.Scope

/**
 * It is customized scope for each module
 *
 */
@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class PerComponentScope
