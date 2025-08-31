package com.certicode.inventiapp.activity

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.certicode.inventiapp.JobModel
import com.certicode.inventiapp.R
import com.certicode.inventiapp.adapter.FeatureAdapter
import com.certicode.inventiapp.adapter.JobAdapter
import com.certicode.inventiapp.databinding.ActivityHomeBinding
import com.certicode.inventiapp.models.FeatureModel


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val jobsList = listOf(
            JobModel(
                companyLogo = R.drawable.ic_mobile_banking,
                companyName = "Marie Jane",
                jobTitle = "Nurse",
                location = "Mountain View, CA",
                jobTypes = listOf("Full-time", "Remote")
            ),
            JobModel(
                companyLogo = R.drawable.ic_mobile_banking,
                companyName = "Snoop Dog",
                jobTitle = "Physician",
                location = "Redmond, WA",
                jobTypes = listOf("Full-time")
            ),
            JobModel(
                companyLogo = R.drawable.ic_mobile_banking,
                companyName = "Elon Musk",
                jobTitle = "Care Giver",
                location = "Redmond, WA",
                jobTypes = listOf("Full-time")
            ),
            JobModel(
                companyLogo = R.drawable.ic_mobile_banking,
                companyName = "Jeff Bezoz",
                jobTitle = "Gardener",
                location = "Redmond, WA",
                jobTypes = listOf("Full-time")
            ),
            // Add more jobs as needed
        )

        val featureList = listOf(
            FeatureModel(
                featureLogo = R.drawable.feature_1,
                featureName = "Hospital",
            ),
            FeatureModel(
                featureLogo = R.drawable.feature_2,
                featureName = "Community",
            ),
            FeatureModel(
                featureLogo = R.drawable.feature_3,
                featureName = "Check-up",
            ),
            FeatureModel(
                featureLogo = R.drawable.feature_4,
                featureName = "Emergency",
            ),
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rv_jobs)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = JobAdapter(jobsList)

        val rvFeatures = binding.rvFeatures
        rvFeatures.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvFeatures.adapter = FeatureAdapter(featureList)
        rvFeatures.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State)
            {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.right = 18 // Adjust the right margin as needed

            }
        })



    }



}