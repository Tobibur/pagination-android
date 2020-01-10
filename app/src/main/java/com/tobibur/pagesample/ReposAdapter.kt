package com.tobibur.pagesample

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tobibur.pagesample.data.Item
import com.tobibur.pagesample.helper.inflate
import com.tobibur.pagesample.helper.load
import kotlinx.android.synthetic.main.repos_item.view.*

class ReposAdapter(private val list: MutableList<Item>) :
    RecyclerView.Adapter<ReposAdapter.ReposViewHolder>() {


    inner class ReposViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposViewHolder {
        return ReposViewHolder(parent.inflate(R.layout.repos_item))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ReposViewHolder, position: Int) {
        val repo = list[position]
        holder.itemView.apply {
            txt_name.text = repo.fullName
            txt_desc.text = repo.description
            imgAvatar.load(repo.owner.avatarUrl, context)
        }
    }

    fun addAll(list: List<Item>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}