package com.example.administrator.boe.view;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.administrator.boe.Fragment_layout.Fragment_1;
import com.example.administrator.boe.Fragment_layout.Fragment_2;
import com.example.administrator.boe.Fragment_layout.Fragment_3;
import com.example.administrator.boe.Fragment_layout.Fragment_4;
import com.example.administrator.boe.Fragment_layout.Fragment_5;
import com.example.administrator.boe.R;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.frame_layout);

        bottomBar = findViewById(R.id.bottom_bar);

//        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
//            @Override
//            public void onTabReSelected(int tabId) {
//
//            }
//        });
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {

            private Fragment_5 fragment_5;
            private Fragment_4 fragment_4;
            private Fragment_3 fragment_3;
            private Fragment_2 fragment_1;
            private Fragment_1 fragment_2;

            @Override
            public void onTabSelected(int tabId) {
                Object ob=null;
                switch (tabId){
                    case R.id.shouye:
                        ob = new Fragment_1();
                        break;
                    case R.id.fenlei:
                        ob = new Fragment_2();
                        break;
                    case R.id.faxian:
                        ob = new Fragment_3();
                        break;
                    case R.id.gouwu:
                        ob = new Fragment_4();
                        break;
                    case R.id.wode:
                        ob = new Fragment_5();
                        break;
                }getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,(Fragment) ob).commit();
            }
        });
    }
}
