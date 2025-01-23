package com.geeks.hw5_m4.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geeks.hw5_m4.R
import com.geeks.hw5_m4.databinding.ItemNoteBinding
import com.geeks.hw5_m4.databinding.ItemOnBoardBinding
import com.geeks.hw5_m4.models.OnBoard

class OnBoardAdapter : RecyclerView.Adapter<OnBoardAdapter.OnBoardViewHolder>() {
    val list = arrayListOf(
        OnBoard(R.raw.anim1)
    )

    inner class OnBoardViewHolder(private val binding: ItemOnBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(board: OnBoard) {
            board.anim?.let {
                binding.lottie.setAnimation(board.anim)
                binding.lottie.playAnimation()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardViewHolder {
        val binding = ItemOnBoardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OnBoardViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: OnBoardViewHolder, position: Int) {
        holder.bind(list.get(position))
    }
}