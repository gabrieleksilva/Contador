package br.edu.scl.ifsp.ads.contador

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity
import br.edu.scl.ifsp.ads.contador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var contador: Int = 0
    private lateinit var amb: ActivityMainBinding

                       // nome do atributo e : e o tipo. Nesse caso o tipo é o Bundle serve pra armazenar objeto do jeito = chave valor (tipo hashMap)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       amb = ActivityMainBinding.inflate(layoutInflater)
       setContentView(amb.root) // aqui fala qual o layout que aparecerá na tela inicial do app

       amb.initialSp.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{

           override fun onItemSelected(
               parent: AdapterView<*>?, // sao os item que tem dentro do combo
               view: View?,
               position: Int,
               id: Long
           ) {
                contador = when(position){
                    0 -> 0
                    1 -> 5
                    2 -> 10
                    else -> 0 // Esgotar as opções quando when é usado como expression
                } // acho que esta pegando o valor do id gerado automatico
           }

           override fun onNothingSelected(parent: AdapterView<*>?) {
               //NSA
           }

       }

       amb.cliqueBt.setOnClickListener{
           amb.contadorTv.text = (++contador).toString()
       }


    }
}