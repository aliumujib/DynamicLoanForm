package com.aliumujib.loanpoc.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aliumujib.loanpoc.R
import com.aliumujib.loanpoc.adapter.SectionAdapter
import com.aliumujib.loanpoc.adapter.SectionNavigator
import com.aliumujib.loanpoc.models.FORM_GRAPH
import kotlinx.android.synthetic.main.fragment_form_section.*

class FormSectionFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form_section, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sectionPosition = arguments!![SECTION_ID] as Int
        form_sections_rv.layoutManager = LinearLayoutManager(context!!, RecyclerView.VERTICAL, false)
        form_sections_rv.adapter = SectionAdapter(FORM_GRAPH.sections.subList(0, sectionPosition+1),context!!)
        section_desc.text = FORM_GRAPH.sections[sectionPosition].sectionDescription
        section_icon.setImageResource(FORM_GRAPH.sections[sectionPosition].sectionBackground)

        next_fab.setOnClickListener {
            (activity as SectionNavigator).goToNextSection(FORM_GRAPH.sections[sectionPosition])
        }

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
