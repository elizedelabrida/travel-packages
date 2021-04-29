package com.elize.travel.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import androidx.core.content.res.ResourcesCompat;

public class ResourcesUtil {

    private static final String DRAWABLE = "drawable";

    public static Drawable getDrawable(Context context, String drawableText) {
        Resources resources = context.getResources();
        int drawableId = resources.getIdentifier(drawableText,
                DRAWABLE, context.getPackageName());
        return ResourcesCompat.getDrawable(resources, drawableId, null);
    }
}
