package com.ugdgomezdiez.superheroes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ugdgomezdiez.superheroes.data.remote.BiographyRemoteDataSource
import com.ugdgomezdiez.superheroes.data.remote.SuperHeroeRemoteDataSource
import com.ugdgomezdiez.superheroes.data.remote.WorkRemoteDataSource
import com.ugdgomezdiez.superheroes.databinding.ActivityHeroBinding
import com.ugdgomezdiez.superheroes.databinding.ActivityMainBinding
import com.ugdgomezdiez.superheroes.domain.GetSuperHeroeUseCase
import com.ugdgomezdiez.superheroes.domain.SuperHeroe

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    lateinit var binding2:ActivityHeroBinding

    private val superHeroAdapter = SuperHeroAdapter()

    private val viewModel: SuperHeroeViewModel by lazy {
        SuperHeroeViewModel(
            BiographyRemoteDataSource(),
            WorkRemoteDataSource(),
            SuperHeroeRemoteDataSource(),
            GetSuperHeroeUseCase(SuperHeroeRemoteDataSource())
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupView()
        setupObservers()
        viewModel.loadSuperHeroe()

        val layout = findViewById<View>(R.id.list)

        layout.setOnClickListener {
            val intent = Intent(this, setupBinding2()::class.java)
            startActivity(intent)
        }

    }

    private fun setupBinding(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupBinding2(){
        binding2 = ActivityHeroBinding.inflate(layoutInflater)
        setContentView(binding2.root)
    }

    private fun setupView(){
        binding.apply {
            list.apply {
                list.layoutManager = LinearLayoutManager(
                    this@MainActivity,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                list.adapter = superHeroAdapter
            }
        }
    }

    private fun setupView2(){
        binding2.apply {
            listImage.apply {
                listImage.layoutManager = LinearLayoutManager(
                    this@MainActivity,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                listImage.adapter = superHeroAdapter
            }
        }
    }
    private fun setupObservers(){
        val observer=Observer<SuperHeroeViewModel.UiModel>{
            it.superHeroe?.let {
                bind(it)
            }
        }
        viewModel.uiModel.observe(this,observer)
    }

    private fun bind(superHeroe:List<SuperHeroe>){
        superHeroAdapter.setDataList(superHeroe)
    }
}