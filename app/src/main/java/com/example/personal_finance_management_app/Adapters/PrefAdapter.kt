package com.example.personal_finance_management_app.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.personal_finance_management_app.DataClasses.SuggestionModel
import com.example.personal_finance_management_app.R

class PrefAdapter(private val sugList: ArrayList<SuggestionModel>) :
    RecyclerView.Adapter<PrefAdapter.ViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }
    inner class ViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {

        val tvSuggestion : TextView = itemView.findViewById(R.id.tvSuggestion2)
        val tvBankName : TextView = itemView.findViewById(R.id.tvBankName2)
        val tvFinType : TextView = itemView.findViewById(R.id.tvFinType2)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_finance_preferencess_list, parent, false)
        return ViewHolder(itemView, mListener)
    }
    override fun getItemCount(): Int {
        return sugList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tvSuggestion.text = sugList[position].suggetion
        holder.tvBankName.text = sugList[position].bankName
        holder.tvFinType.text = sugList[position].finType
    }





}