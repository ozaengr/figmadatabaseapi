package com.desire.figmadatabaseapi.database

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.desire.figmadatabaseapi.databinding.RcvAllUsersBinding


class LoginAdapter(var arrayList: ArrayList<LoginUser>) :
    RecyclerView.Adapter<LoginAdapter.LoginViewHolder>() {

    var onLoginClickListener: OnClickListener? = null

    interface OnClickListener {
        fun onRemoveClick(index: Int, loginUser: LoginUser)
        fun onEditClick(){}
    }

    fun setOnClickListener(listener: OnClickListener) {
        onLoginClickListener = listener
    }

    inner class LoginViewHolder(var view: RcvAllUsersBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(loginUser: LoginUser, index: Int) {
            view.userId.text = loginUser.id.toString()
            view.userName.text= loginUser.name
            view.userEmail.text = loginUser.emailId
            view.userId.text = loginUser.id.toString()
            view.btnDelete.setOnClickListener {
                onLoginClickListener?.onRemoveClick(index, loginUser)
            }
            view.btnDelete.setOnClickListener {
                onLoginClickListener?.onEditClick()
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoginViewHolder {
        var view: RcvAllUsersBinding =
            RcvAllUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LoginViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: LoginViewHolder, position: Int) {
        holder.bind(arrayList[position], position)

    }
    fun removeItem(index: Int, loginUser: LoginUser){
        arrayList.removeAt(index)
        notifyItemRemoved(index)
    }
}