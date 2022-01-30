package com.prathmeshadsod.thehindustanprime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.prathmeshadsod.thehindustanprime.Adapters.FragmentAdapter;
import com.prathmeshadsod.thehindustanprime.Menu.Profile;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(null);  // I done this becoz by default it was showing title in our custom toolbar

        tabLayout =  findViewById(R.id.tabLayout);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));


        tabLayout.setupWithViewPager(viewPager);

    }

                                                        /**    Menu   **/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu , menu);

        return true;
      //  return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.profile :
                Intent intent = new Intent(MainActivity.this , Profile.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}