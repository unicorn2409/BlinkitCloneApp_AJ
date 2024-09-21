package com.example.blinkitcloneapp.auth

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.blinkitcloneapp.R
import com.example.blinkitcloneapp.databinding.FragmentOTPBinding

class OTPFragment : Fragment() {

    private lateinit var userNumber: String
    private lateinit var binding: FragmentOTPBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOTPBinding.inflate(layoutInflater)

        getUserNumber()
        customizeEnteringOTP()
        onBackButtonClick()

        return binding.root
    }

    private fun onBackButtonClick() {
        binding.tbOtpFragment.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_OTPFragment_to_signInFragment)
        }
    }

    private fun customizeEnteringOTP() {
        val editTexts = arrayOf( binding.etOtp1, binding.etOtp2, binding.etOtp3, binding.etOtp4, binding.etOtp5, binding.etOtp6)

        for(i in editTexts.indices){
            editTexts[i].addTextChangedListener(object: TextWatcher{
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable?) {
                    if(s?.length == 1){
                        if(i < editTexts.size - 1){
                            editTexts[i+1].requestFocus()
                        }
                    }else if(s?.length == 0){
                        if(i > 0){
                            editTexts[i-1].requestFocus()
                        }
                    }
                }

            })
        }


    }

    private fun getUserNumber() {
        val bundle = arguments
        userNumber = bundle?.getString("number").toString()
        binding.tvUserNumber.text = userNumber
    }
}