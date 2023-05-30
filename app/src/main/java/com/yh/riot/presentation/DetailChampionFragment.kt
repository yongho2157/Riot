package com.yh.riot.presentation

import android.os.Bundle
import android.util.Log
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
    private lateinit var champSpellAdapter: ChampSpellAdapter

    private val args by navArgs<DetailChampionFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentDetailChampionBinding.inflate(inflater, container, false)
        champSpellAdapter = ChampSpellAdapter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val champ = args.champ
        champ.url =
            "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/" + champ.id + "_0.jpg"
        with(binding) {
            Glide.with(view)
                .load(champ.url)
                .into(imgDetailChampion)

            detailTitle.text = champ.title
            detailName.text = champ.name
            rvSpellList.adapter = champSpellAdapter
        }
        viewModel = (activity as MainActivity).viewModel
        viewModel.getChampInfo(champId = champ.id)
        viewModel.champInfoList.observe(viewLifecycleOwner) {
            champSpellAdapter.deleteAllChampSpells()
            for (i in it.indices) {
                for (spell in it[i].spells) {
                    Log.d("결과", "spell : $spell")
                    champSpellAdapter.addChampSpell(spell)
                }
            }
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}