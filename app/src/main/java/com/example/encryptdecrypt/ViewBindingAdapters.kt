package com.example.encryptdecrypt

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.BindingAdapter

object ViewBindingAdapters {
    @JvmStatic
    @BindingAdapter("isEnabled")
    fun isEnabled(view: View, resource: Boolean) {
        view.isEnabled = resource
        if (resource) {
            view.alpha = 1f
        } else {
            view.alpha = 0.5f
        }

    }

}
fun hideKeyboard(activity: Activity?) {
    val imm = activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    //Find the currently focused view, so we can grab the correct window token from it.
    var view = activity.currentFocus
    //If no view currently has focus, create a saveOrUpdate one, just so we can grab a window token from it
    if (view == null) {
        view = View(activity)
    }
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}