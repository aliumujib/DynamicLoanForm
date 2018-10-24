package com.aliumujib.loanpoc.adapter

import com.aliumujib.loanpoc.models.Page
import com.aliumujib.loanpoc.models.Section


interface SectionNavigator {

    fun goToNextSection(section: Section)

}


interface OnPageControlButtonClicked {

    fun onPageNextButtonClickedListener(page: Page, isLastPage: Boolean, pageIndex: Int)

    fun onPagePreviousButtonClickedListener(page: Page, isFirstPage: Boolean, pageIndex: Int)

}