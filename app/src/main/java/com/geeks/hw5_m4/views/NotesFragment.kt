package com.geeks.hw5_m4.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.geeks.hw5_m4.PrefenceHelper
import com.geeks.hw5_m4.R
import com.geeks.hw5_m4.adapters.NotesAdapter
import com.geeks.hw5_m4.databinding.FragmentNotesBinding
import com.geeks.hw5_m4.extensions.getBackStackData
import com.geeks.hw5_m4.models.Notes1


class NotesFragment : Fragment() {
    private lateinit var binding: FragmentNotesBinding
    private lateinit var adapter: NotesAdapter
    private val notes = ArrayList<Notes1>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        initialize()

    }



    private fun initialize() {

        adapter = NotesAdapter(notes)
        binding.rvNotes.adapter = adapter

        binding.btnAdd.setOnClickListener(){
            findNavController().navigate(NotesFragmentDirections.actionNotesFragmentToWriteNoteFragment())
        }
        val pref = PrefenceHelper()
        pref.unit(requireContext())
       // pref.text?.let { Notes1(it) }?.let { notes.add(it) }
    }
    private fun getData(){
        getBackStackData<String>("key"){
            val note =  Notes1(it)

            notes.add(note)
            adapter.submitList(notes)
        }
    }

}