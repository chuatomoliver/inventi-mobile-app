package com.certicode.inventiapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.certicode.inventiapp.R
import com.certicode.inventiapp.models.AgentListModel

class AgentListAdapter
    (
    private val agentList: List<AgentListModel>
            )
    : RecyclerView.Adapter<AgentListAdapter.AgentViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.agents_list_item,parent,false)
        return AgentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AgentViewHolder, position: Int) {
        val agent = agentList[position]
        holder.imagePlaceHolder.setImageResource(agent.imagePlaceHolder)
        holder.agentName.text = agent.agentName
        holder.agentProfession.text = agent.agentProfession
    }

    class   AgentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val imagePlaceHolder = itemView.findViewById<ImageView>(R.id.imagePlaceHolder)
        val agentName = itemView.findViewById<TextView>(R.id.agentName)
        val agentProfession = itemView.findViewById<TextView>(R.id.agentProfession)
    }

    override fun getItemCount() = agentList.size
}