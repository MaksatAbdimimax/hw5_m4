package com.geeks.hw5_m4.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geeks.hw5_m4.databinding.ItemNoteBinding
import com.geeks.hw5_m4.models.Notes1

class NotesAdapter(private val notes: ArrayList<Notes1>) : ListAdapter<Notes1,NotesAdapter.NotesViewHolder>(DiffCallback()) {
    /*fun setData(notes: List<Notes1>){
        this.notes.clear()
        this.notes.addAll(notes)
        notifyDataSetChanged()
    }*/
    inner class NotesViewHolder(private val binding: ItemNoteBinding) :
            RecyclerView.ViewHolder(binding.root){
            fun bind(note: Notes1) {
                binding.tvTitle.text = note.title
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val binding =  ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(notes.get(position))
    }

    class DiffCallback : DiffUtil.ItemCallback<Notes1>() {
        override fun areItemsTheSame(oldItem: Notes1, newItem: Notes1): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Notes1, newItem: Notes1): Boolean {
            return  oldItem.title == newItem.title
        }
    }

}