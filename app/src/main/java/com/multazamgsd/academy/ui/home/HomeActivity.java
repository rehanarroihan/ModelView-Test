package com.multazamgsd.academy.ui.home;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.multazamgsd.academy.R;
import com.multazamgsd.academy.ui.academy.AcademyFragment;
import com.multazamgsd.academy.ui.bookmark.BookmarkFragment;

public class HomeActivity extends AppCompatActivity implements ViewTreeObserver.OnScrollChangedListener {
    private final String TAG = HomeActivity.class.getSimpleName();

    private final String SELECTED_MENU = "selected_menu";
    private BottomNavigationView navView;
    private float viewScrolled;
    private NestedScrollView nsv;
    private Toolbar toolbar;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = item -> {
        Fragment fragment = null;
        if (item.getItemId() == R.id.action_home) {
            fragment = AcademyFragment.newInstance();
        } else if (item.getItemId() == R.id.action_bookmark) {
            fragment = BookmarkFragment.newInstance();
        }

        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.container, fragment)
                    .commit();
        }
        return true;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // Scroll view declaration and change listener
        viewScrolled = 0;
        nsv = findViewById(R.id.scrollView);
        nsv.getViewTreeObserver().addOnScrollChangedListener(this);

        if (savedInstanceState != null) {
            savedInstanceState.getInt(SELECTED_MENU);
        } else {
            navView.setSelectedItemId(R.id.action_home);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        // Handle scrolling toolbar
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("My Toolbar");
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(SELECTED_MENU, navView.getSelectedItemId());
    }

    @Override
    public void onScrollChanged() {
        if (viewScrolled < nsv.getScrollY()){
            viewScrolled = nsv.getScrollY();
            Log.d(TAG, "scrolling up");
        }
        if (viewScrolled > nsv.getScrollY()){
            viewScrolled = nsv.getScrollY();
            Log.d(TAG, "scrolling down");

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                getWindow().setStatusBarColor(Color.TRANSPARENT);

                toolbar.setBackgroundColor(Color.RED);
            }
        }
    }
}