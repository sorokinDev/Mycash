package com.sorokin.yamob.mycash.ui.main

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.sorokin.yamob.mycash.R
import com.sorokin.yamob.mycash.ui.home.HomeFragment
import com.sorokin.yamob.mycash.ui.home.HomeViewModel
import com.sorokin.yamob.mycash.util.ViewModelFactory
import com.sorokin.yamob.mycash.util.getViewModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.SupportAppNavigator
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    @Inject lateinit var navHolder: NavigatorHolder

    @Inject lateinit var viewModelFactory: ViewModelFactory
    lateinit var viewModel: MainViewModel

    @Inject lateinit var homeFragment: HomeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        viewModel = getViewModel(viewModelFactory)

        navigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.navigation_home -> viewModel.router.newRootScreen("HOME")
                else -> viewModel.router.newRootScreen("HOME")
            }
            true
        }

        if(savedInstanceState == null){
            navigation.selectedItemId = R.id.navigation_home
        }
    }

    fun setToolbarVisibility(vis: Boolean){
        toolbar.visibility = if (vis) View.VISIBLE else View.GONE
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navHolder.removeNavigator()
        super.onPause()
    }

    val navigator = object : SupportAppNavigator(this, R.id.content){
        override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent? {
            return null
        }

        override fun createFragment(screenKey: String?, data: Any?): Fragment?  = when(screenKey){
            "HOME" -> homeFragment
            else -> homeFragment
        }
    }

}
