package com.vladislav07.runapp.ui.fragments.feedbackFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.vladislav07.runapp.R
import com.vladislav07.runapp.ui.models.FeedbackUI
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_feedback.*

@AndroidEntryPoint
class FeedbackFragment : Fragment() {

    private val viewModel : FeedbackViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feedback, container, false)
    }

    override fun onStart() {
        super.onStart()
        val navController = findNavController()
        sendFeedbackButton.setOnClickListener {
            viewModel.sendFeedback(
                FeedbackUI(
                    topic = topicFeedback.text.toString(),
                    text = textFeedback.text.toString()
                )
            )
            navController.navigate(R.id.mainListFragment)
        }
    }
}