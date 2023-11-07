package com.ugdgomezdiez.superheroes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ugdgomezdiez.superheroes.data.remote.BiographyRemoteDataSource
import com.ugdgomezdiez.superheroes.data.remote.SuperHeroeRemoteDataSource
import com.ugdgomezdiez.superheroes.data.remote.WorkRemoteDataSource
import com.ugdgomezdiez.superheroes.databinding.ActivityMainBinding
import com.ugdgomezdiez.superheroes.domain.GetSuperHeroeListUseCase
import com.ugdgomezdiez.superheroes.domain.SuperHeroe
class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding


    private val superHeroAdapter = SuperHeroAdapter()

    private val viewModel: SuperHeroeViewModel by lazy {
        SuperHeroeViewModel(
            GetSuperHeroeListUseCase(SuperHeroeRemoteDataSource(),
                BiographyRemoteDataSource(),
                WorkRemoteDataSource()
                )
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupView()
        setupObservers()
        viewModel.loadSuperHeroe()



    }

    private fun setupBinding(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }



    private fun setupView(){
        binding.apply {
            list.apply {
                list.layoutManager = LinearLayoutManager(
                    this@MainActivity,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                superHeroAdapter.setEvent {
                    navigateToDetail(it)
                }
                list.adapter = superHeroAdapter
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
        superHeroAdapter.submitList(superHeroe)
    }
    private fun navigateToDetail(heroId: Int){
        val intent = Intent(this,SuperHeroeDetailActivity::class.java)
        intent.putExtra(SuperHeroeDetailActivity.HERO_ID_PARAM,heroId)
        startActivity(intent)
    }
}