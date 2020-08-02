package com.lucas.barbosa.desafioindra.utils

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.DisplayMetrics


fun getProgressBarIndeterminate(context: Context): Drawable? {
    val attrs = intArrayOf(android.R.attr.indeterminateDrawable)
    val attrs_indeterminateDrawable_index = 0
    val a: TypedArray =
        context.obtainStyledAttributes(android.R.style.Widget_ProgressBar, attrs)
    return try {
        a.getDrawable(attrs_indeterminateDrawable_index)
    } finally {
        a.recycle()
    }
}