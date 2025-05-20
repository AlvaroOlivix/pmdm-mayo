package edu.example.pmdm_mayo

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.example.pmdm_mayo.feature.client.data.ClientDataRepository
import edu.example.pmdm_mayo.feature.client.data.local.ClientRoomDataSource
import edu.example.pmdm_mayo.feature.client.data.remote.RemoteMockDataSource
import edu.example.pmdm_mayo.feature.core.db.DbProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}