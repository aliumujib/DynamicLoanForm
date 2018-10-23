package com.aliumujib.loanpoc.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aliumujib.loanpoc.R
import com.aliumujib.loanpoc.models.Section
import com.aliumujib.loanpoc.utils.VectorDrawableUtils
import com.github.vipulasri.timelineview.TimelineView
import kotlinx.android.synthetic.main.section_item_viewholder.view.*


class SectionAdapter(val items: List<Section>, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return TimelineView.getTimeLineViewType(position, itemCount)
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SectionViewHolder.create(parent, viewType)
    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is SectionViewHolder){
            holder.bindView(items[position])
        }
    }
}

class SectionViewHolder(var view: View, viewType: Int) : RecyclerView.ViewHolder(view) {

    private val sectionNumber = view.section_number
    private val sectionTitle = view.section_title
    private val timeMarker = view.time_marker

    init {
        timeMarker.initLine(viewType)
    }

   open fun bindView(section: Section) {
        sectionNumber.text = "${adapterPosition + 1}"
        sectionTitle.text = section.sectionTitle
        timeMarker.setMarker(VectorDrawableUtils.getDrawable(view.context, R.drawable.ic_marker_inactive))
    }

    companion object {
        fun create(parent: ViewGroup, viewType: Int): SectionViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.section_item_viewholder, parent, false)
            return SectionViewHolder(view, viewType)
        }
    }

}