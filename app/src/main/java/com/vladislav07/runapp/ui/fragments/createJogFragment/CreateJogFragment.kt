package com.vladislav07.runapp.ui.fragments.createJogFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.vladislav07.runapp.R
import com.vladislav07.runapp.ui.models.JogUI
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_create_jog.*

@AndroidEntryPoint
class CreateJogFragment : Fragment() {
    private val viewModel: CreateJogViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_jog, container, false)
    }

    override fun onStart() {
        super.onStart()
        val navController = findNavController()

        buttonCreateJog.setOnClickListener {
            viewModel.sendNewJog(
                JogUI(
                    id = viewModel.jogUpdateLiveData.value?.id ?: 0,
                    userId = viewModel.jogUpdateLiveData.value?.userId ?: "",
                    distance = distanceJogCreate.text.toString().toDouble(),
                    time = timeJogCreate.text.toString().toInt(),
                    date = dateJogCreate.text.toString()
                )
            )

        }

        viewModel.jogAddSuccessLiveData.observe(this) {
            when (it) {
                true -> {
                    Toast.makeText(context, R.string.success, Toast.LENGTH_SHORT).show()
                    viewModel.cleanLiveDataValues()
                    navController.popBackStack()
                }
                false -> {
                    Toast.makeText(context, R.string.error_send_jog, Toast.LENGTH_SHORT).show()
                }
            }
        }

        viewModel.jogUpdateLiveData.observe(this) {
            it?.let {
                distanceJogCreate.setText(it.distance.toString())
                timeJogCreate.setText(it.time.toString())
                dateJogCreate.setText(it.date)
            }
        }
    }
}