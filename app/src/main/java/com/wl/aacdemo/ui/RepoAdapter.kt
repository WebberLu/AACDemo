package com.wl.aacdemo.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wl.aacdemo.data.model.Repo
import com.wl.aacdemo.databinding.RepoItemBinding


/**
 * Created by KY5680 on 27,08,2020
 */
class RepoAdapter constructor(private val items: MutableList<Repo>?) :
    RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {

    class RepoViewHolder(val binding: RepoItemBinding) : RecyclerView.ViewHolder(
        binding.root
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RepoItemBinding.inflate(layoutInflater, parent, false)
        return RepoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repo = items!![position]
        Glide.with(holder.itemView.context)
            .load(repo.owner!!.avatarUrl)
            .into(holder.binding.ownerAvatar)
        holder.binding.name.text = repo.fullName
        holder.binding.desc.text = repo.description
        holder.binding.stars.text = "" + repo.stars
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    fun clearItems() {
        val size = items!!.size
        items.clear()
        notifyItemRangeRemoved(0, size)
    }

    fun swapItems(newItems: List<Repo>?) {
        if (newItems == null) {
            val oldSize = this.items!!.size
            this.items.clear()
            notifyItemRangeRemoved(0, oldSize)
        } else {
            val result = DiffUtil.calculateDiff(RepoDiffCallback(this.items, newItems))
            this.items!!.clear()
            this.items.addAll(newItems)
            result.dispatchUpdatesTo(this)
        }
    }

    private inner class RepoDiffCallback internal constructor(
        private val mOldList: List<Repo>?,
        private val mNewList: List<Repo>?
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int {
            return mOldList?.size ?: 0
        }

        override fun getNewListSize(): Int {
            return mNewList?.size ?: 0
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldId = mOldList!![oldItemPosition].id
            val newId = mNewList!![newItemPosition].id
            return oldId == newId
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldRepo = mOldList!![oldItemPosition]
            val newRepo = mNewList!![newItemPosition]
            return oldRepo == newRepo
        }
    }
}