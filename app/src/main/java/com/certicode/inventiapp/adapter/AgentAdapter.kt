package com.certicode.inventiapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.certicode.inventiapp.R
import com.certicode.inventiapp.models.AgentModel

class AgentAdapter(private val items: List<AgentModel>) :
    RecyclerView.Adapter<AgentAdapter.AgentViewHolder>() {

    class AgentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageHolder : ImageView = itemView.findViewById(R.id.imagePlaceHolder)
        val agent : TextView = itemView.findViewById(R.id.agentName)
        val role : TextView = itemView.findViewById(R.id.broker)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.property_agent_item, parent, false) // use your layout XML filename here
        return AgentViewHolder(view)
    }

    override fun onBindViewHolder(holder: AgentViewHolder, position: Int) {
        val propertyList = items[position]
        holder.imageHolder.setImageResource(propertyList.imagePlaceHolder)
        holder.agent.text = propertyList.agentName
        holder.role.text = propertyList.agentBroker
    }

    override fun getItemCount(): Int = items.size
}