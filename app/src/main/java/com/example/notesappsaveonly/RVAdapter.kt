package com.example.notesappsaveonly

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_item.view.*

class RVAdapter(private val notes : ArrayList<String>):RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        return ItemViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(
                R.layout.row_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var note = notes[position]
        holder.itemView.apply {
            tv_note.text = note
        }
    }

    override fun getItemCount() = notes.size
}
