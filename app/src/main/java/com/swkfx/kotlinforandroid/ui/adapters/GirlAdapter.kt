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
import com.swkfx.kotlinforandroid.extensions.ctx
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

    private var itemClick: OnItemClickListener? = null

    fun setItemClickListener(listener: OnItemClickListener) {
        itemClick = listener
    }
//    private var itemClick: ((Girl, Int) -> Unit)? = null
//
//    fun setItemClickListener(itemClick: ((Girl, Int) -> Unit)) {
//        this.itemClick = itemClick
//    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GirlAdapter.GirlViewHolder {
        val inflater = LayoutInflater.from(parent.ctx)
//        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_girl_list, parent, false)
        return GirlViewHolder(itemView, itemClick)
    }

    override fun onBindViewHolder(holder: GirlAdapter.GirlViewHolder, position: Int) {
        holder.bindGirl(items[position], position)
    }

    override fun getItemCount(): Int = items.size


    class GirlViewHolder(itemView: View, private val itemClickListener: OnItemClickListener?) : RecyclerView.ViewHolder(itemView) {
        private val tvDesc: TextView
        private val image: ImageView

        init {
            tvDesc = itemView.find(R.id.tvDesc)
            image = itemView.find(R.id.imageView)
        }

        fun bindGirl(girl: Girl, position: Int) {
            with(girl) {
                tvDesc.text = desc
                Picasso.with(itemView.ctx)
                        .load(url)
                        .into(image, object : Callback {
                            override fun onSuccess() {
                                Log.d("GirlViewHolder", "image :$url -> success")
                            }

                            override fun onError() {
                                Log.d("GirlViewHolder", "image :$url -> error")
                            }

                        })
                itemView.setOnClickListener { itemClickListener?.invoke(girl, position) }
                //lambda 过程
//                itemView.setOnClickListener(
//                        object : View.OnClickListener {
//                            override fun onClick(v: View?) {
//                                //匿名内部类的方式设置接口回调
//                                itemView.ctx.toast("匿名内部类的方式设置接口回调")
//                            }
//
//                        })
                //--lambda表达式通过参数的形式被定义在箭头的左边（被圆括号包围），然后在
                // 箭头的右边返回结果值--
//                itemView.setOnClickListener(View.OnClickListener { v: View? ->
//                    itemView.ctx.toast("lambda 的设置方法")
//                })

//                itemView.setOnClickListener({
//                    //再简化
//                })
//                itemView.setOnClickListener{
//                    //最后
//                }

            }

        }


    }

    interface OnItemClickListener {

        operator fun invoke(girl: Girl, position: Int)
    }
}