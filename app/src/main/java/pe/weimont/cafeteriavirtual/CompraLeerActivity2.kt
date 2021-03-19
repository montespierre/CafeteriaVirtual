package pe.weimont.cafeteriavirtual

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SimpleAdapter
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_compra_leer2.*
import kotlinx.android.synthetic.main.activity_producto_leer2.*
import org.json.JSONArray

class CompraLeerActivity2 : AppCompatActivity() {
    var arrayList = ArrayList<HashMap<String,String>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compra_leer2)

        leerCompras()
    }

    private fun leerCompras() {
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://bacchanal-adverbs.000webhostapp.com/conexion/leerCompraDetallada.php"

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                Log.d("COMPRAS",response)
                llenarLista(response)
            },
            Response.ErrorListener { Log.e("ERROR COMP", "Esto no trabaja ") })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }

    private fun llenarLista(response: String?) {
        var jsonArray = JSONArray(response)

        //Se ha creado un arreglo con la misma cantidad de filas del JSON Array
        for(i in 0 until jsonArray.length()){
            var midCompra = jsonArray.getJSONObject(i).getString("idCompra")
            var mnombrePersona = jsonArray.getJSONObject(i).getString("nomPersona")
            var mapellidosPersona = jsonArray.getJSONObject(i).getString("apellidosPersona")
            var mnomProducto = jsonArray.getJSONObject(i).getString("nomProducto")
            var mprecioProducto = jsonArray.getJSONObject(i).getString("precioProducto")
            var mCantidadProductos = jsonArray.getJSONObject(i).getString("CantidadProductos")
            var migv_calc = jsonArray.getJSONObject(i).getString("igv_calc")
            var mmontoTotal = jsonArray.getJSONObject(i).getString("montoTotal")

            //Un hashmap esta formado por una pareja o varias parejas: el nombre del dato y el valor del mismo
            var map = HashMap<String,String>()

            map.put("idCompra",midCompra)
            map.put("nomPersona",mnombrePersona)
            map.put("apellidosPersona",mapellidosPersona)
            map.put("nomProducto",mnomProducto)
            map.put("precioProducto",mprecioProducto)
            map.put("CantidadProductos",mCantidadProductos)
            map.put("igv_calc",migv_calc)
            map.put("montoTotal",mmontoTotal)

            arrayList.add(map) // se añade el hashmap creado
        }



        var origen = arrayOf("idProducto","nombrePersona","apellidosPersona","nomProducto",
            "precioProducto","CantidadProductos","igv_calc","montoTotal")
        var destino = intArrayOf(R.id.tvDet_idCompra, R.id.tvDet_nombrePersona, R.id.tvDet_apellidosPersona,
        R.id.tvDet_nomProducto, R.id.tvDet_precioProducto, R.id.tvDet_CantidadProductos,
        R.id.tvDet_igv_calc, R.id.tvDet_montoTotal)

        var listAdapter = SimpleAdapter(
            this,
            arrayList,
            R.layout.item_compra_leer,
            origen,
            destino
        )

        lvCompraLeer.adapter = listAdapter
    }


}