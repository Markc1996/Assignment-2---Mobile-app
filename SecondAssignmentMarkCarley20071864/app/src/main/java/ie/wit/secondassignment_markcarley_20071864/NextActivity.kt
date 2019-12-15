package ie.wit.secondassignment_markcarley_20071864

import android.os.Bundle
//import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ie.wit.adapters.EditAdapter

class NextActivity : AppCompatActivity() {

    private var tv: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        tv = findViewById(R.id.tv) as TextView

        for (i in 0 until EditAdapter.editModelArrayList.size) {

            tv!!.text =
                tv!!.text.toString() + " " + EditAdapter.editModelArrayList.get(i).getEditTextValue() + System.getProperty(
                    "line.separator"
                )

        }

    }
}