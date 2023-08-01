package com.desire.figmadatabaseapi.main.allUser

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.desire.figmadatabaseapi.database.LoginAdapter
import com.desire.figmadatabaseapi.database.LoginUser
import com.desire.figmadatabaseapi.databinding.FragmentAllUserBinding

class AllUserFragment : Fragment() {


    private lateinit var binding: FragmentAllUserBinding
    private lateinit var allUserViewModel: AllUserViewModel
    var arrayListOfUser = arrayListOf<LoginUser>()
    private lateinit var loginadapter: LoginAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        allUserViewModel = ViewModelProvider(this).get(AllUserViewModel::class.java)
        binding = FragmentAllUserBinding.inflate(layoutInflater)
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
        allUserViewModel.getData().observe(viewLifecycleOwner) {
            if (it != null) {
                arrayListOfUser.addAll(it)
                loginadapter = LoginAdapter(arrayListOfUser)
                binding.rcvAllUsers.adapter = loginadapter
                loginadapter.setOnClickListener(object : LoginAdapter.OnClickListener {
                    override fun onRemoveClick(index: Int, loginUser: LoginUser) {
                        Log.i("test", " ${index}")
                        deleteUser(index, loginUser)
                    }

                    override fun onEditClick() {
                        super.onEditClick()
                    }
                })
            } else {
                Toast.makeText(requireContext(), "User not found", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun deleteUser(index: Int, loginUser: LoginUser) {
        allUserViewModel.deleteData(loginUser).observe(viewLifecycleOwner) {
            if (it) {
                loginadapter.removeItem(index,loginUser)
            }
        }
    }

}