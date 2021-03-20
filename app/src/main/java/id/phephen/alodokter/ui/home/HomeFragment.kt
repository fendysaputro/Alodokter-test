package id.phephen.alodokter.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.phephen.alodokter.adapter.HomeAdapter
import id.phephen.alodokter.databinding.FragmentHomeBinding
import id.phephen.alodokter.model.Hero
import id.phephen.alodokter.ui.DetailImageSlideShowActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var rvImageHome: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var homeAdapter: HomeAdapter

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setupRecyclerView()
    }

    private fun initView() {
        rvImageHome = binding.rvImageHome
        progressBar = binding.progressBar
    }

    private fun setupRecyclerView() {
        progressBar.visibility = View.GONE
        val listHeroes = listOf(
            Hero(name = "Spider-Man", image = "https://i.annihil.us/u/prod/marvel/i/mg/9/30/538cd33e15ab7/standard_xlarge.jpg"),
            Hero(name = "Black Panther", image = "https://i.annihil.us/u/prod/marvel/i/mg/1/c0/537ba2bfd6bab/standard_xlarge.jpg"),
            Hero(name = "Iron Man", image = "https://i.annihil.us/u/prod/marvel/i/mg/6/a0/55b6a25e654e6/standard_xlarge.jpg"),
            Hero(name = "Dead Pool", image = "https://i.annihil.us/u/prod/marvel/i/mg/5/c0/537ba730e05e0/standard_xlarge.jpg"),
            Hero(name = "Captain Marvel", image = "https://i.annihil.us/u/prod/marvel/i/mg/c/10/537ba5ff07aa4/standard_xlarge.jpg")
        )

        homeAdapter = HomeAdapter(listHeroes) { hero ->
            val intent = Intent(context, DetailImageSlideShowActivity::class.java)
            startActivity(intent)
        }

        rvImageHome.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = homeAdapter
        }
    }

    companion object {
        fun newInstance(): HomeFragment{
            val fragment = HomeFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}