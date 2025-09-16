package com.certicode.inventiapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.certicode.inventiapp.R

class E_ReceiptFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_e_receipt, container, false)

        return view
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