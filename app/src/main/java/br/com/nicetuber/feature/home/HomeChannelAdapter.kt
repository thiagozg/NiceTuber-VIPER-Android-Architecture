package br.com.nicetuber.feature.home


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.nicetuber.R
import br.com.nicetuber.model.ChannelSearched
import br.com.nicetuber.util.UIListeners
import br.com.nicetuber.util.loadCircleGlide
import kotlinx.android.synthetic.main.item_view.view.*


/**
 * Created by thiagozg on 15/10/2017.
 */

class HomeChannelAdapter(
    private val listChannelSearched: List<ChannelSearched>,
    private val listener: UIListeners.OnClickListener) : RecyclerView.Adapter<HomeChannelAdapter.ChannelHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelHolder {
        val itemView = LayoutInflater.from(parent.context)
                                     .inflate( R.layout.item_view, parent, false)

        val holder = ChannelHolder(itemView)
        holder.itemView.setOnClickListener {
            val position = holder.adapterPosition
            val channelSearched = listChannelSearched[position]
            listener.onClick(channelSearched)
        }

        return holder
    }

    override fun onBindViewHolder(holder: ChannelHolder, position: Int) {
        val channelSearched = listChannelSearched[position]
        holder.bindData(channelSearched)
    }

    override fun getItemCount(): Int {
        return listChannelSearched.size
    }

    class ChannelHolder(internal val view: View) : RecyclerView.ViewHolder(view) {

        fun bindData(channelSearched: ChannelSearched) {
            itemView.iv_channel_mini.loadCircleGlide(
                    channelSearched.snippet?.thumbnails?.imageMedium?.url)
            itemView.tv_title.text = channelSearched.snippet?.title
            itemView.tv_description.text = channelSearched.snippet?.description
        }

    }

}
