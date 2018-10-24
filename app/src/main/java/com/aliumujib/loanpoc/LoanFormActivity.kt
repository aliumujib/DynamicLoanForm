package com.aliumujib.loanpoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aliumujib.loanpoc.adapter.SectionNavigator
import com.aliumujib.loanpoc.adapter.SectionPagerAdapter
import com.aliumujib.loanpoc.models.FORM_GRAPH
import com.aliumujib.loanpoc.models.Section
import kotlinx.android.synthetic.main.activity_loan_form.*
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener



class LoanFormActivity : AppCompatActivity(), SectionNavigator {

    override fun goToNextSection(section: Section) {
        pager.currentItem = FORM_GRAPH.sections.indexOf(section) + 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loan_form)

        pager.adapter = SectionPagerAdapter(supportFragmentManager, FORM_GRAPH.sections)

        pager.setOnTouchListener { arg0, arg1 -> true }

    }

}
