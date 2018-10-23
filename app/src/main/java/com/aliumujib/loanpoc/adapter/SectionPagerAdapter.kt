package com.aliumujib.loanpoc.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.aliumujib.loanpoc.R
import com.aliumujib.loanpoc.fragments.FormSectionFragment
import com.aliumujib.loanpoc.models.Section
import com.github.vipulasri.timelineview.TimelineView


class SectionPagerAdapter(fragmentManager: FragmentManager,
                          var listOfSections: List<Section>) : FragmentPagerAdapter(fragmentManager) {

    // Returns total number of pages
    override fun getCount(): Int {
        return listOfSections.size
    }

    // Returns the fragment to display for that page
    override fun getItem(position: Int): Fragment? {
        return FormSectionFragment.newInstance(position)
    }

    // Returns the page title for the top indicator
    override fun getPageTitle(position: Int): CharSequence {
        return "Page $position"
    }


}
