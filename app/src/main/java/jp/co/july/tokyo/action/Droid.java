package jp.co.july.tokyo.action;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by it on 2015/09/17.
 */
public class Droid {
    private static final Paint paint = new Paint();
    private Bitmap bitmap;

    final Rect rect;

    public Droid(Bitmap bitmap, int left, int top){
        this.rect = new Rect(left, top, left+bitmap.getWidth(), top+bitmap.getHeight());
        this.bitmap=bitmap;
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(bitmap, rect.left, rect.top, paint);
    }

    public void move(){
        rect.offset(0, 5);
    }
}