package com.android.mayojava.dailyfootball.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.android.mayojava.dailyfootball.GlideApp
import com.android.mayojava.dailyfootball.R
import kotlinx.android.synthetic.main.news_row_item.view.*

class RecyclerAdapter constructor(private val items: MutableList<NewsRowItem> = mutableListOf(),
                                  @LayoutRes private val rowLayoutId: Int,
                                  private val newsItemClickListener: (NewsRowItem) -> Unit):
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(rowLayoutId, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], newsItemClickListener)
    }

    fun setItems(rows: List<NewsRowItem>) {
        items.clear()
        items.addAll(rows)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(rowItem: NewsRowItem, listener: (NewsRowItem) -> Unit) {
            itemView.setOnClickListener { listener(rowItem) }
            itemView.news_item_title.text = rowItem.title
            itemView.news_item_description.text = rowItem.description

            GlideApp.with(itemView.context)
                .load(rowItem.urlToImage)
                .into(itemView.news_item_image)
        }
    }

    companion object {
        private const val TAG = "RecyclerAdapter"
    }
}
