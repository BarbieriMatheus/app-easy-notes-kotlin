package br.com.easynotes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.easynotes.model.Note
import com.example.easynotes.R

class ItemAdapter(val notes: List<Note>, val onNoteClickListener: OnNoteClickListener) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(
        view: View, val onNoteClickListener
        : OnNoteClickListener
    ) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val tvNoteTitle: TextView = view.findViewById(R.id.tvNoteTitle)
        val cvItemNote: CardView = view.findViewById(R.id.cvItemNote)

        init {
            cvItemNote.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            onNoteClickListener.onNoteClick(adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lista, parent, false)
        return ItemViewHolder(adapterLayout, onNoteClickListener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val note = notes[position]
        holder.tvNoteTitle.text = note.title
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    interface OnNoteClickListener {
        fun onNoteClick(notePosition: Int)
    }
}