package com.bpapps.viewgrouptest.customview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Dimension;
import androidx.annotation.Px;

import com.bpapps.viewgrouptest.R;

public class SquareLayout extends ViewGroup {

    int[] viewsPositions = new int[]{0, 0, 0, 0,};

    //    /**
//     * These are used for computing child frames based on their gravity.
//     */
    private final Rect mTmpContainerRect = new Rect();
    private final Rect mTmpChildRect = new Rect();


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

//        ViewGroup.MarginLayoutParams lp = (MarginLayoutParams) getLayoutParams();
//        int marginLeft = lp.leftMargin;
//        int marginRight = lp.rightMargin;
//        int marginTop = lp.topMargin;
//        int marginBottom = lp.bottomMargin;

        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();

//        int marginLeft = 0;
//        int marginRight = 0;
//        int marginTop = 0;
//        int marginBottom = 0;
//        ViewParent parent = getParent();
//        int parentWidth;
//        int parentHeight;
//        if (parent instanceof View) {
//            View parentView = (View) parent;
//            parentWidth = parentView.getMeasuredWidth();
//            parentHeight = parentView.getMeasuredHeight();
////
//            paddingLeft += parentView.getPaddingLeft();
//            paddingRight += parentView.getPaddingRight();
//            paddingTop += parentView.getPaddingTop();
//            paddingBottom += parentView.getPaddingBottom();
//
//            ViewGroup.MarginLayoutParams lpParent = (MarginLayoutParams) parentView.getLayoutParams();
//            marginLeft += lpParent.leftMargin;
//            marginRight += lpParent.rightMargin;
//            marginTop += lpParent.topMargin;
//            marginBottom += lpParent.bottomMargin;
//        }

        int childWidth, childHeight;

        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);


            if (child.getVisibility() != GONE) {
                childWidth = child.getMeasuredWidth();
                childHeight = child.getMeasuredHeight();

                LayoutParams lpChild = (LayoutParams) child.getLayoutParams();
                int marginLeft = lpChild.leftMargin;
                int marginRight = lpChild.rightMargin;
                int marginTop = lpChild.topMargin;
                int marginBottom = lpChild.bottomMargin;

                switch (lpChild.position) {
                    case TOP_START:
//                        mTmpContainerRect.left = l + paddingLeft;
//                        mTmpContainerRect.top = t + paddingTop;
//                        mTmpContainerRect.right = mTmpChildRect.left + childWidth;
//                        mTmpContainerRect.bottom = mTmpContainerRect.top + childHeight;

//                        left = l + paddingLeft + marginLeft;
//                        top = t + paddingTop + marginTop;
                        left = l + paddingLeft + marginLeft;
                        top = t + paddingTop + marginTop;
                        right = left + childWidth;
                        bottom = top + childHeight;
                        break;
                    case TOP_END:
//                        mTmpContainerRect.left = r - paddingRight;
//                        mTmpContainerRect.top = t + paddingTop;
//                        mTmpContainerRect.right = mTmpChildRect.left + childWidth;
//                        mTmpContainerRect.bottom = mTmpContainerRect.top + childHeight;

//                        left = r - paddingRight - marginRight - childWidth;
//                        top = t + paddingTop + marginTop;
                        left = r - paddingRight - -marginRight - childWidth;
                        top = t + paddingTop + marginTop;
                        right = left + childWidth;
                        bottom = top + childHeight;
                        break;
                    case BOTTOM_END:
//                        mTmpContainerRect.left = r - paddingRight;
//                        mTmpContainerRect.top = b - paddingBottom - childHeight;
//                        mTmpContainerRect.right = mTmpChildRect.left + childWidth;
//                        mTmpContainerRect.bottom = mTmpContainerRect.top + childHeight;

//                        left = r - paddingRight - marginRight - childWidth;
//                        top = b - paddingBottom - marginBottom - childHeight;
                        left = r - paddingRight - marginRight - childWidth;
                        top = b - paddingBottom - marginBottom - childHeight;
                        right = left + childWidth;
                        bottom = top + childHeight;
                        break;
                    case BOTTOM_START:
                    default:
//                        mTmpContainerRect.left = l + paddingLeft;
//                        mTmpContainerRect.top = b - paddingBottom - childHeight;
//                        mTmpContainerRect.right = mTmpChildRect.left + childWidth;
//                        mTmpContainerRect.bottom = mTmpContainerRect.top + childHeight;

//                        left = l + paddingLeft + marginLeft;
//                        top = b - paddingBottom - marginBottom - childHeight;
                        left = l + paddingLeft + marginLeft;
                        top = b - paddingBottom - marginBottom - childHeight;
                        right = left + childWidth;
                        bottom = top + childHeight;
                        break;
                }

                // Use the child's gravity and size to determine its final
//                // frame within its container.
//                mTmpContainerRect.left = l + paddingLeft;
//                mTmpContainerRect.top = b - paddingBottom - childHeight;
//                mTmpContainerRect.right = mTmpChildRect.left + childWidth;
//                mTmpContainerRect.bottom = mTmpContainerRect.top + childHeight;
//                Gravity.apply(lpChild.gravity, childWidth, childHeight, mTmpContainerRect, mTmpChildRect);
//                child.layout(mTmpChildRect.left, mTmpChildRect.top, mTmpChildRect.right, mTmpChildRect.bottom);
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
        public int gravity = Gravity.TOP | Gravity.START;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);

            // Pull the layout param values from the layout XML during
            // inflation.  This is not needed if you don't care about
            // changing the layout behavior in XML.
            TypedArray a = c.obtainStyledAttributes(attrs, R.styleable.SquareLayout);
            int pos = a.getInt(R.styleable.SquareLayout_layout_position, LayoutPositions.TOP_START.getValue());
            position = LayoutPositions.values()[pos - 1];
            gravity = a.getInt(R.styleable.SquareLayout_android_layout_gravity, gravity);
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