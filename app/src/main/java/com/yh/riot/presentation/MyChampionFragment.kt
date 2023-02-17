package com.yh.riot.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.yh.riot.R
import com.yh.riot.databinding.FragmentChampionListBinding
import com.yh.riot.databinding.FragmentMyChampionBinding
import dagger.hilt.android.AndroidEntryPoint

class MyChampionFragment : Fragment() {

    private var _binding: FragmentMyChampionBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel
    private val championListAdapter by lazy { ChampionListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyChampionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        binding.rvChampionPreviewList.adapter = championListAdapter
        viewModel.localChampionList.observe(viewLifecycleOwner) {
            championListAdapter.addAll(it)
        }

        championListAdapter.setOnItemClickListener {
            val action = MyChampionFragmentDirections.actionFragmentMyChampionToDetailChampionFragment(it)
            findNavController().navigate(action)
        }

    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}