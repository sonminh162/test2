package com.lifetime.second_test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.lifetime.second_test.R;
import com.lifetime.second_test.fragment.EmptyFragment;
import com.lifetime.second_test.fragment.MessageFragment;
import com.lifetime.second_test.fragment.NewFeedFragment;
import com.lifetime.second_test.fragmentAdapter.FragmentAdapter;
import com.mikhaellopez.circularimageview.CircularImageView;

public class MainScreenActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private int[] navIcons = {
            R.drawable.ic_home,
            R.drawable.ic_comment,
            R.drawable.ic_add,
            R.drawable.ic_notify
    };

    private int[] navIconsActive = {
            R.drawable.ic_home_active,
            R.drawable.ic_comment_active,
            R.drawable.ic_add,
            R.drawable.ic_notify_active
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_main);

        createSpinner1();

        tabLayout = findViewById(R.id.footer);
        viewPager = findViewById(R.id.main);

        //
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        //Adding Fragment
        fragmentAdapter.addFragment(new NewFeedFragment());
        fragmentAdapter.addFragment(new MessageFragment());
        fragmentAdapter.addFragment(new EmptyFragment());
        fragmentAdapter.addFragment(new EmptyFragment());
        fragmentAdapter.addFragment(new EmptyFragment());
        //adapter Setup
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);

        customizationNavBar();

        getDataFromNewFeedFragment();

        tabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager) {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                super.onTabSelected(tab);
                View tabView = tab.getCustomView();
                if (tab.getPosition() == 2) {
                    return;
                } else if (tab.getPosition() == 4) {
                    return;
                } else {
                    ImageButton tab_icon = tabView.findViewById(R.id.nav_icon);
                    tab_icon.setImageResource(navIconsActive[tab.getPosition()]);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                super.onTabUnselected(tab);
                View tabView = tab.getCustomView();
                if (tab.getPosition() == 2) {
                    return;
                } else if (tab.getPosition() == 4) {
                    return;
                } else {
                    ImageView tab_icon = tabView.findViewById(R.id.nav_icon);
                    tab_icon.setImageResource(navIcons[tab.getPosition()]);
                }
            }
        });


    }
    private void createSpinner1() {
        Spinner spinner = findViewById(R.id.spinner_one);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.numbers,R.layout.spinner_one);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    private void getDataFromNewFeedFragment() {
        if(getIntent()!=null){
            Intent intent = getIntent();
            String message = intent.getStringExtra("message");
            if(message!=null){
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            }
            Bundle bundle = new Bundle();
            bundle.putString("message",message);
            MessageFragment messageFragment = new MessageFragment();
            messageFragment.setArguments(bundle);
        }
    }

    private void customizationNavBar() {
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            LinearLayout tab = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.nav_tab, null);

            ImageButton tab_icon = tab.findViewById(R.id.nav_icon);

            if (i == 0) {
                tab_icon.setImageResource(navIconsActive[i]);
            } else if (i == 2) {
                LinearLayout tab_center = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.nav_tab_center_icon, null);
                ImageView tab_icon_center = tab_center.findViewById(R.id.nav_icon_center);
                tab_icon_center.setImageResource(R.drawable.ic_add_vector);
                tabLayout.getTabAt(i).setCustomView(tab_center);
                continue;
            } else if (i == 4) {
                LinearLayout tab_last = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.nav_tab_last_icon, null);
                CircularImageView tab_icon_last = tab_last.findViewById(R.id.nav_icon_last);
                tab_icon_last.setImageResource(R.drawable.yo);
                tabLayout.getTabAt(i).setCustomView(tab_last);
                continue;
            } else {
                tab_icon.setImageResource(navIcons[i]);
            }
            tabLayout.getTabAt(i).setCustomView(tab);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
