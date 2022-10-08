package com.example.myapplicationpogoda.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationpogoda.R
import com.example.myapplicationpogoda.adapter.WeatherAdaptor
import com.example.myapplicationpogoda.adapter.WeatherModel
import com.example.myapplicationpogoda.databinding.FragmentHoursBinding


class HoursFragment : Fragment() {
    private lateinit var binding: FragmentHoursBinding
    private lateinit var adapter: WeatherAdaptor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHoursBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()
    }
    private fun initRcView()  = with(binding){
        rcView.layoutManager = LinearLayoutManager(activity)
        adapter = WeatherAdaptor()
        rcView.adapter = adapter
        val  list = listOf(
            WeatherModel(
                "", time = "12", "Sunny",
                "25", "", "","",""),
            WeatherModel(
                "", time = "13", "Sunny",
                "26", "", "","",""),
                WeatherModel(
                    "", time = "14", "Sunny",
                    "35", "", "","","")
        )
        adapter.submitList(list)
    }

    companion object {

        @JvmStatic
        fun newInstance() = HoursFragment()
    }
}