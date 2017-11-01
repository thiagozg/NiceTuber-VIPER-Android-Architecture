package br.com.nicetuber.model.adapter

import android.databinding.BindingAdapter
import android.widget.ImageView
import br.com.nicetuber.model.channel.ChannelImage
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 * Created by thiagozg on 22/10/2017.
 */

object ImageBinding {

    @BindingAdapter("android:src")
    fun loadImage(imageView: ImageView, channelImage: ChannelImage) {
        Glide.with(imageView.context)
                .load(channelImage.url)
                .apply(RequestOptions.circleCropTransform())
                .into(imageView)
    }

}
