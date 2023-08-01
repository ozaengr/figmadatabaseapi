package com.desire.figmadatabaseapi.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.desire.figmadatabaseapi.api.User
import com.desire.figmadatabaseapi.databinding.RcvListBinding

class UserAdapter(var arrayList: ArrayList<User>) :
    RecyclerView.Adapter<UserAdapter.LoginViewHolder>() {

    fun deleteItem(index: Int){
        arrayList.removeAt(index)
        notifyDataSetChanged()
    }

    var onItemClick : ((User) -> Unit)? = null

    inner class LoginViewHolder(var view: RcvListBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(user: User, index: Int) {
            view.rcvName.text = user.category
            view.rcvDiscription.text = user.price.toString()
            Glide.with(view.rcvImage).load(user.image).into(view.rcvImage)
            view.btnDelete.setOnClickListener {
                onItemClick?.invoke(arrayList.get(index))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoginViewHolder {
        var view: RcvListBinding =
            RcvListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LoginViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: LoginViewHolder, position: Int) {
        holder.bind(arrayList[position], position)

    }
}