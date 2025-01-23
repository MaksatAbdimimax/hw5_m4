package com.geeks.hw5_m4.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geeks.hw5_m4.R
import com.geeks.hw5_m4.adapters.NotesAdapter
import com.geeks.hw5_m4.adapters.OnBoardAdapter
import com.geeks.hw5_m4.databinding.FragmentNotesBinding
import com.geeks.hw5_m4.databinding.FragmentOnBoardingBinding
import com.geeks.hw5_m4.models.Notes1


class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = OnBoardAdapter()
        binding.vp.adapter = adapter
    }

}