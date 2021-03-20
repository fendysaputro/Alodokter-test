package id.phephen.alodokter.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.squareup.picasso.Picasso


/**
 * Created by phephen on 20,March,2021
 * https://github.com/fendysaputro
 */
class ViewPagerAdapter internal constructor(context: Context, imageUrls: Array<String>) :
    PagerAdapter() {
    private val context: Context
    private val imageUrls: Array<String>
    override fun getCount(): Int {
        return imageUrls.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageView = ImageView(context)
        Picasso.get()
            .load(imageUrls[position])
            .fit()
            .centerCrop()
            .into(imageView)
        container.addView(imageView)
        return imageView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    init {
        this.context = context
        this.imageUrls = imageUrls
    }
}