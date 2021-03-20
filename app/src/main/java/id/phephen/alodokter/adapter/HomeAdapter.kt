package id.phephen.alodokter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.phephen.alodokter.databinding.ItemImageHomeBinding
import id.phephen.alodokter.model.Hero

/**
 * Created by phephen on 20,March,2021
 * https://github.com/fendysaputro
 */
class HomeAdapter (private val heroes: List<Hero>, private val listener: (Hero) -> Unit) :
        RecyclerView.Adapter<HomeAdapter.HomeListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.HomeListViewHolder {
        val binding = ItemImageHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeAdapter.HomeListViewHolder, position: Int) {
        holder.bind(heroes[position], listener)
    }

    override fun getItemCount()= heroes.size

    inner class HomeListViewHolder(private val binding: ItemImageHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Hero, listener: (Hero) -> Unit) {
            Picasso.get().load(item.image).into(binding.ivHero)

            itemView.setOnClickListener {
                listener(item)
            }
        }
    }

}