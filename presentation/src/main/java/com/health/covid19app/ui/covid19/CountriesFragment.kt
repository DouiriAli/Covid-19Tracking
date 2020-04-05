package com.health.covid19app.ui.covid19

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings.ACTION_WIRELESS_SETTINGS
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.health.covid19app.R
import com.health.covid19app.common.Constants.KEY_EXTRA_COUNTRY_CASES
import com.health.covid19app.common.Utils
import com.health.covid19app.common.base.view.BaseFragment
import com.health.covid19app.common.extension.newInstance
import com.health.domain.model.Country
import kotlinx.android.synthetic.main.fragment_countries.*
import javax.inject.Inject

class CountriesFragment : BaseFragment(),
    CountriesContract.ViewContract,
    CountryAdapter.OnCountrySelectedListener, Utils.DialogListener {

    override val TAG: String
        get() = CountriesFragment::class.java.simpleName

    @Inject
    lateinit var presenter: CountriesContract.PresenterContract

    private var adapter: CountryAdapter? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        getActivityComponent()?.inject(this)
    }

    init {
        adapter = CountryAdapter(mutableListOf(), this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_countries, container, false)

    override fun setUp() {
        (activity as CountryCasesActivity).setTitleToolbar(getString(R.string.choose_country))
        (activity as CountryCasesActivity).showLanguageOption()

        recycler_view.layoutManager = LinearLayoutManager(activity)
        recycler_view.setHasFixedSize(true)
        val dividerItemDecoration = DividerItemDecoration(
            recycler_view.context,
            (recycler_view.layoutManager as LinearLayoutManager).orientation
        )
        recycler_view.addItemDecoration(dividerItemDecoration)
        recycler_view.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        if (Utils.hasNetworkAvailable(activity as CountryCasesActivity)) {
            presenter.getCountryCases()
        } else {
            showMessage(getString(R.string.error_message_network_not_available), this)
        }
    }

    override fun onCountryCasesReady(result: MutableList<Country>) {
        adapter?.setItems(result)
    }

    override fun onCountrySelected(country: Country) {
        navigateTo(CountryCasesFragment().newInstance(Bundle().apply {
            putParcelable(KEY_EXTRA_COUNTRY_CASES, country)
        }), false)
    }

    override fun onClickPositiveButton() {
        val intent = Intent(ACTION_WIRELESS_SETTINGS)
        startActivity(intent)
    }

    override fun onClickNegativeButton() {}

    override fun onDetach() {
        super.onDetach()
        presenter.detachView()
    }
}