package com.geeks.hw5_m4.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geeks.hw5_m4.R
import com.geeks.hw5_m4.databinding.ItemNoteBinding
import com.geeks.hw5_m4.databinding.ItemOnBoardBinding
import com.geeks.hw5_m4.models.OnBoard

class OnBoardAdapter(private val onClick: () -> Unit) : RecyclerView.Adapter<OnBoardAdapter.OnBoardViewHolder>() {
    val list = arrayListOf(
        OnBoard(R.raw.anim1, "Удобство", "Создавайте заметки в два клика! Записывайте мысли, идеи и важные задачи мгновенно."),
        OnBoard(R.raw.anim1, "Организация", "Организуйте заметки по папкам и тегам. Легко находите нужную информацию в любое время."),
        OnBoard(R.raw.anim1, "Синхронизация", "Синхронизация на всех устройствах. Доступ к записям в любое время и в любом месте."),
    )

    inner class OnBoardViewHolder(private val binding: ItemOnBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(board: OnBoard) {
            binding.btnStart.setOnClickListener{
                onClick()
            }
            binding.tvSkip.setOnClickListener{
                onClick()
            }
            board.anim?.let {
                binding.lottie.setAnimation(board.anim)
                binding.lottie.playAnimation()
            }
            binding.tvTitle.text = board.title
            binding.tvDesc.text = board.desc
            if (adapterPosition == list.lastIndex) binding.btnStart.visibility =
                View.VISIBLE else binding.btnStart.visibility = View.GONE

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