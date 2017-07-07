package com.consultoraestrategia.ss_crmeducativo.lib;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.target.BitmapImageViewTarget;



/**
 * Created by kelvi on 22/02/2017.
 */

public class GlideImageLoader implements ImageLoader {
    private RequestManager glideRequestManager;
    private Context context;
//    private CropCircleTransformation circleTransformation;

    public GlideImageLoader(Context context) {
        this.context = context;
        this.glideRequestManager = Glide.with(context);

    }

    @Override
    public void load(ImageView imageView, String URL) {
        glideRequestManager.load(URL).into(imageView);
    }




    @Override
    public void loadWithCircular(final ImageView imageView, String url) {
        glideRequestManager.load(url).asBitmap().centerCrop().into(new BitmapImageViewTarget(imageView) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                imageView.setImageDrawable(circularBitmapDrawable);
            }
        });
    }
}
