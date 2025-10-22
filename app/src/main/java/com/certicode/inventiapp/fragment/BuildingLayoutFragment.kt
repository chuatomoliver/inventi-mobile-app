package com.certicode.inventiapp.fragment

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.certicode.inventiapp.R
import com.certicode.inventiapp.databinding.FragmentBuildingLayoutBinding
import com.google.ar.sceneform.assets.RenderableSource


class BuildingLayoutFragment : Fragment() {

    private var _binding: FragmentBuildingLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBuildingLayoutBinding.inflate(inflater, container, false)
        // Hide UI elements


        return binding.root
    }


    override fun onResume() {
        super.onResume()
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.GONE
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.GONE
    }


    override fun onDestroyView() {
        super.onDestroyView()
        requireActivity().findViewById<View>(R.id.actionbar_search)?.visibility = View.VISIBLE
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.VISIBLE
        _binding = null
    }
}

