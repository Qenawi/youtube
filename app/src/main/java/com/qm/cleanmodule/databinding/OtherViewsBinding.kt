package com.qm.cleanmodule.databinding

import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.Paint
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.text.TextWatcher
import android.text.method.LinkMovementMethod
import android.util.Base64
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatAutoCompleteTextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.qm.cleanmodule.data.model.ListDataItem
import com.qm.cleanmodule.util.*
import com.qm.cleanmodule.R
import com.tenclouds.fluidbottomnavigation.FluidBottomNavigation
import com.tenclouds.fluidbottomnavigation.FluidBottomNavigationItem
import timber.log.Timber

/**
 * Created by MahmoudAyman on 6/18/2020.
 **/

class OtherViewsBinding {

    @BindingAdapter("setCalendarFabColor")
    fun colorFab(fab: FloatingActionButton, color: Int) {
        fab.backgroundTintList = ColorStateList.valueOf(color)
    }

    @BindingAdapter("setEditTextList")
    fun setEditTextList(til: TextInputLayout, items: ArrayList<ListDataItem>?) {
        items?.let {
            val adapter = ArrayAdapter(til.context, android.R.layout.simple_list_item_1, items)
            (til.editText as AppCompatAutoCompleteTextView).setAdapter(adapter)
        } ?: Timber.e("list in null")
    }

    @BindingAdapter("setBottomBarMenu")
    fun bindMenuInBottomBar(fbn: FluidBottomNavigation, list: List<FluidBottomNavigationItem>?) {
        list?.apply {
            fbn.items = this
        } ?: Timber.e("list is null")
    }

    @BindingAdapter("setUnderLinedText")
    fun TextView.setUnderLined(set: Boolean) {
        if (set) {
            paintFlags = paintFlags or Paint.UNDERLINE_TEXT_FLAG
        }
    }

    @BindingAdapter("imageColor")
    fun setImageColor(imageView: ImageView, color: Int?) {
        color?.let {
            val colorDrawable = ColorDrawable(color)
            imageView.setImageDrawable(colorDrawable)
        }
    }


    @BindingAdapter(value = ["loadImage", "imageLoader"], requireAll = false)
    fun bindLoadImage(imageView: ImageView, obj: Any?, progressBar: ProgressBar?) {
        obj?.let {
            when (it) {
                is Int -> imageView.setImageResource(it)
                is Drawable -> imageView.setImageDrawable(it)
                is Bitmap -> imageView.setImageBitmap(it)
                is Uri -> imageView.setImageURI(it)
                is String -> when {
                    it.isValidUrl() -> imageView.loadImageFromURL(it, progressBar)
                    it.length >= 200 -> {
                        Timber.e("image is encoded")
                        val decodedString: ByteArray = Base64.decode(obj.toString(), Base64.DEFAULT)
                        Glide.with(imageView.context).asBitmap()
                            .load(decodedString)
                            .error(R.drawable.ic_broken_image)
                            .into(imageView)
                    }
                    else -> {
                        Timber.e("image string isn't valid")
                        imageView.loadImageFromURL("")
                    }
                }
                else -> {
                    Timber.e("image url isn't valid")
                    imageView.loadImageFromURL("")
                }
            }
        } ?: imageView.setImageResource(R.drawable.ic_broken_image)
    }

    @BindingAdapter("app:checkForEquality", "app:observer", requireAll = true)
    fun checkForEquality(
        tilCurrent: TextInputLayout,
        tilPrev: TextInputLayout,
        hasError: MutableLiveData<Boolean>
    ) {
        hasError.value = tilCurrent.editText?.text.toString() != tilPrev.editText?.text.toString()
    }

    @BindingAdapter("app:visibleGone")
    fun bindViewGone(view: View, b: Boolean) {
        if (b) {
            view.visible()
        } else
            view.gone()
    }

    @BindingAdapter("app:visibleInVisible")
    fun bindViewInvisible(view: View, b: Boolean) {
        if (b) {
            view.visible()
        } else
            view.invisible()

    }

    @BindingAdapter("android:onTextChanged")
    fun bindViewInvisible(tie: TextInputEditText, textChanged: TextWatcher) {
        tie.addTextChangedListener(textChanged)
    }

    @BindingAdapter("app:adapter", "app:setDivider")
    fun bindAdapter(recyclerView: RecyclerView, adapter: ListAdapter<*, *>?, divider: Boolean?) {
        adapter?.let {
            recyclerView.adapter = it
            divider?.let { div ->
                if (div) {
                    val decoration =
                        DividerItemDecoration(recyclerView.context, LinearLayoutManager.VERTICAL)
                    recyclerView.addItemDecoration(decoration)
                }
            }
        } ?: Timber.e("adapter is null")
    }

    @BindingAdapter("renderHtml")
    fun bindRenderHtml(view: TextView, description: String?) {
        if (description != null) {
            view.text = HtmlCompat.fromHtml(description, HtmlCompat.FROM_HTML_MODE_COMPACT)
            view.movementMethod = LinkMovementMethod.getInstance()
        } else {
            view.text = ""
        }
    }

    @BindingAdapter("setButtonIcon")
    fun MaterialButton.setButtonIcon(@DrawableRes id: Int) {
        setIconResource(id)
    }


}