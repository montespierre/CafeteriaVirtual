package pe.weimont.cafeteriavirtual

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ProductoActivity2 : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto2)

        val mLeerProducto = findViewById<Button>(R.id.btnLeerProductos)
        val mInsertarProducto = findViewById<Button>(R.id.btnInsertarProductos)

        mLeerProducto.setOnClickListener(this)
        mInsertarProducto.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnLeerProductos -> mostrarLeerProductos()
            R.id.btnInsertarProductos -> mostrarInsertarProductos()

        }
    }

    private fun mostrarInsertarProductos() {
        startActivity(Intent(this,ProductoInsertarActivity2::class.java))
    }

    private fun mostrarLeerProductos() {
        startActivity(Intent(this,ProductoLeerActivity2::class.java))
    }
}