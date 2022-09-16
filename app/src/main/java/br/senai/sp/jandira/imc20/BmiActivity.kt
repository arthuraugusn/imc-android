package br.senai.sp.jandira.imc20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import br.senai.sp.jandira.imc20.databinding.ActivityBmiBinding
import br.senai.sp.jandira.imc20.databinding.ActivityMainBinding
import br.senai.sp.jandira.imc20.model.User

class BmiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBmiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadProfile()
        binding.buttonCalculate.setOnClickListener{
            bmiCalculate()
        }
    }

    private fun loadProfile() {
        val dados = getSharedPreferences("dados", MODE_PRIVATE)

        binding.textViewUsername.text = dados.getString("name", "")
        binding.textViewHigh.text = "High: ${dados.getFloat("high", 0.0F)}"
        binding.textViewWeight.text = "Weight: ${dados.getInt("weight", 0)}"
        binding.textViewEmail.text = dados.getString("email", "")

    }

    private fun bmiCalculate() {
        val openResult = Intent(this, ResultBmiActivity::class.java)
        val dados = getSharedPreferences("dados", MODE_PRIVATE)
        val user = User()
        val editor = dados.edit()

        if(binding.editTextWeightCalculate.text.isEmpty()){
            val weight = dados.getInt("weight",0)
            openResult.putExtra("weight", weight)
        }
        else{
            user.weight = binding.editTextWeightCalculate.text.toString().toInt()
            editor.putInt("weight", user.weight)
            openResult.putExtra("weight", binding.editTextWeightCalculate.text.toString().toInt())
        }
        if (binding.editTextHighCalculate.text.isEmpty()){
            val high = dados.getFloat("high", 00F)
            openResult.putExtra("high", high.toDouble())
        }else{
            user.high = binding.editTextHighCalculate.text.toString().toDouble()
            editor.putFloat("high", user.high.toFloat())
            openResult.putExtra("high", binding.editTextHighCalculate.text.toString().toDouble())
        }

        editor.commit()
        startActivity(openResult)
    }
}