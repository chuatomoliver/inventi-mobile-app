package com.certicode.inventiapp.models

import android.os.Parcelable
import android.widget.ImageView
import android.widget.TextView
import kotlinx.parcelize.Parcelize

@Parcelize
data class AgentListModel (
    val imagePlaceHolder: Int,
    val agentName: String,
    val agentProfession: String,
    val description: String
) : Parcelable


