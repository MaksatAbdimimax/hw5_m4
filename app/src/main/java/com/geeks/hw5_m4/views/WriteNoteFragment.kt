package com.geeks.hw5_m4.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geeks.hw5_m4.PrefenceHelper
import com.geeks.hw5_m4.R
import com.geeks.hw5_m4.databinding.FragmentWriteNoteBinding
import com.geeks.hw5_m4.extensions.setBackStackData


class WriteNoteFragment : Fragment() {
    private lateinit var binding: FragmentWriteNoteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWriteNoteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
    }

    private fun setListener() {
        binding.apply {
            btnSave.setOnClickListener{
                val title = binding.etTitle.text.toString()
                setBackStackData("key", title, true)
                val pref = PrefenceHelper()
                pref.unit(requireContext())
                pref.text=title
            }
        }
    }
}