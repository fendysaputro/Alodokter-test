package id.phephen.alodokter.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import id.phephen.alodokter.R
import id.phephen.alodokter.adapter.ViewPagerAdapter
import id.phephen.alodokter.databinding.ActivityDetailImageSlideShowBinding


class DetailImageSlideShowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailImageSlideShowBinding
    private var viewPager: ViewPager? = null

    private val imageUrls = arrayOf(
        "https://i.annihil.us/u/prod/marvel/i/mg/9/30/538cd33e15ab7/standard_xlarge.jpg",
        "https://i.annihil.us/u/prod/marvel/i/mg/1/c0/537ba2bfd6bab/standard_xlarge.jpg",
        "https://i.annihil.us/u/prod/marvel/i/mg/6/a0/55b6a25e654e6/standard_xlarge.jpg",
        "https://i.annihil.us/u/prod/marvel/i/mg/5/c0/537ba730e05e0/standard_xlarge.jpg",
        "https://i.annihil.us/u/prod/marvel/i/mg/c/10/537ba5ff07aa4/standard_xlarge.jpg"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailImageSlideShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        val adapter = ViewPagerAdapter(this, imageUrls)
        viewPager.adapter = adapter
    }

}