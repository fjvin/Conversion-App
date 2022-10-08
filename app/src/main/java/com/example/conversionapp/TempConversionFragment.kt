package com.example.conversionapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.conversionapp.databinding.FragmentTempConversionBinding

class TempConversionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentTempConversionBinding>(inflater,
            R.layout.fragment_temp_conversion, container, false)

        binding.convertBtn.setOnClickListener { this.convertTemp(binding) }
        binding.resetBtn.setOnClickListener { this.resetInputs(binding) }

        return binding.root
    }

    private fun convertTemp(binding: FragmentTempConversionBinding) {
        /* convert temperature based on checked conversion method */

        // get input value
        val celsiusVal = binding.celsiusTemp.text.toString().toDoubleOrNull()
        val fahrenheitVal = binding.fahrenheitTemp.text.toString().toDoubleOrNull()
        var convertedValue: Double
        val isRoundUpChecked = binding.roundUp.isChecked

        // if the inputValue is null, then display empty string
        if (celsiusVal == null && fahrenheitVal == null) {
            resetInputs(binding)
            return
        }

        if (celsiusVal != null &&  fahrenheitVal == null) {
            convertedValue = celsiusToFahrenheit(celsiusVal)
            if (isRoundUpChecked) { convertedValue = kotlin.math.ceil(convertedValue) }
            binding.fahrenheitTemp.setText(convertedValue.toString())

        } else if (celsiusVal == null &&  fahrenheitVal != null) {
            convertedValue = fahrenheitToCelsius(fahrenheitVal)
            if (isRoundUpChecked) { convertedValue = kotlin.math.ceil(convertedValue) }
            binding.celsiusTemp.setText(convertedValue.toString())
        }
    }

    private fun celsiusToFahrenheit(value: Double): Double {
        /* °F = (°C × 9/5) + 32 */
        return (value * 9/5) + 32
    }

    private fun fahrenheitToCelsius(value: Double): Double {
        /* °C = (°F − 32) x 5/9 */
        return (value - 32) * 5/9
    }

    private fun resetInputs(binding: FragmentTempConversionBinding) {
        /* clear the text from edit text */
        binding.fahrenheitTemp.setText("")
        binding.celsiusTemp.setText("")
        return
    }
}