package com.health.covid19app.ui.covid19

import android.content.Context
import android.os.Bundle
import android.text.Html
import android.view.View
import com.health.covid19app.R
import com.health.covid19app.common.Constants.KEY_LANGUAGE
import com.health.covid19app.common.Constants.PREF_NAME
import com.health.covid19app.common.Utils
import com.health.covid19app.common.base.view.BaseActivity
import com.health.covid19app.common.extension.get
import com.health.covid19app.common.extension.newInstance
import com.health.covid19app.ui.ChooseLanguageFragment
import kotlinx.android.synthetic.main.toolbar.*

class CountryCasesActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_cases)
        setUp()
    }

    private fun setUp() {

        val sharedPref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val currentLanguage = sharedPref?.get(KEY_LANGUAGE, "")

        if (currentLanguage?.isNotEmpty()!!) {
            Utils.setLocale(this, currentLanguage)
            navigateTo(CountriesFragment().newInstance(), true)
        } else {
            navigateTo(ChooseLanguageFragment().newInstance(), true)
        }

        back.setOnClickListener { onBack() }
        choose_language.setOnClickListener { chooseLanguage() }
        info.setOnClickListener { showInfo() }
    }

    fun setTitleToolbar(title: String) {
        toolbar_title.text = title
    }

    private fun onBack() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            finish()
        }
    }

    fun hideLanguageOption() {
        choose_language.visibility = View.GONE
    }

    fun showLanguageOption() {
        choose_language.visibility = View.VISIBLE
    }

    private fun chooseLanguage() {
        navigateTo(ChooseLanguageFragment().newInstance(), false)
    }

    private fun showInfo() {
        showMessage(getString(R.string.info, Html.FROM_HTML_MODE_COMPACT), null)

    }

}