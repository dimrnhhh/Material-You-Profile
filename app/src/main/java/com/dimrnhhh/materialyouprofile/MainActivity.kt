package com.dimrnhhh.materialyouprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import com.dimrnhhh.materialyouprofile.screens.AboutFragment
import com.dimrnhhh.materialyouprofile.screens.AlarmFragment
import com.dimrnhhh.materialyouprofile.screens.EditFragment
import com.dimrnhhh.materialyouprofile.screens.ProfileFragment
import com.dimrnhhh.materialyouprofile.viewmodels.MainViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.isLoading.value
            }
        }
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(ProfileFragment())
        bottomNav = findViewById(R.id.bottomNav) as BottomNavigationView
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.account_button -> {
                    loadFragment(ProfileFragment())
                    true
                }
                R.id.edit_button -> {
                    loadFragment(EditFragment())
                    true
                }
                R.id.about_button -> {
                    loadFragment(AboutFragment())
                    true
                }
                R.id.alarm_button -> {
                    loadFragment((AlarmFragment()))
                    true
                }
                else -> false
            }
        }

    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }
}
