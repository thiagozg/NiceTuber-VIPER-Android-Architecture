package br.com.nicetuber.model.adapter;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import br.com.nicetuber.model.channel.ChannelImage;

/**
 * Created by thiagozg on 22/10/2017.
 */

public class ImageBinding {

    @BindingAdapter({"android:src"})
    public static void loadImage(ImageView imageView, ChannelImage channelImage){
        Glide.with(imageView.getContext())
                .load(channelImage.getUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(imageView);
    }

}
