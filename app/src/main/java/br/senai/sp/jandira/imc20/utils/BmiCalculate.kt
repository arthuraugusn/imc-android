package br.senai.sp.jandira.imc20.utils

import android.content.Context
import br.senai.sp.jandira.imc20.R
import java.security.AccessControlContext
import kotlin.math.pow

//chamando/criando os métpdps da classe User
fun getBmi(wheight: Int, high: Double):Double{
    return wheight/high.pow(2)
}

//responsabilidade única (só faz uma coisa)
fun getStatusBmi(bmi: Double, context: Context):String{
    //val = const (variável imutável)
    //var = mutável

    if(bmi<=18.5){
        return context.getString(R.string.bmiStatus1)
    }else if(bmi >18.5 && bmi<=24.9){
        return context.getString(R.string.bmiStatus2)
    }else if(bmi>=25 && bmi<30){
        return context.getString(R.string.bmiStatus3)
    }else if(bmi>=30 && bmi<35){
        return context.getString(R.string.bmiStatus4)
    }else if(bmi>=35 && bmi<40){
        return context.getString(R.string.bmiStatus5)
    }else{
        return context.getString(R.string.bmiStatus6)
    }
}