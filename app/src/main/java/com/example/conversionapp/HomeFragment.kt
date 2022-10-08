package com.example.conversionapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.example.conversionapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater,
            R.layout.fragment_home, container, false)

        binding.submitBtn.setOnClickListener { view : View ->
            when(binding.userOptions.checkedRadioButtonId) {
                R.id.read_tutorial_option -> view.findNavController().navigate(R.id.action_homeFragment_to_tutorialFragment)
                R.id.convert_option -> view.findNavController().navigate(R.id.action_homeFragment_to_tempConversionFragment)
                else -> view.findNavController().navigate(R.id.action_homeFragment_to_quizFragment)
            }
        }

        return binding.root
    }



}