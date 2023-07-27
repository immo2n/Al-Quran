package com.immo2n.alquran;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class Example_bottom_menu extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_bottom_menu);

        LinearLayout bottomMenu = findViewById(R.id.bottomMenu);
        // Ensure that the LinearLayout is a direct child of the CoordinatorLayout
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) bottomMenu.getLayoutParams();
        params.setBehavior(new BottomSheetBehavior());

        // Set up BottomSheetBehavior for the bottom menu
        BottomSheetBehavior<LinearLayout> bottomSheetBehavior = BottomSheetBehavior.from(bottomMenu);
        bottomSheetBehavior.setPeekHeight(0); // Collapsed height, 0 means fully collapsed

        findViewById(R.id.open_menu).setOnClickListener(v -> bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED));

        // Set up touch listener for the bottom menu to enable dragging
        bottomMenu.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                // Handle the touch event when the user releases the touch
                // You can implement additional logic here if needed
            }
            return true;
        });
    }
}