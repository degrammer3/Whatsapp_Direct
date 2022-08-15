package com.byteforce.whatsappdirect

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val number = findViewById<TextInputEditText>(R.id.contact)
        val chat = findViewById<Button>(R.id.chatbutton)

        chat.setOnClickListener()
        {
            val store = number.text.toString()
            if(store!="") {
                if (store.length<10) {
                    val alert = AlertDialog.Builder(this)
                    alert.setTitle("Please Check")
                    alert.setMessage("Number is less than 10 Digits")
                    alert.setIcon(R.mipmap.wadirect)
                    val alertDialog:AlertDialog = alert.create()
                    alertDialog.show()
                }
                else if(store.length>10)
                {
                    val alert = AlertDialog.Builder(this)
                    alert.setTitle("Wait")
                    alert.setMessage("Number is greater than 10 Digits")
                    alert.setIcon(R.mipmap.wadirect)
                    val alertDialog:AlertDialog = alert.create()
                    alertDialog.show()
                }
                else
                {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    intent.setData(Uri.parse("https://wa.me/+91$store"))
                    Toast.makeText(this,"Opening $store", Toast.LENGTH_LONG).show()
                    startActivity(intent)

                }
            }
            else
            {
                val alert = AlertDialog.Builder(this)
                alert.setTitle(R.string.errortitle)
                alert.setMessage(R.string.errormessage)
                alert.setIcon(R.mipmap.wadirect)
                val alertDialog:AlertDialog = alert.create()
                alertDialog.show()
            }
        }
    }
}