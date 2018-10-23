package com.aliumujib.loanpoc.models

open class BaseQuestion(var questionID: Int,
                        var questionTitle: String,
                        var answer: Answer? = null)

class TextFieldQuestion(questionID: Int, questionTitle: String, answer: Answer? = null) : BaseQuestion(questionID, questionTitle, answer)

class DualOptionQuestion(questionID: Int, questionTitle: String, answer: Answer? = null, options: List<Option>) : BaseQuestion(questionID, questionTitle, answer)

class DatePickerQuestion(questionID: Int, questionTitle: String, answer: Answer? = null) : BaseQuestion(questionID, questionTitle, answer)

enum class QUESTION_TYPE(value: Int) {
    TEXT_FIELD_QUESTION(0),
    BI_OPTION_QUESTION(1),
    DATE_QUESTION(2),
    MONEY_QUESTION(3)
}