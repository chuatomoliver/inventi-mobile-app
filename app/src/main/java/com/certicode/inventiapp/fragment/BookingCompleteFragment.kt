package com.certicode.inventiapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.certicode.inventiapp.R

class BookingCompleteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_booking_complete, container, false)

        val viewReceipt = view.findViewById<Button>(R.id.viewReceipt)

        viewReceipt.setOnClickListener({
            viewReceipt(view)
        })

        return view
    }

    private fun viewReceipt(view: View){
        val fragment = E_ReceiptFragment()

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