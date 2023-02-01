package com.example.androiddiary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import com.example.androiddiary.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        populateList()

        binding.addNoteBtn.setOnClickListener {
            floatingActionButtonClick()
        }
    }

    fun floatingActionButtonClick () {
        val intent = Intent(this, DiaryEditorActivity::class.java)
        startActivity(intent)
    }

    // ------- EXAMPLE OF LIST POPULATION ------------- //
    fun populateList (){
        var noteList = listOf("note 1", "note 2", "note 3")

        // Creating an ArrayAdapter connected to a listView.
        // ArrayAdapter takes 3 arguments, (context, layout of the desired item, combined list of items a.k.a your notes)
        binding.listView.adapter = ArrayAdapter(this, R.layout.simple_list_item, noteList)
    }

}