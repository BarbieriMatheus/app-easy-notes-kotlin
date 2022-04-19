package br.com.easynotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.easynotes.adapter.ItemAdapter
import br.com.easynotes.database.Database
import br.com.easynotes.model.Note
import com.example.easynotes.AddNote
import com.example.easynotes.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListNotesActivity : AppCompatActivity(), ItemAdapter.OnNoteClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Database.notes.add(Note("Estudar Kotlin", "Estudar Kotlin"))
        Database.notes.add(Note("Estudar Flutter", "Estudar Flutter"))

        Log.i("DADOS", Database.notes.toString())
        val rvNotes: RecyclerView = findViewById(R.id.rvNotes)
        rvNotes.layoutManager = LinearLayoutManager(this)

        rvNotes.adapter = ItemAdapter(Database.notes, this)

        val fabAddNote: FloatingActionButton = findViewById(R.id.fabAddNote)
        fabAddNote.setOnClickListener {
            val intent = Intent(this, AddNote::class.java)
            startActivity(intent)
        }
    }

    override fun onNoteClick(notePosition: Int) {
//        val intent = Intent(this, VisualizarActivity::class.java)
//        intent.putExtra("dados", Database.listaCompras[produtoPosition])
//        startActivity(intent)
    }
}