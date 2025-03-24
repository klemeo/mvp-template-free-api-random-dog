package ru.android.randomdogmvp.ui

import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import ru.android.randomdogmvp.R
import ru.android.randomdogmvp.base.MvpFragment

class MainScreen : MvpFragment<Presenter>(), View {

    override val presenter by lazy {
        Presenter(
            view = this
        )
    }

    override val layout: Int = R.layout.screen_main

    private var imageView: ImageView? = null
    private var buttonNext: AppCompatButton? = null
    private var pbPost: ProgressBar? = null

    override fun initView(view: android.view.View, savedInstanceState: Bundle?) {
        with(view) {
            imageView = findViewById(R.id.imageView)
            buttonNext = findViewById(R.id.buttonNext)
            pbPost = findViewById(R.id.pbPost)
        }

        buttonNext?.setOnClickListener {
            showDog(false)
            presenter.loadDog()
        }

    }

    override fun refreshDog(dog: DogPresModel) {
        imageView?.apply {
            Glide.with(requireContext())
                .load(dog.message)
                .override(this.width, this.height)
                .transform(CenterCrop(), RoundedCorners(16.dp(context)))
                .into(this)
        }
    }

    override fun showDog(value: Boolean) {
        imageView?.goneIf(!value)
        pbPost?.goneIf(value)
    }

    private infix fun android.view.View.goneIf(expr: Boolean) {
        visibility = if (expr) android.view.View.GONE else android.view.View.VISIBLE
    }

    private fun Int.dp(context: Context?): Int =
        context?.let {
            this * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
        }?.toInt() ?: 0
}