package com.health.covid19app.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.health.covid19app.R
import com.health.covid19app.common.Constants.ENGLISH_LANGUAGE
import com.health.covid19app.common.Constants.FRENCH_LANGUAGE
import com.health.covid19app.common.Constants.KEY_LANGUAGE
import com.health.covid19app.common.Constants.PREF_NAME
import com.health.covid19app.common.Constants.SPANISH_LANGUAGE
import com.health.covid19app.common.Utils
import com.health.covid19app.common.base.view.BaseFragment
import com.health.covid19app.common.extension.get
import com.health.covid19app.common.extension.newInstance
import com.health.covid19app.common.extension.put
import kotlinx.android.synthetic.main.fragment_choose_language.*

class ChooseLanguageFragment : BaseFragment() {

    override val TAG: String
        get() = ChooseLanguageFragment::class.java.simpleName

    private var languageSelected: String? = null
    private var sharedPref: SharedPreferences? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_choose_language, container, false)

    override fun setUp() {
        (activity as CountryCasesActivity).setTitleToolbar(getString(R.string.choose_language_title))
        (activity as CountryCasesActivity).hideLanguageOption()

        sharedPref = activity?.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        languageSelected = sharedPref?.get(KEY_LANGUAGE, "")

        when (languageSelected) {
            ENGLISH_LANGUAGE -> onEnglishLanguageSelected()
            FRENCH_LANGUAGE -> onFrenchLanguageSelected()
            SPANISH_LANGUAGE -> onSpanishLanguageSelected()
        }

        english_language.setOnClickListener { onEnglishLanguageSelected() }
        french_language.setOnClickListener { onFrenchLanguageSelected() }
        spanish_language.setOnClickListener { onSpanishLanguageSelected() }

        english_language_chbx.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                onEnglishLanguageSelected()
            }
        }
        french_language_ckbx.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                onFrenchLanguageSelected()
            }
        }
        spanish_language_chbx.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                onSpanishLanguageSelected()
            }
        }

        next_btn.setOnClickListener { next() }

    }

    private fun onEnglishLanguageSelected() {
        languageSelected = ENGLISH_LANGUAGE
        english_language_chbx.isChecked = true
        french_language_ckbx.isChecked = false
        spanish_language_chbx.isChecked = false
    }

    private fun onFrenchLanguageSelected() {
        languageSelected = FRENCH_LANGUAGE
        english_language_chbx.isChecked = false
        french_language_ckbx.isChecked = true
        spanish_language_chbx.isChecked = false
    }

    private fun onSpanishLanguageSelected() {
        languageSelected = SPANISH_LANGUAGE
        english_language_chbx.isChecked = false
        french_language_ckbx.isChecked = false
        spanish_language_chbx.isChecked = true
    }

    private fun next() {
        sharedPref?.put(KEY_LANGUAGE, languageSelected)
        languageSelected?.let { activity?.let { it1 -> Utils.setLocale(it1, it) } }
        if (activity?.supportFragmentManager?.backStackEntryCount!! > 1) {
            activity?.supportFragmentManager?.popBackStack()
        } else {
            navigateTo(CountriesFragment().newInstance(), false)
        }
    }

}