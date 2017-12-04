package com.swkfx.kotlinforandroid.ui.adapters

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.swkfx.kotlinforandroid.R
import com.swkfx.kotlinforandroid.domain.model.Girl
import org.jetbrains.anko.find

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2017/11/29
 *      desc   :
 * </pre>
 */
class GirlAdapter(private val items: List<Girl>) : RecyclerView.Adapter<GirlAdapter.GirlViewHolder>() {


    init {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GirlAdapter.GirlViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_girl_list, parent, false)
        return GirlViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GirlAdapter.GirlViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount(): Int = items.size


    class GirlViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvDesc = itemView.find<TextView>(R.id.tvDesc)
        private val image = itemView.find<ImageView>(R.id.imageView)

        fun bindView(girl: Girl) {
            with(girl) {
                tvDesc.text = desc
                Picasso.with(itemView.context)
                        .load(url)
                        .into(image, object : Callback {
                            override fun onSuccess() {
                                Log.d("GirlViewHolder", "image :$url -> success")
                            }

                            override fun onError() {
                                Log.d("GirlViewHolder", "image :$url -> error")
                            }

                        })
            }
        }
    }
}