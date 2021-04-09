package ru.android.randomdogmvp.ui

import android.os.Bundle
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.screen_main.*
import ru.android.randomdogmvp.R
import ru.android.randomdogmvp.base.MvpFragment

class MainScreen : MvpFragment<Presenter>(), View {

    override val presenter by lazy {
        Presenter(
            view = this
        )
    }

    override val layout: Int = R.layout.screen_main


    override fun initView(view: android.view.View, savedInstanceState: Bundle?) {

        buttonNext.setOnClickListener { presenter.loadDog() }

    }

    override fun refreshDog(dog: DogPresModel) {
        Glide.with(requireContext())
            .load(dog.message)
            .override(500)
            .into(imageView)
    }

    override fun showDog(animated: Boolean) {
        when(animated) {
            true -> {
                imageView.isVisible = true
                pbPost.isGone = true
            }
            else -> {
                imageView.isGone = true
                pbPost.isVisible = true
            }
        }
    }
}