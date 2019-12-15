package ie.wit.secondassignment_markcarley_20071864

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ie.wit.models.PlacemarkModel
import kotlinx.android.synthetic.main.activity_add_remove.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast


class AddRemoveActivity : AppCompatActivity(), AnkoLogger {

    var Placemark = PlacemarkModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_remove)
        info("Placemark Activity started..")

        btnAdd.setOnClickListener() {
            Placemark.title = placemarkTitle.text.toString()
            if (Placemark.title.isNotEmpty()) {
                info("add Button Pressed: $placemarkTitle")

            }
            else {
                toast ("Please Enter a title")
            }
        }
    }
}
