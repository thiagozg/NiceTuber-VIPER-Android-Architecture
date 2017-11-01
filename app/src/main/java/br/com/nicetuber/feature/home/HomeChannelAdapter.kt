package br.com.nicetuber.feature.home

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

import br.com.nicetuber.R
import br.com.nicetuber.databinding.ItemViewBinding
import br.com.nicetuber.model.ChannelSearched
import br.com.nicetuber.util.UIListeners

/**
 * Created by thiagozg on 15/10/2017.
 */

class HomeChannelAdapter(private val listChannelSearched: List<ChannelSearched>, private val listener: UIListeners.OnClickListener) : RecyclerView.Adapter<HomeChannelAdapter.ChannelHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelHolder {
        val binding = DataBindingUtil.inflate<ItemViewBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_view,
                parent, false)

        val holder = ChannelHolder(binding)
        holder.itemView.setOnClickListener {
            val position = holder.adapterPosition
            val channelSearched = listChannelSearched[position]
            listener.onClick(channelSearched)
        }

        return holder
    }

    override fun onBindViewHolder(holder: ChannelHolder, position: Int) {
        val channelSearched = listChannelSearched[position]
        holder.binding.channelSearched = channelSearched
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return listChannelSearched.size
    }

    class ChannelHolder(internal val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root)

}
