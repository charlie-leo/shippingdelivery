/*
 * Copyright (C) 2016 Botree Software International Private Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.editor.shippingdelivery.utils.topsnackbar;

import static com.editor.shippingdelivery.utils.topsnackbar.AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

import com.editor.shippingdelivery.R;
import com.google.android.material.behavior.SwipeDismissBehavior;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


public final class TSnackbar {


    public static final int LENGTH_SHORT = -1;
    public static final int LENGTH_LONG = 1;
    private static final int SNACKBAR_LAYOUT_ANDROID_MAX_WIDTH = 0;
    static final int LENGTH_INDEFINITE = -2;
    private static final int ANIMATION_DURATION = 250;
    private static final int ANIMATION_FADE_DURATION = 180;
    private static final Handler sHandler;
    private static final int MSG_SHOW = 0;
    private static final int MSG_DISMISS = 1;

    static {
        sHandler = new Handler(Looper.getMainLooper(), message -> {
            switch (message.what) {
                case MSG_SHOW:
                    try {
                        ((TSnackbar) message.obj).showView();
                    } catch (Exception e) {
                    }
                    return true;
                case MSG_DISMISS:
                    try {
                        ((TSnackbar) message.obj).hideView(message.arg1);
                    } catch (Exception e) {
                    }
                    return true;
                default:
                    break;
            }
            return false;
        });
    }

    private final ViewGroup mParent;
    private final Context mContext;
    private final SnackbarLayout mView;
    private final SnackbarManager.Callback mManagerCallback = new SnackbarManager.Callback() {
        @Override
        public void show() {
            sHandler.sendMessage(sHandler.obtainMessage(MSG_SHOW, TSnackbar.this));
        }

        @Override
        public void dismiss(int event) {
            sHandler.sendMessage(sHandler.obtainMessage(MSG_DISMISS, event, 0, TSnackbar.this));
        }
    };
    private int mDuration;
    private Callback mCallback;
    private static boolean isBottomSnack = false;

    private TSnackbar(ViewGroup parent) {
        mParent = parent;
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        mView = (SnackbarLayout) inflater.inflate(R.layout.tsnackbar_layout, mParent, false);
    }

    @NonNull
    public static TSnackbar make(@NonNull View view, @NonNull CharSequence text,
                                 @Duration int duration) {
        TSnackbar snackbar = new TSnackbar(findSuitableParent(view));
        snackbar.setText(text);
        snackbar.setDuration(duration);
        isBottomSnack = false;
        return snackbar;
    }

    @NonNull
    public static TSnackbar make(@NonNull View view, @NonNull CharSequence text,
                                 @Duration int duration, boolean isBottomSnackBar) {
        TSnackbar snackbar = new TSnackbar(findSuitableParent(view));
        snackbar.setText(text);
        snackbar.setDuration(duration);
        isBottomSnack = isBottomSnackBar;
        return snackbar;
    }

    @NonNull
    public static TSnackbar make(@NonNull View view, @StringRes int resId, @Duration int duration) {
        return make(view, view.getResources()
                .getText(resId), duration);
    }

    private static ViewGroup findSuitableParent(View view) {
        ViewGroup fallback = null;
        do {
            if (view instanceof CoordinatorLayout) {

                return (ViewGroup) view;
            } else if (view instanceof FrameLayout) {
                if (view.getId() == android.R.id.content) {


                    return (ViewGroup) view;
                } else {

                    fallback = (ViewGroup) view;
                }
            }

            if (view != null) {

                final ViewParent parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
        } while (view != null);


        return fallback;
    }

    private static float convertDpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private static Bitmap getBitmap(VectorDrawable vectorDrawable) {
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        vectorDrawable.draw(canvas);
        return bitmap;
    }

    private static Bitmap getBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && drawable instanceof VectorDrawable) {
            return getBitmap((VectorDrawable) drawable);
        } else {
            throw new IllegalArgumentException("unsupported drawable type");
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public TSnackbar addIcon(int resourceId, int size) {
        final TextView tv = mView.getMessageView();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tv.setCompoundDrawablesWithIntrinsicBounds(new BitmapDrawable(mContext.getResources(), Bitmap.createScaledBitmap(((BitmapDrawable) (mContext.getResources()
                    .getDrawable(resourceId, null))).getBitmap(), size, size, true)), null, null, null);

        } else {

            tv.setCompoundDrawablesWithIntrinsicBounds(new BitmapDrawable(mContext.getResources(), Bitmap.createScaledBitmap(((BitmapDrawable) (mContext.getResources()
                    .getDrawable(resourceId))).getBitmap(), size, size, true)), null, null, null);
        }


        return this;
    }

    public void setIconPadding(int padding) {
        final TextView tv = mView.getMessageView();
        tv.setCompoundDrawablePadding(padding);
    }

    public void setIconLeft(@DrawableRes int drawableRes, float sizeDp) {
        TextView tv = mView.getMessageView();
        Drawable drawable = ContextCompat.getDrawable(mContext, drawableRes);
        if (drawable != null) {
            drawable = fitDrawable(drawable, (int) convertDpToPixel(sizeDp, mContext));
        } else {
            throw new IllegalArgumentException("resource_id is not a valid drawable!");
        }
        Drawable[] compoundDrawables = tv.getCompoundDrawables();
        tv.setCompoundDrawables(drawable, compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
    }

    public TSnackbar setIconRight(@DrawableRes int drawableRes, float sizeDp) {
        final TextView tv =mView.getMessageView();
        Drawable drawable = ContextCompat.getDrawable(mContext, drawableRes);
        if (drawable != null) {
            drawable = fitDrawable(drawable, (int) convertDpToPixel(sizeDp, mContext));
        } else {
            throw new IllegalArgumentException("resource_id is not a valid drawable!");
        }
        Drawable[] compoundDrawables = tv.getCompoundDrawables();
        tv.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], drawable, compoundDrawables[3]);
        return this;
    }

    /**
     * Overrides the max width of this snackbar's layout. This is typically not necessary; the snackbar
     * width will be according to Google's Material guidelines. Specifically, the max width will be
     * <p>
     * To allow the snackbar to have a width equal to the parent view, set a value <= 0.
     *
     * @param maxWidth the max width in pixels
     * @return this TSnackbar
     */
    public TSnackbar setMaxWidth(int maxWidth) {
        mView.mMaxWidth = maxWidth;

        return this;
    }

    private Drawable fitDrawable(Drawable drawable, int sizePx) {
        if ((drawable.getIntrinsicWidth() != sizePx || drawable.getIntrinsicHeight() != sizePx) && drawable instanceof BitmapDrawable) {

            drawable = new BitmapDrawable(mContext.getResources(), Bitmap.createScaledBitmap(getBitmap(drawable), sizePx, sizePx, true));
        }
        drawable.setBounds(0, 0, sizePx, sizePx);

        return drawable;
    }

    @NonNull
    public TSnackbar setAction(@StringRes int resId, View.OnClickListener listener) {
        return setAction(mContext.getText(resId), listener);
    }

    @NonNull
    private TSnackbar setAction(CharSequence text, final View.OnClickListener listener) {
        final TextView tv = mView.getActionView();

        if (TextUtils.isEmpty(text) || listener == null) {
            tv.setVisibility(View.GONE);
            tv.setOnClickListener(null);
        } else {
            tv.setVisibility(View.VISIBLE);
            /*String udata=text.toString();
            SpannableString content = new SpannableString(udata);
            content.setSpan(new UnderlineSpan(), 0, udata.length(), 0);*/
            tv.setText(text.toString());
            tv.setBackground(ContextCompat.getDrawable(mContext, R.drawable.activatable_ztoa));
            tv.setOnClickListener(view -> {
                listener.onClick(view);

                dispatchDismiss(Callback.DISMISS_EVENT_ACTION);
            });
        }
        return this;
    }

    @NonNull
    public TSnackbar setActionTextColor(ColorStateList colors) {
        final TextView tv = mView.getActionView();
        tv.setTextColor(colors);
        return this;
    }

    public void setActionTextColor(@ColorInt int color) {
        final TextView tv = mView.getActionView();
        tv.setTextColor(color);
    }

    @NonNull
    public TSnackbar setText(@NonNull CharSequence message) {
        final TextView tv =mView.getMessageView();
        tv.setText(message);
        return this;
    }

    @NonNull
    public TSnackbar setText(@StringRes int resId) {
        return setText(mContext.getText(resId));
    }

    @Duration
    public int getDuration() {
        return mDuration;
    }

    @NonNull
    public TSnackbar setDuration(@Duration int duration) {
        mDuration = duration;
        return this;
    }

    @NonNull
    public View getView() {
        return mView;
    }

    public void show() {
        SnackbarManager.getInstance()
                .show(mDuration, mManagerCallback);
    }

    public void dismiss() {
        dispatchDismiss(Callback.DISMISS_EVENT_MANUAL);
    }

    private void dispatchDismiss(@Callback.DismissEvent int event) {
        SnackbarManager.getInstance()
                .dismiss(mManagerCallback, event);
    }

    @NonNull
    public TSnackbar setCallback(Callback callback) {
        mCallback = callback;
        return this;
    }

    public boolean isShown() {
        return SnackbarManager.getInstance()
                .isCurrent(mManagerCallback);
    }

    private boolean isShownOrQueued() {
        return SnackbarManager.getInstance()
                .isCurrentOrNext(mManagerCallback);
    }

    private final void showView() {
        if (mView.getParent() == null) {
            ViewGroup.LayoutParams lp = mView.getLayoutParams();

            if (lp instanceof CoordinatorLayout.LayoutParams) {
                Behavior behavior = new Behavior();
                behavior.setStartAlphaSwipeDistance(0.1f);
                behavior.setEndAlphaSwipeDistance(0.6f);
                behavior.setSwipeDirection(SwipeDismissBehavior.SWIPE_DIRECTION_START_TO_END);
                behavior.setListener(new SwipeDismissBehavior.OnDismissListener() {
                    @Override
                    public void onDismiss(View view) {
                        dispatchDismiss(Callback.DISMISS_EVENT_SWIPE);
                    }

                    @Override
                    public void onDragStateChanged(int state) {
                        switch (state) {
                            case SwipeDismissBehavior.STATE_DRAGGING:
                            case SwipeDismissBehavior.STATE_SETTLING:

                                SnackbarManager.getInstance()
                                        .cancelTimeout(mManagerCallback);
                                break;
                            case SwipeDismissBehavior.STATE_IDLE:

                                SnackbarManager.getInstance()
                                        .restoreTimeout(mManagerCallback);
                                break;
                            default:
                                break;
                        }
                    }
                });
                ((CoordinatorLayout.LayoutParams) lp).setBehavior(behavior);
            }
            mParent.addView(mView);
        }

        mView.setOnAttachStateChangeListener(new SnackbarLayout.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View v) {
                //ignored
            }

            @Override
            public void onViewDetachedFromWindow(View v) {
                if (isShownOrQueued()) {


                    sHandler.post(() -> onViewHidden(Callback.DISMISS_EVENT_MANUAL));
                }
            }
        });

        if (ViewCompat.isLaidOut(mView)) {
            animateViewIn();
        } else {
            mView.setOnLayoutChangeListener((view, left, top, right, bottom) -> {
                animateViewIn();
                mView.setOnLayoutChangeListener(null);
            });
        }
    }

    private void animateViewIn() {

        float height = -mView.getHeight();
        if (isBottomSnack) {
            height = mView.getHeight();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            ViewCompat.setTranslationY(mView, height);
            ViewCompat.animate(mView)
                    .translationY(0f)
                    .setInterpolator(FAST_OUT_SLOW_IN_INTERPOLATOR)
                    .setDuration(ANIMATION_DURATION)
                    .setListener(new ViewPropertyAnimatorListenerAdapter() {
                        @Override
                        public void onAnimationStart(View view) {
                            mView.animateChildrenIn(ANIMATION_DURATION - ANIMATION_FADE_DURATION,
                                    ANIMATION_FADE_DURATION);
                        }

                        @Override
                        public void onAnimationEnd(View view) {
                            if (mCallback != null) {
                                mCallback.onShown(TSnackbar.this);
                            }
                            SnackbarManager.getInstance()
                                    .onShown(mManagerCallback);
                        }
                    })
                    .start();
        } else {
            Animation anim = AnimationUtils.loadAnimation(mView.getContext(),
                    R.anim.top_in);
            if (isBottomSnack) {
                anim = AnimationUtils.loadAnimation(mView.getContext(),
                        R.anim.top_out);
            }
            anim.setInterpolator(FAST_OUT_SLOW_IN_INTERPOLATOR);
            anim.setDuration(ANIMATION_DURATION);
            anim.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationEnd(Animation animation) {
                    if (mCallback != null) {
                        mCallback.onShown(TSnackbar.this);
                    }
                    SnackbarManager.getInstance()
                            .onShown(mManagerCallback);
                }

                @Override
                public void onAnimationStart(Animation animation) {
                    //ignored
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                    //ignored
                }
            });
            mView.startAnimation(anim);
        }
    }

    private void animateViewOut(final int event) {
        float height = -mView.getHeight();
        if (isBottomSnack) {
            height = mView.getHeight();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            ViewCompat.animate(mView)
                    .translationY(height)
                    .setInterpolator(FAST_OUT_SLOW_IN_INTERPOLATOR)
                    .setDuration(ANIMATION_DURATION)
                    .setListener(new ViewPropertyAnimatorListenerAdapter() {
                        @Override
                        public void onAnimationStart(View view) {
                            mView.animateChildrenOut(0, ANIMATION_FADE_DURATION);
                        }

                        @Override
                        public void onAnimationEnd(View view) {
                            onViewHidden(event);
                        }
                    })
                    .start();
        } else {
            Animation anim = AnimationUtils.loadAnimation(mView.getContext(), R.anim.top_out);
            if (isBottomSnack) {
                anim = AnimationUtils.loadAnimation(mView.getContext(), R.anim.top_in);
            }
            anim.setInterpolator(FAST_OUT_SLOW_IN_INTERPOLATOR);
            anim.setDuration(ANIMATION_DURATION);
            anim.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationEnd(Animation animation) {
                    onViewHidden(event);
                }

                @Override
                public void onAnimationStart(Animation animation) {
                    //ignored
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                    //ignored
                }
            });
            mView.startAnimation(anim);
        }
    }

    private final void hideView(int event) {
        if (mView.getVisibility() != View.VISIBLE || isBeingDragged()) {
            onViewHidden(event);
        } else {
            animateViewOut(event);
        }
    }

    private void onViewHidden(int event) {

        SnackbarManager.getInstance()
                .onDismissed(mManagerCallback);

        if (mCallback != null) {
            mCallback.onDismissed(this, event);
        }

        ViewParent parent = mView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(mView);
        }
    }

    private boolean isBeingDragged() {
        ViewGroup.LayoutParams lp = mView.getLayoutParams();

        if (lp instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.LayoutParams cllp = (CoordinatorLayout.LayoutParams) lp;
            CoordinatorLayout.Behavior behavior = cllp.getBehavior();

            if (behavior instanceof SwipeDismissBehavior) {
                return ((SwipeDismissBehavior) behavior).getDragState()
                        != SwipeDismissBehavior.STATE_IDLE;
            }
        }
        return false;
    }

    @IntDef({LENGTH_INDEFINITE, LENGTH_SHORT, LENGTH_LONG})
    @Retention(RetentionPolicy.SOURCE)
    @interface Duration {
    }

    abstract static class Callback {

        static final int DISMISS_EVENT_SWIPE = 0;

        static final int DISMISS_EVENT_ACTION = 1;

        static final int DISMISS_EVENT_TIMEOUT = 2;

        static final int DISMISS_EVENT_MANUAL = 3;

        static final int DISMISS_EVENT_CONSECUTIVE = 4;

        void onDismissed(TSnackbar snackbar, @DismissEvent int event) {

        }

        void onShown(TSnackbar snackbar) {

        }


        @IntDef({
                DISMISS_EVENT_SWIPE, DISMISS_EVENT_ACTION, DISMISS_EVENT_TIMEOUT,
                DISMISS_EVENT_MANUAL, DISMISS_EVENT_CONSECUTIVE
        })
        @Retention(RetentionPolicy.SOURCE)
        private @interface DismissEvent {
        }
    }

    public static class SnackbarLayout extends LinearLayout {
        private TextView mMessageView;
        private Button mActionView;

        private int mMaxWidth;
        private int mMaxInlineActionWidth;
        private OnLayoutChangeListener mOnLayoutChangeListener;
        private OnAttachStateChangeListener mOnAttachStateChangeListener;

        public SnackbarLayout(Context context) {
            this(context, null);
        }

        public SnackbarLayout(Context context, AttributeSet attrs) {
            super(context, attrs);
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SnackbarLayout);
            mMaxWidth = a.getDimensionPixelSize(SNACKBAR_LAYOUT_ANDROID_MAX_WIDTH, -1);
            mMaxInlineActionWidth = a.getDimensionPixelSize(
                    R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
            if (a.hasValue(R.styleable.SnackbarLayout_elevation)) {
                ViewCompat.setElevation(this, a.getDimensionPixelSize(
                        R.styleable.SnackbarLayout_elevation, 0));
            }
            a.recycle();

            setClickable(true);


            LayoutInflater.from(context)
                    .inflate(R.layout.tsnackbar_layout_include, this);

            ViewCompat.setAccessibilityLiveRegion(this,
                    ViewCompat.ACCESSIBILITY_LIVE_REGION_POLITE);
        }

        private static void updateTopBottomPadding(View view, int topPadding, int bottomPadding) {
            if (ViewCompat.isPaddingRelative(view)) {
                ViewCompat.setPaddingRelative(view,
                        ViewCompat.getPaddingStart(view), topPadding,
                        ViewCompat.getPaddingEnd(view), bottomPadding);
            } else {
                view.setPadding(view.getPaddingLeft(), topPadding,
                        view.getPaddingRight(), bottomPadding);
            }
        }

        @Override
        protected void onFinishInflate() {
            super.onFinishInflate();
            mMessageView = findViewById(R.id.snackbar_text);
            mActionView = findViewById(R.id.snackbar_action);
        }

        TextView getMessageView() {
            return mMessageView;
        }

        Button getActionView() {
            return mActionView;
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);

            if (mMaxWidth > 0 && getMeasuredWidth() > mMaxWidth) {
                widthMeasureSpec = MeasureSpec.makeMeasureSpec(mMaxWidth, MeasureSpec.EXACTLY);
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            }

            final int multiLineVPadding = getResources().getDimensionPixelSize(
                    R.dimen._16sdp);
            final int singleLineVPadding = getResources().getDimensionPixelSize(
                    R.dimen._16sdp);
            boolean isMultiLine = mMessageView.getLayout()
                    .getLineCount() > 1;

            boolean remeasure = false;
            if (isMultiLine && mMaxInlineActionWidth > 0
                    && mActionView.getMeasuredWidth() > mMaxInlineActionWidth) {
                if (updateViewsWithinLayout(VERTICAL, multiLineVPadding,
                        multiLineVPadding - singleLineVPadding)) {
                    remeasure = true;
                }
            } else {
                int messagePadding = isMultiLine ? multiLineVPadding : singleLineVPadding;
                if (updateViewsWithinLayout(HORIZONTAL, messagePadding, messagePadding)) {
                    remeasure = true;
                }
            }

            if (remeasure) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            }
        }

        void animateChildrenIn(int delay, int duration) {
            ViewCompat.setAlpha(mMessageView, 0f);
            ViewCompat.animate(mMessageView)
                    .alpha(1f)
                    .setDuration(duration)
                    .setStartDelay(delay)
                    .start();

            if (mActionView.getVisibility() == VISIBLE) {
                ViewCompat.setAlpha(mActionView, 0f);
                ViewCompat.animate(mActionView)
                        .alpha(1f)
                        .setDuration(duration)
                        .setStartDelay(delay)
                        .start();
            }
        }

        void animateChildrenOut(int delay, int duration) {
            ViewCompat.setAlpha(mMessageView, 1f);
            ViewCompat.animate(mMessageView)
                    .alpha(0f)
                    .setDuration(duration)
                    .setStartDelay(delay)
                    .start();

            if (mActionView.getVisibility() == VISIBLE) {
                ViewCompat.setAlpha(mActionView, 1f);
                ViewCompat.animate(mActionView)
                        .alpha(0f)
                        .setDuration(duration)
                        .setStartDelay(delay)
                        .start();
            }
        }

        @Override
        protected void onLayout(boolean changed, int l, int t, int r, int b) {
            super.onLayout(changed, l, t, r, b);
            if (changed && mOnLayoutChangeListener != null) {
                mOnLayoutChangeListener.onLayoutChange(this, l, t, r, b);
            }
        }

        @Override
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (mOnAttachStateChangeListener != null) {
                mOnAttachStateChangeListener.onViewAttachedToWindow(this);
            }
        }

        @Override
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (mOnAttachStateChangeListener != null) {
                mOnAttachStateChangeListener.onViewDetachedFromWindow(this);
            }
        }

        void setOnLayoutChangeListener(OnLayoutChangeListener onLayoutChangeListener) {
            mOnLayoutChangeListener = onLayoutChangeListener;
        }

        void setOnAttachStateChangeListener(OnAttachStateChangeListener listener) {
            mOnAttachStateChangeListener = listener;
        }

        private boolean updateViewsWithinLayout(final int orientation,
                                                final int messagePadTop, final int messagePadBottom) {
            boolean changed = false;
            if (orientation != getOrientation()) {
                setOrientation(orientation);
                changed = true;
            }
            if (mMessageView.getPaddingTop() != messagePadTop
                    || mMessageView.getPaddingBottom() != messagePadBottom) {
                updateTopBottomPadding(mMessageView, messagePadTop, messagePadBottom);
                changed = true;
            }
            return changed;
        }

        interface OnLayoutChangeListener {
            void onLayoutChange(View view, int left, int top, int right, int bottom);
        }

        interface OnAttachStateChangeListener {
            void onViewAttachedToWindow(View v);

            void onViewDetachedFromWindow(View v);
        }
    }

    final class Behavior extends SwipeDismissBehavior<SnackbarLayout> {
        @Override
        public boolean canSwipeDismissView(View child) {
            return child instanceof SnackbarLayout;
        }

        @Override
        public boolean onInterceptTouchEvent(CoordinatorLayout parent, SnackbarLayout child,
                                             MotionEvent event) {


            if (parent.isPointInChildBounds(child, (int) event.getX(), (int) event.getY())) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        SnackbarManager.getInstance()
                                .cancelTimeout(mManagerCallback);
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        SnackbarManager.getInstance()
                                .restoreTimeout(mManagerCallback);
                        break;
                    default:
                        break;
                }
            }

            return super.onInterceptTouchEvent(parent, child, event);
        }
    }
}