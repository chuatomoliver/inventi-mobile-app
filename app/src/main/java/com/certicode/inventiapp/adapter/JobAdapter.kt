package com.certicode.inventiapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.certicode.inventiapp.JobModel
import com.certicode.inventiapp.R



class JobAdapter(private val jobs: List<JobModel>) : RecyclerView.Adapter<JobAdapter.JobViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val view
        = LayoutInflater.from(parent.context).inflate(
            R.layout.cardview_item,
        parent, false)
        return JobViewHolder(view)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val job = jobs[position]
        holder.bind(job)
    }

    override fun getItemCount(): Int = jobs.size

    class JobViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val companyLogo: ImageView = itemView.findViewById(R.id.company_logo)
        private val caregiverName: TextView = itemView.findViewById(R.id.caregiver_name)
        val jobTitle: TextView = itemView.findViewById(R.id.job_title)
        private val location: TextView = itemView.findViewById(R.id.location)

        fun bind(job: JobModel) {
            companyLogo.setImageResource(job.companyLogo)
            caregiverName.text = job.companyName
            jobTitle.text = job.jobTitle
            location.text = job.location
            // Set up favorite icon click listener here
        }
    }
}