package pe.weimont.cafeteriavirtual

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class PersonaActivity2 : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persona2)

        val mLeerPersona = findViewById<Button>(R.id.btnLeerPersona)
        val mInsertarPersona = findViewById<Button>(R.id.btnInsertarPersona)

        mLeerPersona.setOnClickListener(this)
        mInsertarPersona.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnLeerPersona -> mostrarLeerPersona()
            R.id.btnInsertarPersona -> mostrarInsertarPersona()
        }
    }

    private fun mostrarInsertarPersona() {
        startActivity(Intent(this,PersonaInsertarActivity2::class.java))
    }

    private fun mostrarLeerPersona() {
        startActivity(Intent(this,PersonaLeerActivity2::class.java))
    }
}