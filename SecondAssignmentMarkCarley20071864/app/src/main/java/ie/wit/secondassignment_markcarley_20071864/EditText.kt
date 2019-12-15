package ie.wit.secondassignment_markcarley_20071864

//import android.support.v7.app.AppCompatActivity
//import android.support.v7.widget.LinearLayoutManager
//import android.support.v7.widget.RecyclerView


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ie.wit.adapters.EditAdapter
import ie.wit.models.EditModel
import java.util.*

class EditText : AppCompatActivity() {

    private var btn: Button? = null
    private var recyclerView: RecyclerView? = null
    private var customAdapter: EditAdapter? = null
    lateinit var editModelArrayList: ArrayList<EditModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler) as RecyclerView
        btn = findViewById(R.id.btn) as Button

        editModelArrayList = populateList()
        customAdapter = EditAdapter(this, editModelArrayList)
        recyclerView!!.adapter = customAdapter
        recyclerView!!.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        btn!!.setOnClickListener {
            val intent = Intent(this@EditText, NextActivity::class.java)
            startActivity(intent)
        }

    }

    private fun populateList(): ArrayList<EditModel> {

        val list = ArrayList<EditModel>()

        for (i in 0..7) {
            val editModel = EditModel()
            editModel.setEditTextValue(i.toString())
            list.add(editModel)
        }

        return list
    }

}