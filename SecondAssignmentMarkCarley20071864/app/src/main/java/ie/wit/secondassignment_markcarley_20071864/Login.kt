package ie.wit.secondassignment_markcarley_20071864

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import java.util.*

class Login : AppCompatActivity() {

    private val MY_REQUEST_CODE: Int = 7117 // ANY number

    lateinit var providers : List<AuthUI.IdpConfig>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn10.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }


        //Init
        providers = Arrays.asList<AuthUI.IdpConfig>(
            AuthUI.IdpConfig.EmailBuilder().build(),// email login
            AuthUI.IdpConfig.FacebookBuilder().build(),// Facebook login
            AuthUI.IdpConfig.GoogleBuilder().build(),// Google login
            AuthUI.IdpConfig.PhoneBuilder().build() // Phone login
        )


        showSignInOptions()

        //event
        btn_sign_out.setOnClickListener {
            //signout
            AuthUI.getInstance().signOut(this@Login)
                .addOnCompleteListener{
                    btn_sign_out.isEnabled=false
                    showSignInOptions()
                }
                .addOnFailureListener {
                    e-> Toast.makeText(this@Login,e.message,Toast.LENGTH_SHORT).show()
                }
        }


    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == MY_REQUEST_CODE)
        {
            val response = IdpResponse.fromResultIntent(data)
            if(resultCode == Activity.RESULT_OK)
            {
                val user = FirebaseAuth.getInstance().currentUser // get Current user
                Toast.makeText(this,""+user!!.email,Toast.LENGTH_SHORT).show()

                btn_sign_out.isEnabled = true
            }
            else
            {
                Toast.makeText(this,""+response!!.error!!.message,Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun showSignInOptions() {
        startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .setTheme(R.style.MyTheme)
            .build(),MY_REQUEST_CODE)
    }






}
