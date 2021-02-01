package com.bpapps.viewgrouptest.customview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

import androidx.annotation.Dimension;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;

import com.bpapps.viewgrouptest.R;

public class Divider extends View {

    private Paint mBackgroundPaint;
    private float mStrokeWidth;
    private int mDividerColor;
    private int mOrientation;

    public static int DEFAULT_DIVIDER_WIDTH = 1;

    public static int ORIENTATION_VERTICAL = 1;
    public static int ORIENTATION_HORIZONTAL = 2;

    public Divider(Context context) {
        this(context, null);
    }

    public Divider(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.Divider, 0, 0);
        mStrokeWidth = dpToPx(a.getInteger(R.styleable.Divider_dividerStrokeWidth, DEFAULT_DIVIDER_WIDTH));
        mDividerColor = a.getColor(R.styleable.Divider_dividerColor, ContextCompat.getColor(context, R.color.colorPrimary));
        mOrientation = a.getInt(R.styleable.Divider_dividerOrientation, ORIENTATION_HORIZONTAL);
        a.recycle();

        mBackgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBackgroundPaint.setColor(mDividerColor);
        mBackgroundPaint.setStrokeWidth(mStrokeWidth);
    }
//    public Divider(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//    }
//
//    public Divider(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }

    @Override
    protected void onDraw(Canvas canvas) {
        float canvasWidth = canvas.getWidth();
        float canvasHeight = canvas.getHeight();

        float startX, stopX, startY, stopY;
        if (mOrientation == ORIENTATION_VERTICAL) {
            startX = canvasWidth / 2;
            stopX = canvasWidth / 2;
            startY = 0;
            stopY = canvasHeight;
        } else {
//            mOrientation == ORIENTATION_HORIZONTAL
            startX = 0;
            stopX = canvasWidth;
            startY = canvasHeight / 2;
            stopY = canvasHeight / 2;
        }
        canvas.drawLine(startX, startY, stopX, stopY, mBackgroundPaint);
    }

    @Px
    private float dpToPx(@Dimension(unit = Dimension.DP) float dp) {
        final Resources resources = getResources();
        final DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics);
    }
}
