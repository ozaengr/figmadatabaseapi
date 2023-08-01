package com.desire.figmadatabaseapi.main.seekbar

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.recyclerview.widget.RecyclerView
import com.desire.figmadatabaseapi.databinding.ItemSeekbarBinding
import com.desire.figmadatabaseapi.databinding.RcvAllUsersBinding


class SeekAdapter(var arrayList: ArrayList<SeekData>) :
    RecyclerView.Adapter<SeekAdapter.LoginViewHolder>() {


    inner class LoginViewHolder(var view: ItemSeekbarBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(seekData: SeekData, index: Int) {
          view.seekbar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener{
              /**
               * Notification that the progress level has changed. Clients can use the fromUser parameter
               * to distinguish user-initiated changes from those that occurred programmatically.
               *
               * @param seekBar The SeekBar whose progress has changed
               * @param progress The current progress level. This will be in the range min..max where min
               * and max were set by [ProgressBar.setMin] and
               * [ProgressBar.setMax], respectively. (The default values for
               * min is 0 and max is 100.)
               * @param fromUser True if the progress change was initiated by the user.
               */
              override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                  seekData.value = progress
              }

              /**
               * Notification that the user has started a touch gesture. Clients may want to use this
               * to disable advancing the seekbar.
               * @param seekBar The SeekBar in which the touch gesture began
               */
              override fun onStartTrackingTouch(seekBar: SeekBar?) {

              }

              /**
               * Notification that the user has finished a touch gesture. Clients may want to use this
               * to re-enable advancing the seekbar.
               * @param seekBar The SeekBar in which the touch gesture began
               */
              override fun onStopTrackingTouch(seekBar: SeekBar?) {

              }

          })
        view.seekbar.progress = seekData.value
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoginViewHolder {
        var view: ItemSeekbarBinding =
            ItemSeekbarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LoginViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: LoginViewHolder, position: Int) {
        holder.bind(arrayList[position], position)

    }

}