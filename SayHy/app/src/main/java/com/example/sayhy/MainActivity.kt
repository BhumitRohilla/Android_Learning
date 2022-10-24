package com.example.sayhy

import android.content.ClipData.Item
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import com.example.sayhy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var _binding:ActivityMainBinding?=null
    val binding get()=_binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val pref=getSharedPreferences("string", MODE_PRIVATE)
        binding.message.setText(pref.getString("message_e",""))
    }

    override fun onCreatePanelMenu(featureId: Int, menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.share_menu){
            var intent=Intent().apply {
                this.action = Intent.ACTION_SEND
                this.putExtra(Intent.EXTRA_TEXT,binding.message.text.toString())
                this.type="text/plane"
            }
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onPause() {
        super.onPause()
        val pref=getSharedPreferences("string", MODE_PRIVATE)
        val editor= pref.edit()
        editor.putString("message_e",binding.message.text.toString())
        editor.apply()
    }
}