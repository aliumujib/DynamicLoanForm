package com.aliumujib.loanpoc.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.ceryle.segmentedbutton.SegmentedButton
import co.ceryle.segmentedbutton.SegmentedButtonGroup
import com.aliumujib.loanpoc.R
import com.aliumujib.loanpoc.models.BaseQuestion
import com.aliumujib.loanpoc.models.DatePickerQuestion
import com.aliumujib.loanpoc.models.DualOptionQuestion
import com.aliumujib.loanpoc.models.TextFieldQuestion
import com.aliumujib.loanpoc.utils.setText
import kotlinx.android.synthetic.main.dual_option_question_item_viewholder.view.*
import kotlinx.android.synthetic.main.text_field_question_item_viewholder.view.*

class QuestionsAdapter(val items: List<BaseQuestion>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    enum class VIEW_TYPE(var value: Int) {
        TEXT_FIELD_QUESTION(1),
        BI_OPTION_QUESTION(2),
        DATE_QUESTION(3),
        AGE_QUESTION(3),
        MONEY_QUESTION(4)
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            items[position] is TextFieldQuestion -> VIEW_TYPE.TEXT_FIELD_QUESTION.value
            items[position] is DualOptionQuestion -> VIEW_TYPE.BI_OPTION_QUESTION.value
            items[position] is DatePickerQuestion -> VIEW_TYPE.DATE_QUESTION.value
//        }else if(items[position] is TextFieldQuestion){
//            return VIEW_TYPE.AGE_QUESTION.value
//        }
            else -> super.getItemViewType(position)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE.TEXT_FIELD_QUESTION.value) {
            TextFieldQuestionViewHolder.create(parent)
        } else if (viewType == VIEW_TYPE.BI_OPTION_QUESTION.value) {
            DualOptionsQuestionViewHolder.create(parent)
        } else if (viewType == VIEW_TYPE.DATE_QUESTION.value) {
            DatePickerQuestionViewHolder.create(parent)
        } else {
            DatePickerQuestionViewHolder.create(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TextFieldQuestionViewHolder) {
            holder.bind(items[position])
        } else if (holder is DualOptionsQuestionViewHolder) {
            holder.bind(items[position])
        } else if (holder is DatePickerQuestionViewHolder) {
            holder.bind(items[position])
        }
    }
}

open class BaseQuestionViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    open val questionTitle: TextView = view.findViewById(R.id.question_title)

    open fun bind(question: BaseQuestion) {
        questionTitle.text = question.questionTitle
    }

}

open class TextFieldQuestionViewHolder(view: View) : BaseQuestionViewHolder(view) {
    val questionEditText: TextView = view.question_edit_text

    override fun bind(question: BaseQuestion) {
        super.bind(question)
        if (question is TextFieldQuestion)
            questionEditText.hint = question.questionHint
    }

    companion object {
        fun create(parent: ViewGroup): TextFieldQuestionViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.text_field_question_item_viewholder, parent, false)
            return TextFieldQuestionViewHolder(view)
        }
    }
}

open class DualOptionsQuestionViewHolder(view: View) : BaseQuestionViewHolder(view) {

    private val segmentedButtonGroup: SegmentedButtonGroup = view.segmented_button
    private val segmentedButton1: SegmentedButton = view.button_1
    private val segmentedButton2: SegmentedButton = view.button_2


    override fun bind(question: BaseQuestion) {
        super.bind(question)

        if (question is DualOptionQuestion) {
            segmentedButton1.setText(question.options[0].optionTitle)
            segmentedButton2.setText(question.options[1].optionTitle)
        }
    }

    companion object {
        fun create(parent: ViewGroup): DualOptionsQuestionViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.dual_option_question_item_viewholder, parent, false)
            return DualOptionsQuestionViewHolder(view)
        }
    }
}

class DatePickerQuestionViewHolder(view: View) : TextFieldQuestionViewHolder(view) {

    override fun bind(question: BaseQuestion) {
        super.bind(question)

        questionEditText.isEnabled = false
        questionEditText.isFocusableInTouchMode = false

        questionEditText.setOnClickListener {

        }
    }

    companion object {
        fun create(parent: ViewGroup): DatePickerQuestionViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.date_picker_question_item_viewholder, parent, false)
            return DatePickerQuestionViewHolder(view)
        }
    }
}

