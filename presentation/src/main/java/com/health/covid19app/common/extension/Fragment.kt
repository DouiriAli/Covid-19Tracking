package com.health.covid19app.common.extension

import android.os.Bundle
import com.health.covid19app.common.base.view.BaseFragment

internal fun <T : BaseFragment> T.newInstance(bundle: Bundle? = null): T =
    this.apply {
        arguments = bundle
    }