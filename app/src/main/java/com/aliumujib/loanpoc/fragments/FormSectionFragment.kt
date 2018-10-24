package com.aliumujib.loanpoc.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aliumujib.loanpoc.R
import com.aliumujib.loanpoc.adapter.OnPageControlButtonClicked
import com.aliumujib.loanpoc.adapter.PagesSectionAdapter
import com.aliumujib.loanpoc.adapter.SectionAdapter
import com.aliumujib.loanpoc.adapter.SectionNavigator
import com.aliumujib.loanpoc.models.FORM_GRAPH
import com.aliumujib.loanpoc.models.Page
import com.aliumujib.loanpoc.utils.NonScrollLinearLayoutManager
import kotlinx.android.synthetic.main.fragment_form_section.*

class FormSectionFragment : Fragment(), OnPageControlButtonClicked {

    override fun onPagePreviousButtonClickedListener(page: Page, isFirstPage: Boolean, pageIndex: Int) {
        layoutManager.scrollToPosition(pageIndex - 1)
    }

    override fun onPageNextButtonClickedListener(page: Page, isLastPage: Boolean, pageIndex: Int) {
        if (isLastPage) {
            (activity as SectionNavigator).goToNextSection(FORM_GRAPH.sections[sectionPosition])
        } else {
            layoutManager.scrollToPosition(pageIndex + 1)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_form_section, container, false)
    }

    val sectionPosition = 0
    lateinit var layoutManager: NonScrollLinearLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sectionPosition = arguments!![SECTION_ID] as Int
        form_sections_rv.layoutManager = LinearLayoutManager(context!!, RecyclerView.VERTICAL, false)
        form_sections_rv.adapter = SectionAdapter(FORM_GRAPH.sections.subList(0, sectionPosition + 1), context!!)
        section_desc.text = FORM_GRAPH.sections[sectionPosition].sectionDescription
        section_icon.setImageResource(FORM_GRAPH.sections[sectionPosition].sectionBackground)

        next_fab.setOnClickListener {
            viewflipper.displayedChild = +1
        }

        layoutManager = NonScrollLinearLayoutManager(context!!)
        section_pages_rv.layoutManager = layoutManager
        section_pages_rv.adapter = PagesSectionAdapter(FORM_GRAPH.sections[sectionPosition].pages!!, context!!, this)

    }

    companion object {
        val SECTION_ID = "SECTION_ID"
        @JvmStatic
        fun newInstance(sectionPosition: Int) =
                FormSectionFragment().apply {
                    arguments = Bundle().apply {
                        putInt(SECTION_ID, sectionPosition)
                    }
                }
    }
}
