package com.desire.figmadatabaseapi.main.pass

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.desire.figmadatabaseapi.databinding.RcvListBinding
import com.desire.figmadatabaseapi.retrofit.User

class ProductAdapter(var productArray: ArrayList<User>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    class ProductViewHolder(var view: RcvListBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(user: User) {
            view.rcvName.text = user.category
            view.rcvDiscription.text = user.price.toString()
            Glide.with(view.rcvImage).load(user.image).into(view.rcvImage)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        var view: RcvListBinding =
            RcvListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(view)
    }


    override fun getItemCount(): Int {
        return productArray.size
    }


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productArray[position])
    }
}