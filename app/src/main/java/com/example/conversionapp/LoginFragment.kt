package com.example.conversionapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.conversionapp.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater,
            R.layout.fragment_login, container, false)

        binding.loginBtn.setOnClickListener { view?.let { it1 ->
            this.checkLoginCredentials(binding,
                it1
            )
        } }
        return binding.root
    }

    private fun checkLoginCredentials(binding: FragmentLoginBinding, view: View) {
        if (binding.username.text.toString() == "qfveatabay" && binding.password.text.toString() == "password") {
            view.findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }
        else {
            Toast.makeText(requireContext(), "Incorrect Username or Password", Toast.LENGTH_SHORT).show()
        }
    }


}