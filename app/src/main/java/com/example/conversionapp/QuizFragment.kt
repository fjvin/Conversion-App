package com.example.conversionapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.conversionapp.databinding.FragmentQuizBinding


class QuizFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentQuizBinding>(inflater,
            R.layout.fragment_quiz, container, false)

        binding.submitBtn.setOnClickListener { computeScore(binding) }

        return binding.root
    }

    private fun computeScore(binding: FragmentQuizBinding) {

        var totalScore = 0

        when (binding.q1Choices.checkedRadioButtonId) {
            R.id.q1_celsius_option -> totalScore += 1
        }
        when (binding.q2Choices.checkedRadioButtonId) {
            R.id.q2_fahrenheit_option -> totalScore += 1
        }
        when (binding.q3Choices.checkedRadioButtonId) {
            R.id.q3_kelvin_option -> totalScore += 1
        }
        when (binding.q4Choices.checkedRadioButtonId) {
            R.id.q4_option_one -> totalScore += 1
        }
        when (binding.q5Choices.checkedRadioButtonId) {
            R.id.q5_option_two -> totalScore += 1
        }
        Toast.makeText(requireContext(), "Total Score: $totalScore", Toast.LENGTH_SHORT).show()
    }
}