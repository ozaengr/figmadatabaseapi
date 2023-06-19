package com.desire.figmadatabaseapi.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.desire.figmadatabaseapi.databinding.RcvListBinding

class RcvAdapter(val rcvArray: ArrayList<RcvModel>) :
    RecyclerView.Adapter<RcvAdapter.RcvViewHolder>() {
    class RcvViewHolder(var view: RcvListBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(rcvModel: RcvModel) {
            view.rcvName.text = rcvModel.category
            view.rcvDiscription.text = rcvModel.description
            Glide.with(view.rcvImage).load(rcvModel.image).into(view.rcvImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RcvViewHolder {
        val view: RcvListBinding =
            RcvListBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return RcvViewHolder(view)
    }

    override fun getItemCount(): Int {
        return rcvArray.size
    }

    override fun onBindViewHolder(holder: RcvViewHolder, position: Int) {
        holder.bind(rcvArray[position])
    }
}