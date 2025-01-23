package com.geeks.hw5_m4.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geeks.hw5_m4.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
    }
        private fun setupListener(){
            binding.btnSave.setOnClickListener(){
                val data = " ${binding.etName.text} ${binding.etEmail.text}  ${binding.etPassword.text}"
                findNavController().navigate(
                    FirstFragmentDirections.actionFirstFragmentToSecondFragment(
                        data
                    )
                )
            }
        }
}