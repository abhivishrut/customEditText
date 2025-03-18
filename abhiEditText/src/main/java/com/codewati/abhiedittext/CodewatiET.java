package com.codewati.abhiedittext;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.appcompat.widget.AppCompatEditText;

import java.util.regex.Pattern;

public class CodewatiET extends AppCompatEditText {
    private Drawable endIcon;
    private OnEndIconClickListener endIconClickListener;

    public CodewatiET(Context context) {
        super(context);
        init();
    }

    public CodewatiET(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CodewatiET(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setPadding(16, 16, 16, 16);
        setTextColor(Color.BLACK);
        setHintTextColor(Color.GRAY);
        setBackgroundResource(R.drawable.et_bg);
    }

    public void setMaxLength(int length) {
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(length)});
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (endIcon != null && event.getAction() == MotionEvent.ACTION_UP) {
            if (event.getX() >= (getWidth() - getPaddingRight() - (endIcon.getIntrinsicWidth()))) {
                if (endIconClickListener != null) {
                    endIconClickListener.onClick();
                }
                return true;
            }
        }
        return super.onTouchEvent(event);
    }

    public void enablePasswordToggle() {
        setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }

    public void setErrorShake() {
        this.animate().translationX(20f).setDuration(50).withEndAction(() ->
                this.animate().translationX(-20f).setDuration(50).withEndAction(() ->
                        this.animate().translationX(15f).setDuration(50).withEndAction(() ->
                                this.animate().translationX(-15f).setDuration(50).withEndAction(() ->
                                        this.animate().translationX(10f).setDuration(50).withEndAction(() ->
                                                this.animate().translationX(-10f).setDuration(50).withEndAction(() ->
                                                        this.animate().translationX(0f).setDuration(50)))))));
    }


    // Built-in Validation Methods
    public boolean isValidEmail() {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
        if (!pattern.matcher(getText().toString()).matches()) {
            setErrorShake();
            setError("Invalid Email Address");
            return false;
        }
        return true;
    }

    public boolean isValidPhone() {
        Pattern pattern = Pattern.compile("^[6-9]\\d{9}$"); // Matches 10-digit Indian mobile numbers
        if (!pattern.matcher(getText().toString()).matches()) {
            setErrorShake();
            setError("Invalid Phone Number");
            return false;
        }
        return true;
    }

    public boolean isValidPan() {
        Pattern pattern = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}"); // Matches Indian PAN Card format
        if (!pattern.matcher(getText().toString()).matches()) {
            setErrorShake();
            setError("Invalid PAN Card Number");
            return false;
        }
        return true;
    }

    public boolean isValidAadhaar() {
        Pattern pattern = Pattern.compile("\\d{12}"); // Matches 12-digit Aadhaar number
        if (!pattern.matcher(getText().toString()).matches()) {
            setErrorShake();
            setError("Invalid Aadhaar Number");
            return false;
        }
        return true;
    }

    public interface OnEndIconClickListener {
        void onClick();
    }
}
