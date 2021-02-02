package com.bpapps.viewgrouptest.customview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Dimension;
import androidx.annotation.Px;

import com.bpapps.viewgrouptest.R;

public class SquareLayout extends ViewGroup {

    int[] viewsPositions = new int[]{0, 0, 0, 0,};

//    private AppCompatTextView mTvStartTop;
//    private AppCompatTextView mTvEndTop;
//    private AppCompatTextView mTvEndBottom;
//    private AppCompatTextView mTvStartBottom;
//
//    private float mTextSize;
//    private int mTextColor;
//    private int mPadding;
//
//    public static int DEFAULT_TEXT_SIZE = 10;
//    public static int DEFAULT_TEXT_COLOR = 0xFF000000;
//    public static int DEFAULT_PADDING = 10;

    public SquareLayout(Context context) {
        super(context);

//        init(context);
    }

    public SquareLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

//        init(context);
    }

    public SquareLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

//        init(context);
    }

    public SquareLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

//        init(context);
    }

//    private void init(Context context) {
//        TypedArray a = context.getTheme().obtainStyledAttributes(R.styleable.SquareLayout);
//        mTextSize = spToPx(a.getFloat(R.styleable.SquareLayout_SquareLayoutTextSize, DEFAULT_TEXT_SIZE));
//        mTextColor = a.getInteger(R.styleable.SquareLayout_SquareLayoutTextColor, DEFAULT_TEXT_COLOR);
//        mPadding = dpToPx(a.getInteger(R.styleable.SquareLayout_SquareLayoutInnerPadding, DEFAULT_PADDING));
//        a.recycle();
//
//        mTvStartTop = initTextView(context, mTextSize, mTextColor, mPadding, "START|TOP");
//        mTvEndTop = initTextView(context, mTextSize, mTextColor, mPadding, "END|TOP");
//        mTvEndBottom = initTextView(context, mTextSize, mTextColor, mPadding, "END|BOTTOM");
//        mTvStartBottom = initTextView(context, mTextSize, mTextColor, mPadding, "START|BOTTOM");
//    }

//    private AppCompatTextView initTextView(Context context, float textSize, int textColor, int padding, String text) {
//        AppCompatTextView tv = new AppCompatTextView(context);
//        tv.setTextSize(textSize);
//        tv.setTextColor(textColor);
//        tv.setPadding(padding, padding, padding, padding);
//        tv.setText(text);
//
//        return tv;
//    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //TODO
        int count = getChildCount();
        int left, right, top, bottom;

        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int childWidth, childHeight;

        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            childWidth = child.getMeasuredWidth();
            childHeight = child.getMeasuredHeight();

            if (child.getVisibility() != GONE) {
                LayoutParams lp = (LayoutParams) child.getLayoutParams();

                switch (lp.position) {
                    case TOP_START:
                        left = l + paddingLeft;
                        top = t + paddingTop;
                        right = left + childWidth;
                        bottom = top + childHeight;
                        break;
                    case TOP_END:
                        left = r - paddingRight - childWidth;
                        top = t + paddingTop;
                        right = left + childWidth;
                        bottom = top + childHeight;
                        break;
                    case BOTTOM_END:
                        left = r - paddingRight - childWidth;
                        top = b - paddingBottom - childHeight;
                        right = left + childWidth;
                        bottom = top + childHeight;
                        break;
                    case BOTTOM_START:
                    default:
                        left = l + paddingLeft;
                        top = b - paddingBottom - childHeight;
                        right = left + childWidth;
                        bottom = top + childHeight;
                        break;
                }

                child.layout(left, top, right, bottom);
            }
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int count = getChildCount();
        int measuredHeight = getPaddingTop() + getPaddingBottom();
        int measuredWidth = getPaddingStart() + getPaddingEnd();
        int childState = 0;

        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);

            if (child.getVisibility() != GONE) {
                measureChild(child, widthMeasureSpec, heightMeasureSpec);

                LayoutParams lp = (LayoutParams) child.getLayoutParams();

                measuredHeight += child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;
                measuredWidth += child.getMeasuredWidth();

                childState = combineMeasuredStates(childState, child.getMeasuredState());
            }
        }

        setMeasuredDimension(
                resolveSizeAndState(measuredWidth, widthMeasureSpec, childState),
                resolveSizeAndState(measuredHeight, heightMeasureSpec, childState << MEASURED_HEIGHT_STATE_SHIFT)
        );
    }

    @Px
    private int dpToPx(@Dimension(unit = Dimension.DP) float dp) {
        final Resources resources = getResources();
        final DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics);
    }

    @Px
    public int spToPx(@Dimension(unit = Dimension.DP) float dp) {
        final Resources resources = getResources();
        final DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, dp, displayMetrics);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new SquareLayout.LayoutParams(getContext(), attrs);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }

    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new LayoutParams(p);
    }

    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof LayoutParams;
    }

    public static class LayoutParams extends MarginLayoutParams {

        public LayoutPositions position;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);

            // Pull the layout param values from the layout XML during
            // inflation.  This is not needed if you don't care about
            // changing the layout behavior in XML.
            TypedArray a = c.obtainStyledAttributes(attrs, R.styleable.SquareLayout);
            int pos = a.getInt(R.styleable.SquareLayout_layout_position, LayoutPositions.TOP_START.getValue());
            position = LayoutPositions.values()[pos - 1];
            a.recycle();
        }

        public LayoutParams(int width, int height) {
            super(width, height);
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
        }
    }

    public enum LayoutPositions {
        TOP_START(0),
        TOP_END(1),
        BOTTOM_END(2),
        BOTTOM_START(3);

        private final int position;

        LayoutPositions(int position) {
            this.position = position;
        }

        public int getValue() {
            return position;
        }
    }
}