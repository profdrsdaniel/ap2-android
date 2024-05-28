package br.com.ulbra.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import br.com.ulbra.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar
        toolbar.title = "Home"

        val menuBottom = binding.menuBottom
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)


        NavigationUI.setupWithNavController(menuBottom, navController)
    }
}