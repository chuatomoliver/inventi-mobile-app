package com.certicode.inventiapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.certicode.inventiapp.R
import com.certicode.inventiapp.adapter.BookingListAdapter
import com.certicode.inventiapp.models.ApartmentModel

class BookingListFragment : Fragment() {

    private lateinit var rvBookingList: RecyclerView
    private lateinit var bookingListAdapter: BookingListAdapter
    private lateinit var bookingList: List<ApartmentModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_booking_list, container, false)

        rvBookingList = view.findViewById(R.id.rvBookingList)

        rvBookingList.layoutManager = LinearLayoutManager(requireContext())

        bookingList = listOf(
            ApartmentModel(
                R.drawable.apartment,
                "Woodland",
                "Pasay City",
                4.0,
                1000
                        ),
                    ApartmentModel(
                    R.drawable.apartment,
            "Woodland",
            "Pasay City",
            4.0,
            1000
        ),
        ApartmentModel(
            R.drawable.apartment,
            "Woodland",
            "Pasay City",
            4.0,
            1000
        ),
            ApartmentModel(
                R.drawable.apartment,
                "Woodland",
                "Pasay City",
                4.0,
                1000
            ),
            ApartmentModel(
                R.drawable.apartment,
                "Woodland",
                "Pasay City",
                4.0,
                1000
            ),
            ApartmentModel(
                R.drawable.apartment,
                "Woodland",
                "Pasay City",
                4.0,
                1000
            )
            )

        // Hide Top Layout
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.GONE
        // Hide Bottom Nav
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.GONE

        bookingListAdapter = BookingListAdapter(bookingList)
        rvBookingList.adapter = bookingListAdapter

        return view
    }


    override fun onResume() {
        super.onResume()

        // Restore visibility when leaving fragment
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.GONE
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()

        // Restore visibility when leaving fragment
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.VISIBLE
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.VISIBLE
    }

}