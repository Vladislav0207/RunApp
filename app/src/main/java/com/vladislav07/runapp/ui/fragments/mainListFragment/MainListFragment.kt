package com.vladislav07.runapp.ui.fragments.mainListFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.vladislav07.runapp.R
import com.vladislav07.runapp.ui.fragments.adapters.JogAdapter
import com.vladislav07.runapp.ui.fragments.callbacks.JogItemClick
import com.vladislav07.runapp.ui.fragments.createJogFragment.CreateJogViewModel
import com.vladislav07.runapp.ui.models.JogUI
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main_list.*
import kotlinx.android.synthetic.main.nav_header.*

@AndroidEntryPoint
class MainListFragment : Fragment() {

    private lateinit var navController: NavController
    private val viewModel: MainListViewModel by viewModels()
    private val sharedViewModel: CreateJogViewModel by activityViewModels()

    private val jogCallback = object : JogItemClick {
        override fun updateJog(adapterPosition: Int) {
            sharedViewModel.setJogForUpdate(
                viewModel.jogListLiveData.value?.get(adapterPosition)
            )
            navController.navigate(R.id.createJogFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_list, container, false)
    }

    override fun onStart() {
        super.onStart()
        navController = findNavController()

        viewModel.getJogs()
        val listJogs = mutableListOf<JogUI>()

        jogRecycler.adapter = JogAdapter(context, listJogs, jogCallback)
        jogRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        viewModel.jogListLiveData.observe(this)
        {
            listJogs.clear()
            listJogs.addAll(it)
            jogRecycler.adapter?.notifyDataSetChanged()
        }

        fun setNavHeaderInfo(
            firstName: String,
            lastName: String,
            email: String
        ) {
            activity?.firstNameHeader?.text = firstName
            activity?.lastNameHeader?.text = lastName
            activity?.emailHeader?.text = email
        }

        viewModel.userLiveData.observe(this)
        {
            setNavHeaderInfo(
                firstName = it.firstName,
                lastName = it.lastName,
                email = it.email
            )
        }

        addJogButton.setOnClickListener {
            navController.navigate(R.id.createJogFragment)
        }
    }
}