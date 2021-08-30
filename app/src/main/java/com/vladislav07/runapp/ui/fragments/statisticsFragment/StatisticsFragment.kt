package com.vladislav07.runapp.ui.fragments.statisticsFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.vladislav07.runapp.R
import com.vladislav07.runapp.ui.fragments.adapters.StatisticsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_statistics.*

@AndroidEntryPoint
class StatisticsFragment : Fragment() {
    private val viewModel : StatisticsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_statistics, container, false)
    }

    override fun onStart() {
        super.onStart()

        viewModel.getStatistics()
        val adapter = viewModel.statisticsListLiveData.value?.let { StatisticsAdapter(context, it) }
        statisticsRecycler.adapter = adapter
        statisticsRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        viewModel.statisticsListLiveData.observe(this)
        {
            statisticsRecycler.adapter?.notifyDataSetChanged()
        }
    }
}