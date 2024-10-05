package com.example.pruebafirebase

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions

class maps : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var map:GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_maps)
        createFragment()
    }

    private fun createFragment(){
        val mapFragment: SupportMapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMaps: GoogleMap) {
        map = googleMaps
        createMarker()
        dibujar(map)
    }

    private fun createMarker(){
        val coordenadas = LatLng(1.218011, -77.281242)
        val marker = MarkerOptions().position(coordenadas)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordenadas,18f),
            4000,
            null
        )

    }

    private fun dibujar(googleMaps: GoogleMap){
        val point = listOf(
            LatLng(1.219367, -77.278120),
            LatLng(1.216703, -77.283064),
            LatLng(1.217648, -77.283872),
            LatLng(1.217473, -77.284031),
            LatLng(1.211678, -77.281535),
            LatLng(1.210900, -77.283216),
            LatLng(1.206530, -77.281085),
            LatLng(1.207137, -77.279492),
            LatLng(1.209883, -77.274243),
            LatLng(1.210375, -77.273920),
            LatLng(1.212445, -77.275561),
            LatLng(1.213347, -77.275381),
            LatLng(1.218690, -77.277445),
            LatLng(1.219367, -77.278120)
        )

        val poligono = PolylineOptions()
            .addAll(point)
            .color(Color.BLUE)
            .width(12f)

        googleMaps.addPolyline(poligono)
    }
}