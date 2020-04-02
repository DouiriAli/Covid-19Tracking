package com.health.covid19app.ui

import android.os.Bundle
import com.health.covid19app.R
import com.health.covid19app.common.base.view.BaseActivity
import com.health.covid19app.common.extension.newInstance
import kotlinx.android.synthetic.main.toolbar.*

class CountryCasesActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_cases)
    }

    override fun setUp() {
        navigateTo(CountriesFragment().newInstance(), true)
        back.setOnClickListener { onBack() }
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

}