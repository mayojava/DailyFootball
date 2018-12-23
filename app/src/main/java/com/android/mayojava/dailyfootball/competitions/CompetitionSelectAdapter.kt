package com.android.mayojava.dailyfootball.competitions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.mayojava.dailyfootball.R
import kotlinx.android.synthetic.main.competitions_drop_down_row.view.*

class CompetitionSelectAdapter: RecyclerView.Adapter<CompetitionSelectAdapter.ViewHolder>() {

    private val items: MutableList<CompetitionsUIModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.competitions_drop_down_row, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setItems(rows: List<CompetitionsUIModel>) {
        items.clear()
        items.addAll(rows)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(rowItem: CompetitionsUIModel) {
            itemView.competitionName.text = rowItem.name
        }
    }
}
