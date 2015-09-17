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
    private static final float GRAVITY = 0.8f;
    private static final float WEIGHT = GRAVITY * 60;
    private float acc = 0;
    public void jump(float power){
        acc = power * WEIGHT;
    }

    public interface Callback{
        public int getDistanceFromGround(Droid droid);
    }

    private final Callback callback;

    private static final Paint paint = new Paint();
    private Bitmap bitmap;

    final Rect rect;

    public Droid(Bitmap bitmap, int left, int top, Callback callback){
        this.rect = new Rect(left, top, left+bitmap.getWidth(), top+bitmap.getHeight());
        this.bitmap=bitmap;
        this.callback = callback;
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(bitmap, rect.left, rect.top, paint);
    }

    public void move(){
        acc -= GRAVITY;

        int distanceFromGround = callback.getDistanceFromGround(this);
/*        if(distanceFromGround <= 0){
            return;
        }
        rect.offset(0, 5);
        */

        if(acc<0 && acc<-distanceFromGround){
            acc = -distanceFromGround;
        }

        rect.offset(0,-Math.round(acc));
    }
}
