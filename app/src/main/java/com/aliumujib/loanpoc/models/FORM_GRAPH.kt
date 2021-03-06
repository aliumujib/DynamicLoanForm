package com.aliumujib.loanpoc.models

import com.aliumujib.loanpoc.R

object FORM_GRAPH {


    var firstNameQuestion = TextFieldQuestion(1, "Let’s start with your first name", "Your first name")
    var lastNameQuestion = TextFieldQuestion(2, "Tell us your last name", "Your last name")

    val namesPage = Page(listOf(firstNameQuestion, lastNameQuestion), "Personal Information", "")


    var DOBQuestion = DatePickerQuestion(3, "When were you born?")
    val dobPage = Page(listOf(DOBQuestion), "Personal Information", "")

    var maleGender = Option(0, "Male")
    var femaleGender = Option(0, "Female")
    var genderQuestion = DualOptionQuestion(3, "Are you a man or woman?", options = listOf(maleGender, femaleGender))

    var yesOption = Option(0, "Yes")
    var noOption = Option(0, "No")
    var maritalStatusQuestion = DualOptionQuestion(3, "Are you married?", options = listOf(yesOption, noOption))

    val genderRtnShipStatsPage = Page(listOf(genderQuestion, maritalStatusQuestion), "Personal Information", "")

    val personalInfoSection = Section(1, "Personal Information",
            "In  this section, we will collect basic inforamation about you so we can decide" +
                    " if we gon give you our money or not.", R.drawable.umberella, 0, true, 1, listOf(namesPage, dobPage, genderRtnShipStatsPage))


    val educationInfoSection = Section(1, "Education Information",
            "In  this section, we will collect basic inforamation about you so we can decide" +
                    " if we gon give you our money or not.", R.drawable.umberella, 0, true, 1, listOf())


    val addressInfoSection = Section(1, "Address Information",
            "In  this section, we will collect basic inforamation about you so we can decide" +
                    " if we gon give you our money or not.", R.drawable.umberella, 0, true, 1, listOf())

    val loanInfoSection = Section(1, "Loan Details",
            "In  this section, we will collect basic inforamation about you so we can decide" +
                    " if we gon give you our money or not.", R.drawable.umberella, 0, true, 1, listOf())

    val sections = listOf(personalInfoSection, educationInfoSection, addressInfoSection, loanInfoSection)

}