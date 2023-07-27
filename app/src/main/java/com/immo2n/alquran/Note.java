package com.immo2n.alquran;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class Note extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_page);

        Toast.makeText(this, "Click menu button!", Toast.LENGTH_SHORT).show();

        LinearLayout bottomMenu = findViewById(R.id.bottomMenu);
        View maskView = findViewById(R.id.maskView);
        CoordinatorLayout coordinatorLayout = findViewById(R.id.coordinatorLayout);

        // Ensure that the LinearLayout is a direct child of the CoordinatorLayout
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) bottomMenu.getLayoutParams();
        params.setBehavior(new BottomSheetBehavior());

        // Set up BottomSheetBehavior for the bottom menu
        BottomSheetBehavior<LinearLayout> bottomSheetBehavior = BottomSheetBehavior.from(bottomMenu);
        bottomSheetBehavior.setPeekHeight(0); // Collapsed height, 0 means fully collapsed

        findViewById(R.id.menu_button).setOnClickListener(v -> {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            maskView.setVisibility(View.VISIBLE);
        });

        maskView.setOnClickListener(v -> bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED));

        // Set up touch listener for the bottom menu to enable dragging
        bottomMenu.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                // Handle the touch event when the user releases the touch
                // You can implement additional logic here if needed
            }
            return true;
        });

        // Set up BottomSheetCallback to show/hide the mask view when the state changes
        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED ||
                        newState == BottomSheetBehavior.STATE_HIDDEN) {
                    maskView.setVisibility(View.GONE);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                // Optional: Handle slide offset changes, if needed
            }
        });
    }
}