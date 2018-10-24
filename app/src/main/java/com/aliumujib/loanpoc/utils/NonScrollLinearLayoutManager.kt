package com.aliumujib.loanpoc.utils

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager


class NonScrollLinearLayoutManager(var context: Context) : LinearLayoutManager(context) {

    override fun canScrollHorizontally(): Boolean {
        return false
    }

    override fun canScrollVertically(): Boolean {
        return false
    }
}