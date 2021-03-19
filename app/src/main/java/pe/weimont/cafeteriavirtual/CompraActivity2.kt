package pe.weimont.cafeteriavirtual

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class CompraActivity2 : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compra2)

        val mLeerCompra = findViewById<Button>(R.id.btnLeerCompras)
        val mInsertarCompra = findViewById<Button>(R.id.btnInsertarCompras)

        mLeerCompra.setOnClickListener(this)
        mInsertarCompra.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnLeerCompras -> mostrarLeerCompras()
            R.id.btnInsertarCompras -> mostrarInsertarCompras()

        }
    }

    private fun mostrarInsertarCompras() {
        startActivity(Intent(this,CompraInsertarActivity2::class.java))
    }

    private fun mostrarLeerCompras() {
        startActivity(Intent(this,CompraLeerActivity2::class.java))
    }
}