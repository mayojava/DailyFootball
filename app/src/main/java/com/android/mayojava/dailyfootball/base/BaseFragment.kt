package com.android.mayojava.dailyfootball.base

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.InsetDrawable
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.android.mayojava.dailyfootball.R
import dagger.android.support.DaggerFragment

abstract class BaseFragment: DaggerFragment() {

    fun setupRecyclerItemDecorator(view: RecyclerView, context: Context) {
        val attrs = intArrayOf(android.R.attr.listDivider)
        val a = context.obtainStyledAttributes(attrs)
        val divider: Drawable? = a.getDrawable(0)
        val inset = resources.getDimensionPixelSize(R.dimen.home_card_spacing_size)
        val insetDrawable = InsetDrawable(divider, inset, 0, inset, 0)
        a.recycle()

        val itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        itemDecoration.setDrawable(insetDrawable)
        view.addItemDecoration(itemDecoration)
    }
}
