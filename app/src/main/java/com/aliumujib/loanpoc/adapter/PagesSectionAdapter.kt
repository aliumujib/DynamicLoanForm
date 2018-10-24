package com.aliumujib.loanpoc.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aliumujib.loanpoc.R
import com.aliumujib.loanpoc.models.Page
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.page_item_viewholder.view.*

class PagesSectionAdapter(val items: List<Page>, val context: Context, val onPageControlButtonClicked: OnPageControlButtonClicked) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PageViewHolder.create(parent, onPageControlButtonClicked)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PageViewHolder) {
            holder.bind(items[position], position == items.lastIndex, position == 0)
        }
    }
}

class PageViewHolder(view: View,
                     private val onPageControlButtonClicked: OnPageControlButtonClicked) : RecyclerView.ViewHolder(view) {

    private val sectionTitle: TextView = view.section_title
    private val sectionNumber: TextView = view.section_number
    private val floatingActionButton: FloatingActionButton = view.floatingActionButton
    private val previousButton: TextView = view.previous_button
    private val pageQuestionsRv: RecyclerView = view.page_questions_rv


    fun bind(page: Page, isLastPage: Boolean, isFirstPage: Boolean) {

        if(isFirstPage){
            previousButton.visibility = View.GONE
        }else{
            previousButton.visibility = View.VISIBLE
        }

        sectionNumber.text = "${adapterPosition + 1}"

        pageQuestionsRv.layoutManager = LinearLayoutManager(itemView.context, RecyclerView.VERTICAL, false)
        pageQuestionsRv.adapter = QuestionsAdapter(page.questions)

        sectionTitle.text = page.pageTitle
        floatingActionButton.setOnClickListener {
            onPageControlButtonClicked.onPageNextButtonClickedListener(page, isLastPage, adapterPosition)
        }
        previousButton.setOnClickListener {
            onPageControlButtonClicked.onPagePreviousButtonClickedListener(page, isFirstPage, adapterPosition)
        }
    }

    companion object {
        fun create(parent: ViewGroup, onPageControlButtonClicked: OnPageControlButtonClicked): PageViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.page_item_viewholder, parent, false)
            return PageViewHolder(view, onPageControlButtonClicked)
        }
    }
}