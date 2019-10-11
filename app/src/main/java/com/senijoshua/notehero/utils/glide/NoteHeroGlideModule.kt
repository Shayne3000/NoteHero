package com.senijoshua.notehero.utils.glide

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.Excludes
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpLibraryGlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.AppGlideModule
import okhttp3.OkHttpClient
import java.io.InputStream
import javax.inject.Inject

@Excludes(OkHttpLibraryGlideModule::class)
@GlideModule
class NoteHeroGlideModule @Inject constructor(private val okHttpClient: OkHttpClient) :
    AppGlideModule() {

    /**
     * Register the injected [OkHttpClient] instance as the one which
     * will handle the loading of images from https urls instead of
     * the internal instance Glide would create on okhttp integration.
     */
    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        super.registerComponents(context, glide, registry)
        registry.replace(
            GlideUrl::class.java,
            InputStream::class.java,
            OkHttpUrlLoader.Factory(okHttpClient)
                        )
    }
}
