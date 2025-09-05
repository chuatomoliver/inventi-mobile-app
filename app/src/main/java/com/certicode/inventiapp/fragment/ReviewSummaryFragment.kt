package com.certicode.inventiapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.certicode.inventiapp.R

class ReviewSummaryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_review_summary, container, false)

        val submitBtn = view.findViewById<Button>(R.id.submitBtn)

        submitBtn.setOnClickListener({
            submitBtn(view)
        })


        return view
    }

    private fun submitBtn(view: View){
        val fragment = BookingCompleteFragment()
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onStart() {
        super.onStart()
        view?.post {
            requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.GONE
            requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.GONE
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.GONE
    }

}