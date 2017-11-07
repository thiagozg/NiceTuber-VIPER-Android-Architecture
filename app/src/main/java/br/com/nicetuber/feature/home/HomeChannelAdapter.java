package br.com.nicetuber.feature.home;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import br.com.nicetuber.R;
import br.com.nicetuber.databinding.ItemViewBinding;
import br.com.nicetuber.model.ChannelSearched;
import br.com.nicetuber.util.UIListeners;

/**
 * Created by thiagozg on 15/10/2017.
 */

public class HomeChannelAdapter extends RecyclerView.Adapter<HomeChannelAdapter.ChannelHolder> {

    private List<ChannelSearched> listChannelSearched;
    private UIListeners.OnClickListener listener;

    public HomeChannelAdapter(List<ChannelSearched> listChannelSearched, UIListeners.OnClickListener listener) {
        this.listChannelSearched = listChannelSearched;
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
            ChannelSearched channelSearched = listChannelSearched.get(position);
            listener.onClick(channelSearched);
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ChannelHolder holder, int position) {
        ChannelSearched channelSearched = listChannelSearched.get(position);
        holder.binding.setChannelSearched(channelSearched);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return listChannelSearched.size();
    }

    public static class ChannelHolder extends RecyclerView.ViewHolder {

        private ItemViewBinding binding;

        public ChannelHolder(ItemViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }

}
