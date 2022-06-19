package com.example.roomdbwithkotlin.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.roomdbwithkotlin.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class NavigationActivity : AppCompatActivity() {

    lateinit var navController:NavController
    lateinit var bottom_nav_view:BottomNavigationView
    lateinit var appbarController: AppBarConfiguration
    lateinit var nav_drawer: NavigationView
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        bottom_nav_view=findViewById(R.id.bottom_nav_view)
        nav_drawer=findViewById(R.id.nav_drawer)
        drawerLayout=findViewById(R.id.drawer_layout)


        val navHostFragment=supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment

        appbarController= AppBarConfiguration(
            setOf(R.id.aboutFragment3,R.id.homeFragment2,R.id.settingFragment),
            drawerLayout
        )

        navController=navHostFragment.navController
        setupActionBarWithNavController(navController,appbarController)

        bottom_nav_view.setupWithNavController(navController)
        nav_drawer.setupWithNavController(navController)

    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appbarController)||super.onSupportNavigateUp()
    }
}