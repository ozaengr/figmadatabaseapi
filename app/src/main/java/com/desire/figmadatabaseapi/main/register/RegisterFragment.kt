package com.desire.figmadatabaseapi.main.register

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextUtils
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.desire.figmadatabaseapi.database.EntityData
import com.desire.figmadatabaseapi.databinding.FragmentRegisterBinding
import com.desire.figmadatabaseapi.main.base.BaseFragment

class RegisterFragment : BaseFragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        registerViewModel = ViewModelProvider(this)[RegisterViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        onClickLoginText()
    }

    private fun initView() {
        binding.btnRegister.setOnClickListener {
            if (binding.textInputName.text.toString().isEmpty() ||
                binding.textInputEmail.text.toString().isEmpty() ||
                binding.textInputPassword.text.toString().isEmpty() ||
                binding.textInputPasswordConfirm.text.toString().isEmpty()
            ) {
                showToast("Please enter all field")
            } else if (!isValidEmail(binding.textInputEmail.text.toString())) {
                Toast.makeText(
                    requireContext(),
                    "Please enter valid email address",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (!isValidPasswordPattern(binding.textInputPassword.text.toString())) {
                Toast.makeText(
                    requireContext(),
                    "Please enter valid Password Pattern",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (binding.textInputPassword.text.toString() !=
                binding.textInputPasswordConfirm.text.toString()
            ) {
                Toast.makeText(requireContext(), "Password is not matching", Toast.LENGTH_SHORT)
                    .show()
            } else if (binding.checkboxTerms.isChecked != true) {
                Toast.makeText(
                    requireContext(),
                    "Please accept Terms of Use and Privacy Policy",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    requireContext(),
                    "User Registation is Successful.",
                    Toast.LENGTH_SHORT
                ).show()

                val entityData = EntityData()
                entityData.name = binding.textInputName.text.toString()
                entityData.emailId = binding.textInputEmail.text.toString()
                entityData.password = binding.textInputPassword.text.toString()

                registerViewModel.addUser(entityData)


                findNavController().navigateUp()
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPasswordPattern(passwrod: String): Boolean {
        val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$"
        val passwordMatcher = Regex(passwordPattern)
        return passwordMatcher.find(passwrod) != null
    }

    private fun onClickLoginText() {
        val titleIntro = "Already have an account? Log in"
        val spannableString = SpannableString(titleIntro)
        val clickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                findNavController().navigateUp()
            }
        }

        spannableString.setSpan(clickableSpan, 25, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.tvLoginBack.text = spannableString
        binding.tvLoginBack.setText(spannableString, TextView.BufferType.SPANNABLE)
        binding.tvLoginBack.movementMethod = LinkMovementMethod.getInstance()
    }


}