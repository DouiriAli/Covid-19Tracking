package com.health.covid19app.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.health.covid19app.R
import com.health.covid19app.common.extension.listen
import com.health.covid19app.common.extension.loadUrl
import com.health.domain.model.Country
import kotlinx.android.synthetic.main.country_item.view.*

class CountryAdapter(
    private var countries: MutableList<Country>,
    private val listener: OnCountrySelectedListener
) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.country_item, parent, false)
        return ViewHolder(view).listen { pos, _ ->
            listener.onCountrySelected(countries[pos])
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = countries[position]
        holder.country.text = country.countryName
        holder.flag.loadUrl(country.countryInfo.flag)
    }

    override fun getItemCount(): Int =
        countries.size

    fun setItems(items: MutableList<Country>) {
        countries = items
        notifyDataSetChanged()
    }

    interface OnCountrySelectedListener {

        fun onCountrySelected(country: Country)
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val country = view.country
    val flag = view.flag
}
