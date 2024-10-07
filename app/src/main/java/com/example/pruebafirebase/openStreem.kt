package com.example.pruebafirebase

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import org.osmdroid.config.Configuration
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Polygon
import org.osmdroid.util.GeoPoint


import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.osmdroid.tileprovider.tilesource.TileSourceFactory


class openStreem : AppCompatActivity() {
    private lateinit var map: MapView
    private val Context.dataStore by preferencesDataStore(name = "settings")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_open_streem)

        val sharedPreferences = getSharedPreferences("osmdroid_prefs", Context.MODE_PRIVATE)
        Configuration.getInstance().load(applicationContext, sharedPreferences)

        var mapView = findViewById<MapView>(R.id.map)
        mapView.setTileSource(TileSourceFactory.MAPNIK)
        mapView.setMultiTouchControls(true)

        val mapController = mapView.controller
        mapController.setZoom(14.0)
        val startPoint = GeoPoint(1.219367, -77.278120) // Coordenadas iniciales
        mapController.setCenter(startPoint)


        // Crear un polígono
        val polygon = Polygon()

        polygon.title = "Área delimitada"

        // Definir las coordenadas del polígono utilizando GeoPoint
        val points = arrayListOf(
            GeoPoint(1.219367, -77.278120),
            GeoPoint(1.216703, -77.283064),
            GeoPoint(1.217648, -77.283872),
            GeoPoint(1.217473, -77.284031),
            GeoPoint(1.211678, -77.281535),
            GeoPoint(1.210900, -77.283216),
            GeoPoint(1.206530, -77.281085),
            GeoPoint(1.207137, -77.279492),
            GeoPoint(1.209883, -77.274243),
            GeoPoint(1.210375, -77.273920),
            GeoPoint(1.212445, -77.275561),
            GeoPoint(1.213347, -77.275381),
            GeoPoint(1.218690, -77.277445),
            GeoPoint(1.219367, -77.278120) // Coordenada de cierre
        )

        // Añadir los puntos al polígono
        polygon.points = points


        // Añadir el polígono al mapa
        mapView.overlays.add(polygon)

        // Redibujar el mapa
        mapView.invalidate()

        val btSalir = findViewById<Button>(R.id.btSalir)
        btSalir.setOnClickListener{
            finish()
        }


    }
}

