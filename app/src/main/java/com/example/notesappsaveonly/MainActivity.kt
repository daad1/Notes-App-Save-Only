package com.example.notesappsaveonly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var etNote: EditText
    private lateinit var btnSubmit: Button
    private lateinit var rvMain: RecyclerView
    private lateinit var adapter: RVAdapter
    private lateinit var notes: MutableList<String>

    private val databaseHelper by lazy { DatabaseHelper(applicationContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNote = findViewById(R.id.etNote)
        btnSubmit = findViewById(R.id.btnSubmit)
        rvMain = findViewById(R.id.rvMain)

        notes = mutableListOf()
        adapter = RVAdapter(notes as ArrayList<String>)
        rvMain.adapter = adapter
        rvMain.layoutManager = LinearLayoutManager(this)

        btnSubmit.setOnClickListener {

            val note = etNote.text.toString()

            if (note.isNotEmpty()) {
                databaseHelper.saveNoteData(note)
                notes.add(note)

                Toast.makeText(this, "Added successfully", Toast.LENGTH_SHORT).show()

                adapter = RVAdapter(notes as ArrayList<String>)
                rvMain.adapter = adapter


            }

            else {
                Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()
            }
        }


    }
}