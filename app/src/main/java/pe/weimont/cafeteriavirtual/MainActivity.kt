package pe.weimont.cafeteriavirtual

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mbtnProductos =findViewById<Button>(R.id.btnProductos)
        val mbtnCompras = findViewById<Button>(R.id.btnCompras)
        val mbtnPersonas = findViewById<Button>(R.id.btnPersona)

        mbtnProductos.setOnClickListener(this)
        mbtnCompras.setOnClickListener(this)
        mbtnPersonas.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnProductos -> mostrarProductos()
            R.id.btnCompras -> mostrarCompras()
            R.id.btnPersona -> mostrarPersona()
        }
    }

    private fun mostrarPersona() {
        startActivity(Intent(this,PersonaActivity2::class.java))
    }

    private fun mostrarCompras() {
        startActivity(Intent(this,CompraActivity2::class.java))
    }

    private fun mostrarProductos() {
        startActivity(Intent(this,ProductoActivity2::class.java))
    }
}