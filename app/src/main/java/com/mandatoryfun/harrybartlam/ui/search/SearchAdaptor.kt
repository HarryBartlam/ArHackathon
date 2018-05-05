package com.mandatoryfun.harrybartlam.ui.search

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mandatoryfun.harrybartlam.R
import com.mandatoryfun.harrybartlam.data.model.ApiAsset
import kotlinx.android.synthetic.main.element_search_card.view.*

class SearchAdaptor : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var onSearchArClick: ((asset: ApiAsset) -> Unit)? = null
    var assetsList = listOf<ApiAsset>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.element_search_card, parent, false))
    }

    override fun getItemCount(): Int {
        return assetsList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        assetsList.get(holder.adapterPosition).let { asset ->
            val name = asset.displayName
            holder.itemView.search_found_output.text = name
            holder.itemView.search_ar_button.setOnClickListener {
                onSearchArClick?.invoke(asset)
            }
        }
    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)

    fun setData(assetsList: List<ApiAsset>) {
        this.assetsList = assetsList
        notifyDataSetChanged()
    }

    fun clear() {
        assetsList = listOf<ApiAsset>()
        notifyDataSetChanged()
    }

}