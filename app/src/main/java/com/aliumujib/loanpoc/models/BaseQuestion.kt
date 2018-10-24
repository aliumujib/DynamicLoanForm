package com.aliumujib.loanpoc.models

open class BaseQuestion(var questionID: Int,
                        var questionTitle: String,
                        var answer: Answer? = null)

class TextFieldQuestion(questionID: Int, questionTitle: String, var questionHint: String, answer: Answer? = null) : BaseQuestion(questionID, questionTitle, answer)

class DualOptionQuestion(questionID: Int, questionTitle: String, answer: Answer? = null, var options: List<Option>) : BaseQuestion(questionID, questionTitle, answer)

class DatePickerQuestion(questionID: Int, questionTitle: String, answer: Answer? = null) : BaseQuestion(questionID, questionTitle, answer)

