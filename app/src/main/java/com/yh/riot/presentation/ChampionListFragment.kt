package com.yh.riot.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.yh.riot.R
import com.yh.riot.databinding.FragmentChampionListBinding


class ChampionListFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()
    private var _binding: FragmentChampionListBinding? = null
    private val binding get() = _binding!!
    private val championListAdapter by lazy { ChampionListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentChampionListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvChampionPreviewList.adapter = championListAdapter
        viewModel.currentChampionList.observe(requireActivity()) {
            Log.d("결과", "list : $it")
            championListAdapter.addAll(it)
        }
        viewModel.getChamp()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}