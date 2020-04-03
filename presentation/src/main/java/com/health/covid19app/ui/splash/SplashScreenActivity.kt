package com.health.covid19app.ui.splash

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import com.health.covid19app.R
import com.health.covid19app.common.Constants.DELAY_SPLASH_SCREEN
import com.health.covid19app.common.Constants.ENGLISH_LANGUAGE
import com.health.covid19app.common.Constants.KEY_LANGUAGE
import com.health.covid19app.common.Constants.PREF_NAME
import com.health.covid19app.common.Utils
import com.health.covid19app.common.base.view.BaseActivity
import com.health.covid19app.common.extension.get
import com.health.covid19app.ui.CountryCasesActivity
import com.health.domain.model.Version
import javax.inject.Inject


class SplashScreenActivity : BaseActivity(), SplashScreenContract.ViewContract,
    Utils.DialogListener {

    @Inject
    lateinit var presenter: SplashScreenContract.PresenterContract

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        getActivityComponent().inject(this)
        presenter.attachView(this)
    }

    override fun onResume() {
        super.onResume()
        setUp()
    }

    private fun setUp() {

        val sharedPref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val currentLanguage = sharedPref?.get(KEY_LANGUAGE, ENGLISH_LANGUAGE)
        currentLanguage?.let { Utils.setLocale(this, it) }

        if (Utils.hasNetworkAvailable(this)) {
            presenter.getVersion()
        } else {
            Handler().postDelayed({
                navigateToHome()
            }, DELAY_SPLASH_SCREEN)
        }
    }

    override fun onVersionReady(version: Version) {
        if (Utils.getCurrentVersion(this) < version.number) {
            Utils.openDialogPlayStore(this, getString(R.string.message_new_version), this)
        } else {
            navigateToHome()
        }
    }

    override fun onClickPositiveButton() {
        goToPlayStore()
    }

    override fun onClickNegativeButton() {
        navigateToHome()
    }

    private fun goToPlayStore() {
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse(Utils.getUriPlayStore(this))
            )
        )
    }

    private fun navigateToHome() {
        navigateTo(CountryCasesActivity())
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}
