package id.phephen.alodokter.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import id.phephen.alodokter.R
import id.phephen.alodokter.databinding.ActivityMainBinding
import id.phephen.alodokter.ui.home.HomeFragment
import id.phephen.alodokter.ui.profile.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNav: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        setBottomNavigation()
    }

    private fun initView() {
        bottomNav = binding.bottomNav
    }

    private fun setBottomNavigation() {
        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    val fragment = HomeFragment.newInstance()
                    addFragment(fragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_profile -> {
                    val fragment = ProfileFragment.newInstance()
                    addFragment(fragment)
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.design_bottom_sheet_slide_in,
                R.anim.design_bottom_sheet_slide_out
            )
            .replace(R.id.content, fragment, fragment.javaClass.getSimpleName())
            .commit()
    }
}