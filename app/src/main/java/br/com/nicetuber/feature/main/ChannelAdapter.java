package br.com.nicetuber.feature.main;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import br.com.nicetuber.R;
import br.com.nicetuber.databinding.ItemViewBinding;
import br.com.nicetuber.model.Channel;
import br.com.nicetuber.util.UIListeners;

/**
 * Created by thiagozg on 15/10/2017.
 */

public class ChannelAdapter extends RecyclerView.Adapter<ChannelAdapter.ChannelHolder> {

    private List<Channel> listChannel;
    private UIListeners.OnClickListener listener;

    public ChannelAdapter(List<Channel> listChannel, UIListeners.OnClickListener listener) {
        this.listChannel = listChannel;
        this.listener = listener;
    }

    @Override
    public ChannelHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemViewBinding binding = DataBindingUtil.inflate(
                                    LayoutInflater.from(parent.getContext()),
                                    R.layout.item_view,
                                    parent, false);

        ChannelHolder holder = new ChannelHolder(binding);
        holder.itemView.setOnClickListener(view -> {
            int position = holder.getAdapterPosition();
            Channel channel = listChannel.get(position);
            listener.onClick(channel);
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ChannelHolder holder, int position) {
        Channel channel = listChannel.get(position);
        holder.binding.setChannel(channel);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return listChannel.size();
    }

    public static class ChannelHolder extends RecyclerView.ViewHolder {

        private ItemViewBinding binding;

        public ChannelHolder(ItemViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }

}
