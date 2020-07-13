package com.example.zapiskz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.zapiskz.fragments.BeautyShopsFragment
import com.example.zapiskz.fragments.EmptyFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object{
         val beautyShopsFragment =
             BeautyShopsFragment()
         val emptyFragment = EmptyFragment.newInstance("empty","fragment")

    }
    private var rotated = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.first_icon -> {
                    supportFragmentManager.beginTransaction().replace(container.id, beautyShopsFragment).commit()
                    true
                }
                R.id.second_icon -> {
                    supportFragmentManager.beginTransaction().replace(container.id, emptyFragment).commit()
                    true
                }
                R.id.third_icon->{
                    supportFragmentManager.beginTransaction().replace(container.id, emptyFragment).commit()
                    true
                }
                else -> false
            }
        }
        Log.i(javaClass.simpleName, rotated.toString())
        rotated = savedInstanceState?.getBoolean("rotated",false)?:false
        if (!rotated) {
            bottomNav.selectedItemId = R.id.first_icon
            rotated = !rotated
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(javaClass.simpleName,"saving")
        outState.putBoolean("rotated", true)
    }

}