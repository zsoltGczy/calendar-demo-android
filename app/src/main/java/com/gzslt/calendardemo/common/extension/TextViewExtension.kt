package com.gzslt.calendardemo.common.extension

import android.util.TypedValue
import android.widget.TextView
import androidx.annotation.ColorRes

internal fun TextView.setTextColorRes(@ColorRes color: Int) =
    setTextColor(context.getColorCompat(color))

internal fun TextView.addRippleEffectOnClick() = with(TypedValue()) {
    context.theme.resolveAttribute(android.R.attr.selectableItemBackground, this, true)
    setBackgroundResource(resourceId)
}
