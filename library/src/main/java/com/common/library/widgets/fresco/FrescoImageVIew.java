package com.common.library.widgets.fresco;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

/**
 * Created by riven_chris on 2017/4/2.
 */

public class FrescoImageVIew extends SimpleDraweeView {

    private ResizeOptions resizeOptions;

    public FrescoImageVIew(Context context) {
        this(context, null);
    }

    public FrescoImageVIew(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FrescoImageVIew(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public FrescoImageVIew resize(int width, int height) {
        if (width == 0 || height == 0) {
            resizeOptions = null;
            return this;
        }
        resizeOptions = new ResizeOptions(width, height);
        return this;
    }

    public void setScaleType(ScalingUtils.ScaleType scaleType) {
        GenericDraweeHierarchy hierarchy = getHierarchy();
        hierarchy.setActualImageScaleType(scaleType);
        setHierarchy(hierarchy);
    }

    public void setImageURL(@NonNull String url) {
        if (TextUtils.isEmpty(url))
            throw new IllegalArgumentException("url can not be null");
        setImageURI(Uri.parse(url));
    }

    @Override
    public void setImageURI(Uri uri) {
        ImageRequestBuilder imageRequestBuilder = ImageRequestBuilder.newBuilderWithSource(uri)
                .setAutoRotateEnabled(true)
                .setLocalThumbnailPreviewsEnabled(true)
                .setResizeOptions(resizeOptions);
        ImageRequest request = imageRequestBuilder.build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setAutoPlayAnimations(true)
                .setImageRequest(request)
                .setTapToRetryEnabled(false)//加载失败时点击重新加载
                .setOldController(getController())
                .build();
        setController(controller);
    }
}