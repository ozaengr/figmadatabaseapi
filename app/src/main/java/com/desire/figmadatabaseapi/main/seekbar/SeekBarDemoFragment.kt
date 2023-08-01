package com.desire.figmadatabaseapi.main.seekbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.desire.figmadatabaseapi.databinding.FragmentSeekbardemoBinding

class SeekBarDemoFragment : Fragment() {


    private lateinit var binding: FragmentSeekbardemoBinding
    var arrayListOfUser = arrayListOf<SeekData>()
    private lateinit var loginadapter: SeekAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSeekbardemoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        ivBack()
    }

    private fun ivBack() {
        binding.ivBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun initView() {
        for (i in 1..50) {
            arrayListOfUser.add(SeekData(0))
        }
        loginadapter = SeekAdapter(arrayListOfUser)
        binding.rcvAllUsers.adapter = loginadapter
    }

}