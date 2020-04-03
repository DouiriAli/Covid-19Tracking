package com.health.covid19app.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.health.covid19app.R
import com.health.covid19app.common.Constants.KEY_EXTRA_COUNTRY_CASES
import com.health.covid19app.common.Utils
import com.health.covid19app.common.base.view.BaseFragment
import com.health.domain.model.Country
import kotlinx.android.synthetic.main.fragment_country_cases.*
import java.text.DecimalFormat
import kotlin.math.roundToInt


class CountryCasesFragment : BaseFragment() {

    override val TAG: String
        get() = CountryCasesFragment::class.java.simpleName

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_country_cases, container, false)

    override fun setUp() {
        val country = arguments?.getParcelable<Country>(KEY_EXTRA_COUNTRY_CASES)

        (activity as CountryCasesActivity).setTitleToolbar("${getString(R.string.covid19)} - ${country?.countryName}")
        (activity as CountryCasesActivity).showLanguageOption()

        val DeathsPerCases = country?.deaths?.toDouble()?.div(country.cases.toDouble())?.times(100)
        val RecovredPerCases =
            country?.recovered?.toDouble()?.div(country.cases.toDouble())?.times(100)

        DeathsPerCases?.let { progress_deaths_per_cases.progress = it.roundToInt() }
        RecovredPerCases?.let { progress_recovred_per_cases.progress = it.roundToInt() }

        death_rate.text = "${DeathsPerCases?.let { DecimalFormat("##.##").format(it) }} %"
        cure_rate.text = "${RecovredPerCases?.let { DecimalFormat("##.##").format(it) }} %"

        cases_today.text = country?.todayCases.toString()
        deaths_today.text = country?.todayDeaths.toString()
        cases_total.text = country?.cases.toString()
        deaths_total.text = country?.deaths.toString()
        recovred_total.text = country?.recovered.toString()
        critical_total.text = country?.critical.toString()
        active_total.text = country?.active.toString()

        general_informations.text =
            "${getString(R.string.general_informations)} [${country?.updated?.let {
                Utils.timeInMillisToDate(it)
            }}]"

        source_link.setOnClickListener { goToSourceLink() }
    }

    private fun goToSourceLink() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(getString(R.string.source_link))
        startActivity(intent)
    }

}