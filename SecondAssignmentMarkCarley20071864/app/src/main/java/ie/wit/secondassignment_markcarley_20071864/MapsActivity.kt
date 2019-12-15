package ie.wit.secondassignment_markcarley_20071864

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(51.510033, -0.119301)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in UK Formula 1 headquarters"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        val race = LatLng(23.9976444, 53.6439098)
        mMap.addMarker(MarkerOptions().position(race).title("Marker in Abu Dhabi race track"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(race))

        val race1 = LatLng(-23.5475, -46.63611)
        mMap.addMarker(MarkerOptions().position(race1).title("Marker in Autodromo Jose Carlos Pace race track"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(race))
    }
}
