package com.example.mvvmnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mvvmnews.R
import com.example.mvvmnews.database.NewsDatabase
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class NewsActivity : AppCompatActivity() {
    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = NewsRepository(NewsDatabase.getDatabase(applicationContext))
        val viewModelProviderFactory = ViewModelProviderFactory(repository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.newsNavHostFragment)
        if (navHostFragment != null) {
            bottomNavigationView.setupWithNavController(navHostFragment.findNavController())
        }
    }
}