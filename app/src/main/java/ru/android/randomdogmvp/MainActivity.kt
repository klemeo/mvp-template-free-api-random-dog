package ru.android.randomdogmvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.android.ext.android.inject
import ru.android.randomdogmvp.base.ScreensManager
import ru.android.randomdogmvp.base.ScreensManagerImpl
import ru.android.randomdogmvp.ui.MainScreen

class MainActivity : AppCompatActivity() {

    private val screensManager: ScreensManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (screensManager as ScreensManagerImpl).init(this, R.id.screensContainer)

        screensManager.showScreen(MainScreen())

    }
}