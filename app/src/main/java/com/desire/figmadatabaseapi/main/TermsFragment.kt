package com.desire.figmadatabaseapi.main

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.desire.figmadatabaseapi.databinding.FragmentTermsBinding

class TermsFragment : Fragment() {

    private lateinit var binding: FragmentTermsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTermsBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ivBack()


    }

    private fun ivBack() {
        binding.ivBack.setOnClickListener {
            findNavController().navigateUp()

        }
    }

}