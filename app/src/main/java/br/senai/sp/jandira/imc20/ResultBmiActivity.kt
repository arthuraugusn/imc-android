package br.senai.sp.jandira.imc20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.core.util.rangeTo
import br.senai.sp.jandira.imc20.databinding.ActivityBmiBinding
import br.senai.sp.jandira.imc20.databinding.ActivityResultBmiBinding
import br.senai.sp.jandira.imc20.utils.getBmi
import br.senai.sp.jandira.imc20.utils.getStatusBmi

class ResultBmiActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultBmiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        binding = ActivityResultBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //recuperar valores que estão na intent
        val weight = intent.getIntExtra("weight", 0)
        val high = intent.getDoubleExtra( "high", 0.0)
        val bmi = getBmi(weight, high)

        binding.textViewResult.text = String.format("%.2f", bmi)
        binding.textViewStatus.text = getStatusBmi(bmi, this)
    }
}