package ie.wit.secondassignment_markcarley_20071864

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            val intent = Intent(this, TableActivity::class.java)
            startActivity(intent)

            }

        btn1.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)

        }

        btn2.setOnClickListener {
            val intent = Intent(this, ImageUpload::class.java)
            startActivity(intent)

        }

        btn3.setOnClickListener {
            val intent = Intent(this, AddRemoveActivity::class.java)
            startActivity(intent)

        }


        btn4.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)

        }



        }
    }
