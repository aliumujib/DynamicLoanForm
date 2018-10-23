package com.aliumujib.loanpoc.fragments


import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aliumujib.loanpoc.R

class IntroPageFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form_intro_page, container, false)
    }


    companion object {

        @JvmStatic
        fun newInstance() =
                IntroPageFragment().apply {
                    arguments = Bundle().apply {

                    }
                }
    }
}
