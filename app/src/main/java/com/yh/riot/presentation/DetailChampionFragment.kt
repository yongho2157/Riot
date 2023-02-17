package com.yh.riot.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.yh.riot.R
import com.yh.riot.databinding.FragmentChampionListBinding
import com.yh.riot.databinding.FragmentDetailChampionBinding
import dagger.hilt.android.AndroidEntryPoint

class DetailChampionFragment : Fragment() {

    private var _binding: FragmentDetailChampionBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel

    private val args by navArgs<DetailChampionFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailChampionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        val champ = args.champ

        with(binding) {
            Glide.with(view)
                .load(champ.url)
                .into(imgDetailChampion)

            detailTitle.text = champ.title
            detailName.text = champ.name
            detailDescription.text = champ.blurb

            detailSaveBtn.setOnClickListener {
                viewModel.saveChampion(champ)
            }
        }

    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}