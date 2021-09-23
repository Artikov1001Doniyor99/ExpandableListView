package com.example.modul_5_2_lesson1

import adapter.ExpandableAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.ExpandableListView.OnGroupExpandListener




/*1-topshiriq

Rasmda ko'rsatilgan ro'yxatni shakllantiring.
 ExpandableListView child itemlari bosilganda boshqa oynada shu itemga
 tegishli ma'lumot to'g'risidagi rasm chiqsin.*/

class MainActivity : AppCompatActivity() {

    lateinit var map:HashMap<String,List<String>>
    lateinit var titleList:ArrayList<String>

    lateinit var expandableAdapter: ExpandableAdapter

    private var lastPosition = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()

        expandableAdapter = ExpandableAdapter(titleList,map)
        expandable_list_view.setAdapter(expandableAdapter)

      /*  expandable_list_view.setOnGroupClickListener { expandableListView, view, i, l ->
            Toast.makeText(this, titleList[i], Toast.LENGTH_SHORT).show()
            true
        }*/

        expandable_list_view.setOnGroupCollapseListener {
            Toast.makeText(this, "Collapse -> $it", Toast.LENGTH_SHORT).show()
        }

        expandable_list_view.setOnGroupExpandListener {
            Toast.makeText(this, "Expand -> $it", Toast.LENGTH_SHORT).show()
        }

        expandable_list_view.setOnChildClickListener { expandableListView, view, i, i2, l ->
            Toast.makeText(this, map[titleList[i]]?.get(i2), Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SecondActivity::class.java)
            val keys = map[titleList[i]]
            val values = map[titleList[i]]?.get(i2)

            println(map[titleList[i]])

            intent.putExtra("Father",i)
            intent.putExtra("Child",i2)
            startActivity(intent)
            true
        }

        expandable_list_view.setOnGroupExpandListener(OnGroupExpandListener { groupPosition ->
            if (lastPosition !== -1
                && groupPosition != lastPosition
            ) {
               expandable_list_view.collapseGroup(lastPosition)
            }
            lastPosition = groupPosition
        })

    }


    private fun loadData() {
        map = HashMap()
        val spainList = arrayListOf("Apple","Mango","Banana","Orange")
        map["Fruits"] = spainList
        val englangList = arrayListOf("Rose","Lily","Tulip")
        map["Flowers"] = englangList
        val italyList = arrayListOf("Tiger","Bear","Wolf")
        map["Animals"] = italyList
        val birdList = arrayListOf("Goose","Penguin","Owl")
        map["Birds"] = birdList

        titleList = ArrayList()
        titleList.add("Fruits")
        titleList.add("Flowers")
        titleList.add("Animals")
        titleList.add("Birds")



    }
}