package jp.co.july.tokyo.action;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by it on 2015/09/17.
 */
public class GameView extends View{
    private static final Paint PAINT = new Paint();
    private Bitmap droidBitmap;

    public GameView(Context context) {
        super(context);
    }

    public void onDraw(Canvas canvas){
        if(droidBitmap == null){
            droidBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.droid);
        }

        canvas.drawBitmap(droidBitmap, 0,0,PAINT);
    }
}
