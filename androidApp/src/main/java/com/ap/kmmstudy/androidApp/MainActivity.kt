package com.ap.kmmstudy.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ap.kmmstudy.shared.Greeting
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.ap.kmmstudy.shared.repository.GitRepoRepository
import com.ap.kmmstudy.shared.repository_impl.GitRepoRepositoryImpl
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()

        getAllRepository()
    }

    private fun getAllRepository() {
        val repo : GitRepoRepository = GitRepoRepositoryImpl()
        GlobalScope.launch {
            val repository = repo.getRepository()
            Log.i("Amit","Loaded Repository Size : ${repository.size}")
        }
    }
}
