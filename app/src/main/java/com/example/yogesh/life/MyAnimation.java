package com.example.yogesh.life;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;

import java.io.InputStream;

/**
 * Created by yogesh on 19/1/16.
 */
public class MyAnimation extends View
{
    private InputStream gifinput;
    private Movie movie;
    private int heigth,width;
    private long duration;
    private long start1;

    public MyAnimation(Context context)
    {
        super(context);
        init(context);
    }
    public MyAnimation(Context context,AttributeSet attributeSet)
    {
        super(context,attributeSet);
        init(context);
    }
    public MyAnimation(Context context,AttributeSet attributeSet,int defstr)
    {
        super(context,attributeSet,defstr);
        init(context);
    }

    private void init(Context context)
    {
        setFocusable(true);
        gifinput = context.getResources().openRawResource(R.raw.giphy);
        movie = Movie.decodeStream(gifinput);
        width = movie.width();
        heigth = movie.height();
        duration = movie.duration();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
   public int getWid()
   {
       return  width;
   }
    public int getHigh()
    {
        return heigth;
    }
    public long getDur()
    {
        return duration;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        long now = SystemClock.uptimeMillis();
        if(start1 == 0)
        {
            start1 = now;
        }
        if(movie != null)
        {
            int dur = movie.duration();
            if(dur == 0)
            {
                dur = 1000;
            }
            int real = (int)((now - start1) % dur);
            movie.setTime(real);
            movie.draw(canvas, 0, 0);
            invalidate();
        }

        super.onDraw(canvas);
    }
}
