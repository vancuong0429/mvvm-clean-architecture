package com.minor.mvvm_clean_architecture.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.minor.mvvm_clean_architecture.databinding.FragmentHomeBinding
import com.minor.mvvm_clean_architecture.ui.adapter.HomeAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private val mViewModel: HomeViewModel by viewModel()
    private lateinit var homeBinding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        homeBinding.viewmodel = mViewModel
        homeBinding.lifecycleOwner = viewLifecycleOwner
        return homeBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        configureRecyclerView()
        mViewModel.loadUsers()
    }

    private fun configureRecyclerView() {
        homeBinding.recyclerHome.adapter = HomeAdapter(mViewModel)
    }

}