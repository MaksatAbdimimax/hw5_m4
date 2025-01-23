package com.geeks.hw5_m4.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geeks.hw5_m4.PrefenceHelper
import com.geeks.hw5_m4.adapters.OnBoardAdapter
import com.geeks.hw5_m4.databinding.FragmentOnBoardingBinding


class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding
    val prefenceHelper = PrefenceHelper()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = OnBoardAdapter(this::onClick)
        binding.vp.adapter = adapter
    }

    private fun onClick() {
        Log.e("ololo", "onClick: ", )
        prefenceHelper.unit(requireContext())
        prefenceHelper.board = true
        findNavController().navigateUp()
    }

}