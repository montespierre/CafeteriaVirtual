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

class PersonaLeerActivity2 : AppCompatActivity() {
    var arrayList = ArrayList<HashMap<String,String>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persona_leer2)

        leerPersona()
    }

    private fun leerPersona() {
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://bacchanal-adverbs.000webhostapp.com/conexion/leerPersona3.php"

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                Log.d("PERSONA",response)
                llenarLista(response)
            },
            Response.ErrorListener { Log.e("ERROR PERS", "Esto no trabaja ") })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }

    private fun llenarLista(response: String?) {
        var jsonArray = JSONArray(response)


        //Se ha creado un arreglo con la misma cantidad de filas del JSON Array
        for(i in 0 until jsonArray.length()){
            var midPersona = jsonArray.getJSONObject(i).getString("idPersona")
            var mnomPersona = jsonArray.getJSONObject(i).getString("nomPersona")
            var mapellidosPersona = jsonArray.getJSONObject(i).getString("apellidosPersona")

            //Un hashmap esta formado por una pareja o varias parejas: el nombre del dato y el valor del mismo
            var map = HashMap<String,String>()
            map.put("idPersona",midPersona)
            map.put("nomPersona",mnomPersona)
            map.put("apellidosPersona",mapellidosPersona)

            arrayList.add(map) // se añade el hashmap creado
        }



        var origen = arrayOf("idPersona","nomPersona","apellidosPersona")
        var destino = intArrayOf(R.id.tvidPersona,R.id.tvNombrePersona, R.id.tvApellidosPersona)

        var listAdapter = SimpleAdapter(
            this,
            arrayList,
            R.layout.item_persona_leer,
            origen,
            destino
        )

        lvPersonaLeer.adapter = listAdapter
    }
}