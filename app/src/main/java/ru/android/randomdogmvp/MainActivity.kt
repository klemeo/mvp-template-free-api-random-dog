package ru.android.randomdogmvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener
import androidx.core.view.WindowInsetsCompat
import org.koin.android.ext.android.inject
import ru.android.randomdogmvp.base.ScreensManager
import ru.android.randomdogmvp.base.ScreensManagerImpl
import ru.android.randomdogmvp.ui.MainScreen

class MainActivity : AppCompatActivity() {

    private val screensManager: ScreensManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enableEdgeToEdge()

        setOnApplyWindowInsetsListener(window.decorView) { v: View, insets: WindowInsetsCompat ->
            val systemBars: Insets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            WindowInsetsCompat.CONSUMED
        }

        (screensManager as ScreensManagerImpl).init(this, R.id.screensContainer)

        screensManager.showScreen(MainScreen())

    }
}