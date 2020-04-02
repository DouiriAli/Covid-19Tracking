package com.health.covid19app

import android.os.Bundle
import android.os.Handler
import com.health.covid19app.common.Constants.DELAY_SPLASH_SCREEN
import com.health.covid19app.common.base.view.BaseActivity
import com.health.covid19app.ui.CountryCasesActivity

class SplashScreenActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        setUp()
    }

    private fun setUp() {
        Handler().postDelayed({
            navigateTo(CountryCasesActivity())
        }, DELAY_SPLASH_SCREEN)
    }
}
