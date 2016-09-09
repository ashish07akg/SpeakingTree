package com.example.ashish.speakingtree_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ashish.speakingtree_android.Utils.GlobalClass;
import com.squareup.picasso.Picasso;


public class HomeActivity extends AppCompatActivity  {

    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /**
         *Setup the DrawerLayout and NavigationView
         */
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.shitstuff);
        /**
         * Lets inflate the very first fragment
         * Here , we are inflating the TabFragment as the first Fragment
         */
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView, new TabFragment()
        ).commit();
        /**
         * Setup click events on the Navigation View Items.
         */

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();
                if (menuItem.getItemId() == R.id.nav_item_blogs) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new SentFragment()).commit();
                }
                if (menuItem.getItemId() == R.id.nav_item_forum) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();
                }

                if (menuItem.getItemId() == R.id.nav_item_master) {
                    Intent masterIntent = new Intent(getApplicationContext(), MasterActivity.class);
                    startActivity(masterIntent);
                }

                if (menuItem.getItemId() == R.id.nav_item_seeker) {
                    Intent masterIntent = new Intent(getApplicationContext(), mapactivity.class);
                    startActivity(masterIntent);
                }
                return false;
            }

        });

        /**
         * Setup Drawer Toggle of the Toolbar
         *
         *
         *
         */

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name,
                R.string.app_name);
        Button btnLogin = (Button) toolbar.findViewById(R.id.btnLogin);
        // Calling Application class (see application tag in AndroidManifest.xml)
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        if (globalVariable != null) {
            // Get name and email from global/application context
            if (globalVariable.getName() != null && !globalVariable.getName().isEmpty()) {
                final String name = globalVariable.getName();
                final String loginhash = globalVariable.getLoginhash();
                final  String imagethumb=globalVariable.getImagethumb();
                btnLogin.setVisibility(View.GONE);
                View hView =  mNavigationView.getHeaderView(0);
                TextView nav_user = (TextView)hView.findViewById(R.id.name);
                nav_user.setText(name);
                ImageView imguser=(ImageView)hView.findViewById(R.id.circleView);
                Picasso.with(getApplicationContext()).load(imagethumb).into(imguser);

            } else {
                btnLogin.setVisibility(View.VISIBLE);
            }
        }
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(v.getContext(), "Clicked!", Toast.LENGTH_LONG).show();

                Intent signupIntent = new Intent(HomeActivity.this, SignupActivity.class);
                startActivity(signupIntent);
            }
        });

        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

    }
}





