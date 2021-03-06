package com.emanuelfuentes.evlab2_pdm_00095417

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), StaticFragment.OnSelectOption {

    override fun onAction(id: Int) {
        var content = when (id) {
            1 -> {
                "left"
            }
            2 -> {
                "rigth"
            }
            else -> {
                "Fuck!"
            }
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_content, ContentFragment.newInstance(content))
            .addToBackStack("Co")
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var barFragment = StaticFragment.newInstace(
            "Previous",
            "Forward"
        )

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_bar, barFragment)
                .commit()
        }
    }
}
