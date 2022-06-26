package com.geektech.kotlinhw1

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.geektech.kotlinhw1.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val key: String = intent.getStringExtra(MainActivity.key1MaRa).toString()
        binding.etSetText.setText(key)
        initClickListener()
    }

    private fun initClickListener() {
        binding.btnClick.setOnClickListener {
            if (binding.etSetText.text.isEmpty()) {
                Toast.makeText(this, "Edit text can not be empty", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent().putExtra(key2RaMa, binding.etSetText.text.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }

    companion object {
        const val key2RaMa: String = "key2"
    }
}