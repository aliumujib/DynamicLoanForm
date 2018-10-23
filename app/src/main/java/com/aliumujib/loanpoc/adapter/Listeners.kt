package com.aliumujib.loanpoc.adapter

import com.aliumujib.loanpoc.models.Page
import com.aliumujib.loanpoc.models.Section


interface SectionNavigator {

    fun goToNextSection(section: Section)

}


interface OnPageNextButtonClicked {

    fun onPageNextButtonClickedListener(page: Page, isLastPage: Boolean)

}