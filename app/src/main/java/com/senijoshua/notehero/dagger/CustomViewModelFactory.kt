package com.senijoshua.notehero.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.senijoshua.notehero.utils.annotations.AppScope
import javax.inject.Inject
import javax.inject.Provider

/**
 * Factory class that creates ViewModel instances that can be injected
 * into Fragments and Activities.
 * Source: 1. https://medium.com/chili-labs/android-viewmodel-injection-with-dagger-f0061d3402ff
 * 2. https://proandroiddev.com/viewmodel-with-dagger2-architecture-components-2e06f06c9455
 * 3. https://github.com/GithubBrowserSample/app/src/main/java/com/android/example/github/
 * /GithubViewModelFactory.kt
 * @author Seni Joshua
 */
@AppScope
class CustomViewModelFactory @Inject constructor(
    private val providers: Map<Class<out ViewModel>,
        @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    /*
      In order to inject ViewModel instances into activities, fragments, with Dagger we need to instantiate and supply a
      ViewModelFactory instance (preferrably through the App module) which would create said ViewModel instances
      and then add said Factory instance to the AppComponent for injection.
     */

    /**
     * It searches the generated map of Providers and ViewModelKeys
     * for a specific provider and gets its corresponding ViewModel instance.
     */
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // This gets the provider for a certain view model class and returns the view model instance it provides.
        val provider = providers[modelClass] ?: providers.entries.firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")
        try {
            @Suppress("UNCHECKED_CAST")
            return provider.get() as T // The provider handles the call
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}
