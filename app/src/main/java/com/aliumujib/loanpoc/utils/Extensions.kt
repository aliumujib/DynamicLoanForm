package com.aliumujib.loanpoc.utils

import co.ceryle.segmentedbutton.SegmentedButton


fun SegmentedButton.setText(string: String)  {
    val field = this.javaClass.declaredFields
            .toList().filter { it.name == "text" }.first()
    field.isAccessible = true
    field.set(this, string)
    invalidate()
}