package com.example.catchat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar=findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController=navHostFragment.navController
        val builder=AppBarConfiguration.Builder(navController.graph)
        val drawer:DrawerLayout=findViewById(R.id.drawer_layout)
        builder.setOpenableLayout(drawer)
        val appBarConfiguration=builder.build()
        toolbar.setupWithNavController(navController,appBarConfiguration)

        val bottonNav=findViewById<BottomNavigationView>(R.id.bottonNav)
        bottonNav.setupWithNavController(navController)

        val navDrawer=findViewById<NavigationView>(R.id.nav_view)
        navDrawer.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController=findNavController(R.id.fragmentContainerView)
        return item.onNavDestinationSelected((navController)) || super.onOptionsItemSelected(item)
    }
}