package pe.weimont.cafeteriavirtual

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_persona_leer2.*
import kotlinx.android.synthetic.main.activity_producto_leer2.*
import org.json.JSONArray

class ProductoLeerActivity2 : AppCompatActivity() {
    var arrayList = ArrayList<HashMap<String,String>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto_leer2)

        leerProductos()
    }

    private fun leerProductos() {
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://bacchanal-adverbs.000webhostapp.com/conexion/leerProducto3.php"

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                Log.d("PRODUCTOS",response)
                llenarLista(response)
            },
            Response.ErrorListener { Log.e("ERROR PROD", "Esto no trabaja ") })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }

    private fun llenarLista(response: String?) {
        var jsonArray = JSONArray(response)


        //Se ha creado un arreglo con la misma cantidad de filas del JSON Array
        for(i in 0 until jsonArray.length()){
            var midProducto = jsonArray.getJSONObject(i).getString("idProducto")
            var mnomProducto = jsonArray.getJSONObject(i).getString("nomProducto")
            var mprecioProducto = jsonArray.getJSONObject(i).getString("precioProducto")

            //Un hashmap esta formado por una pareja o varias parejas: el nombre del dato y el valor del mismo
            var map = HashMap<String,String>()
            map.put("idProducto",midProducto)
            map.put("nomProducto",mnomProducto)
            map.put("precioProducto",mprecioProducto)

            arrayList.add(map) // se añade el hashmap creado
        }



        var origen = arrayOf("idProducto","nomProducto","precioProducto")
        var destino = intArrayOf(R.id.tvidProducto, R.id.tvNombreProducto, R.id.tvPrecioProducto)

        var listAdapter = SimpleAdapter(
            this,
            arrayList,
            R.layout.item_producto_leer,
            origen,
            destino
        )

        lvProductosLeer.adapter = listAdapter
    }
}