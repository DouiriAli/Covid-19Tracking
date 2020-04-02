package com.health.covid19app.common.base.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.health.covid19app.R
import com.health.covid19app.common.extension.addFragment
import com.health.covid19app.common.extension.replaceFragment
import com.health.covid19app.di.Covid19App
import com.health.covid19app.di.component.ActivitySubComponent
import kotlinx.android.synthetic.main.activity_country_cases.*

abstract class BaseActivity : AppCompatActivity(), IView {
    private lateinit var activityComponent: ActivitySubComponent

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent = (application as Covid19App).createActivityComponent(this)
    }

    override fun onResume() {
        super.onResume()
        setUp()
    }

    fun getActivityComponent(): ActivitySubComponent {
        return activityComponent
    }

    override fun showLoading() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        )
        loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        loading.visibility = View.GONE
    }

    override fun showMessage(message: String) {
        MaterialAlertDialogBuilder(this)
            .setMessage(message)
            .setPositiveButton("Ok") { dialog, _ ->
                dialog.dismiss()
            }
            .setCancelable(false)
            .show()
    }

    override fun navigateTo(fragment: BaseFragment, isAdd: Boolean) {
        if (isAdd) {
            supportFragmentManager.addFragment(R.id.container, fragment, fragment.TAG)
        } else {
            supportFragmentManager.replaceFragment(R.id.container, fragment, fragment.TAG)
        }
    }

    override fun navigateTo(activity: BaseActivity) {
        startActivity(Intent(applicationContext, activity::class.java))
        finish()
    }
}