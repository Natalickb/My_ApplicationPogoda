package com.example.myapplicationpogoda.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationpogoda.MainViewModel
import com.example.myapplicationpogoda.R
import com.example.myapplicationpogoda.adapter.WeatherAdaptor
import com.example.myapplicationpogoda.adapter.WeatherModel
import com.example.myapplicationpogoda.databinding.FragmentDaysBinding


class DaysFragment : Fragment(),WeatherAdaptor.Listener {
    private lateinit var binding: FragmentDaysBinding
    private lateinit var adapter: WeatherAdaptor
    private val model: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDaysBinding.inflate(inflater,container,false)
        return binding. root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        model.liveDataList.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
    }

    private fun init() = with(binding){
       adapter = WeatherAdaptor(this@DaysFragment)
        rcView.layoutManager = LinearLayoutManager(activity)
        rcView.adapter = adapter
    }

    companion object {

        @JvmStatic
        fun newInstance() = DaysFragment()
    }

    override fun onClick(item: WeatherModel) {
        model.liveDataCurrent.value =item
    }
}