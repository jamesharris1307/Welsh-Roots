package com.example.welshroots.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.PictureDrawable;
import android.graphics.drawable.VectorDrawable;
import androidx.core.content.res.ResourcesCompat;
import com.caverock.androidsvg.SVG;

public class Tools {

    public static Bitmap getBitmapFromSvg(Context context, int svgResId) {
        try {
            // Load the SVG from resources
            SVG svg = SVG.getFromResource(context, svgResId);

            // /Convert SVG to PictureDrawable
            PictureDrawable pictureDrawable = new PictureDrawable(svg.renderToPicture());

            // Create a Bitmap and draw the PictureDrawable onto it
            Bitmap bitmap = Bitmap.createBitmap(pictureDrawable.getIntrinsicWidth(), pictureDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            pictureDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            pictureDrawable.draw(canvas);

            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
