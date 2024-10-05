package com.example.pruebafirebase

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
}