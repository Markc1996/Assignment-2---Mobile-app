package ie.wit.adapters

import android.content.Context
//import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import ie.wit.models.EditModel
import ie.wit.secondassignment_markcarley_20071864.R
import java.util.ArrayList

/**
 * Created by Parsania Hardik on 17-Apr-18.
 */

class EditAdapter(ctx: Context, editModelArrayLists: ArrayList<EditModel>) :
    RecyclerView.Adapter<EditAdapter.MyViewHolder>() {

    private val inflater: LayoutInflater


    init {

        inflater = LayoutInflater.from(ctx)
        editModelArrayList = editModelArrayLists
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EditAdapter.MyViewHolder {

        val view = inflater.inflate(R.layout.rv_item, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: EditAdapter.MyViewHolder, position: Int) {


        holder.editText.setText(editModelArrayList[position].getEditTextValue())
        Log.d("print", "yes")

    }

    override fun getItemCount(): Int {
        return editModelArrayList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var editText: EditText

        init {

            editText = itemView.findViewById(R.id.editid) as EditText

            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

                }

                override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

                    editModelArrayList[adapterPosition].setEditTextValue(editText.text.toString())
                }

                override fun afterTextChanged(editable: Editable) {

                }
            })

        }

    }

    companion object {
        lateinit var editModelArrayList: ArrayList<EditModel>
    }
}