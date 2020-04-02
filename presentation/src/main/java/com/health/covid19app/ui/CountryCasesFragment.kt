package com.health.covid19app.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.health.covid19app.R
import com.health.covid19app.common.base.view.BaseFragment
import com.health.domain.model.Country
import javax.inject.Inject

class CountryCasesFragment : BaseFragment(), CountryCasesContract.ViewContract {

    override val TAG: String
        get() = CountryCasesFragment::class.java.simpleName

    @Inject
    lateinit var presenter: CountryCasesContract.PresenterContract

    override fun onAttach(context: Context) {
        super.onAttach(context)
        getActivityComponent()?.inject(this)
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
        inflater.inflate(R.layout.fragment_country_cases, container, false)

    override fun setUp() {

    }

    override fun onCountryCasesReady(result: MutableList<Country>) {

    }

    override fun onDetach() {
        super.onDetach()
        presenter.detachView()
    }
}