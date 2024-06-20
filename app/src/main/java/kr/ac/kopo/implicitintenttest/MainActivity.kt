package kr.ac.kopo.implicitintenttest

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var btncall = findViewById<Button>(R.id.btn_call)
        var btnHome = findViewById<Button>(R.id.btn_home)
        var btnmap = findViewById<Button>(R.id.btn_map)
        var btnSearch = findViewById<Button>(R.id.btn_search)
        var btnSms = findViewById<Button>(R.id.btn_Sms)
        var btnCamera = findViewById<Button>(R.id.btn_camera)

        btncall.setOnClickListener(btnListner)
        btnHome.setOnClickListener(btnListner)
        btnmap.setOnClickListener(btnListner)
        btnSearch.setOnClickListener(btnListner)
        btnSms.setOnClickListener(btnListner)
        btnCamera.setOnClickListener(btnListner)

    }

    val btnListner = View.OnClickListener {
        var uri = Uri.parse("tel:/010-1234-5678")
        var intent = Intent(Intent.ACTION_DIAL,uri)
        when(it.id){
            R.id.btn_call -> {
                Uri.parse("tel:/010-1234-5678")
                intent = Intent(Intent.ACTION_DIAL , uri)
            }
            R.id.btn_home -> {
                Uri.parse("https://www.kopo.ac.kr")
                intent = Intent(Intent.ACTION_VIEW , uri)
            }
            R.id.btn_map -> {
                Uri.parse("https://maps.google.com/map?q=37.5290615,126.996542")
                intent = Intent(Intent.ACTION_VIEW , uri)
                intent.putExtra(SearchManager.QUERY, "인공지능")
            }
            R.id.btn_search -> {
                intent = Intent(Intent.ACTION_WEB_SEARCH)
            }
            R.id.btn_Sms -> {
                intent= Intent(Intent.ACTION_SENDTO)
                intent.putExtra("sms_body", "조금 있으면 나도 방학이야")
                intent.data = Uri.parse("smsto:" + Uri.encode("010-1111-1111"))
            }
            R.id.btn_camera -> {
                intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            }
        }
startActivity(intent)

    }
}