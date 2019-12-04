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
import com.senijoshua.notehero.AppConfig
import java.io.InputStream
import javax.inject.Inject
import okhttp3.OkHttpClient

@Excludes(OkHttpLibraryGlideModule::class)
@GlideModule
class NoteHeroGlideModule : AppGlideModule() {
    @Inject
    lateinit var okHttpClient: OkHttpClient

    init {
        AppConfig.appComponent?.inject(this)
    }

    /**
     * Register the injected [OkHttpClient] instance as the one which
     * will handle the loading of images from https urls instead of
     * the internal instance Glide would create on okhttp integration.
     * Especially if their okhttp instance is old.
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
