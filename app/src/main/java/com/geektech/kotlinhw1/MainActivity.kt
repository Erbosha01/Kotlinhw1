package com.geektech.kotlinhw1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.geektech.kotlinhw1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                binding.etSetText.setText(result.data?.getStringExtra(ResultActivity.key2RaMa))
            } else {
                binding.etSetText.setText(getString(R.string.error))
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        initClickListener()
    }

    private fun initClickListener() {
        binding.btnClick.setOnClickListener {
            if (binding.etSetText.text.isEmpty()) {
                Toast.makeText(this, "editText can not be empty", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(key1MaRa, binding.etSetText.text.toString())
                startForResult.launch(intent)
            }
        }
    }

    companion object {
        const val key1MaRa: String = "key1"
    }
}