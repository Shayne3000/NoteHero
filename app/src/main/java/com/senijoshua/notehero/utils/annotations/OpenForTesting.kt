package com.senijoshua.notehero.utils.annotations

/**
 * This annotation is used to make a final kotlin class open to extension in debug builds.
 */
@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.CLASS)
annotation class OpenForTesting