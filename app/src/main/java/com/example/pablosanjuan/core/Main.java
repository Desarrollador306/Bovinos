package com.example.pablosanjuan.core;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;

import com.example.pablosanjuan.core.db.DbManager_inventario;

public class Main extends ActionBarActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    private NavigationDrawerFragment mNavigationDrawerFragment;
    private CharSequence mTitle;
    private SharedPreferences prefs;
    DbManager_inventario manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        manager = new DbManager_inventario(this);
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
        prefs = getSharedPreferences("datos",Context.MODE_PRIVATE);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {

        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new Fragment1();
                mTitle = getString(R.string.title_section1);
                break;
            case 1:
                mTitle = getString(R.string.title_section2);
                fragment = new Fragment2();
                break;
            case 2:
                fragment = new Fragment3();
                mTitle = getString(R.string.title_section3);
                break;
            case 3:
                fragment = new Fragment4();
                mTitle = getString(R.string.title_section4);
                break;
            case 4:
                fragment = new Fragment5();
                mTitle = getString(R.string.title_section5);
                break;
            case 5:
                fragment = new Fragment5();
                mTitle = getString(R.string.title_section6);
                break;
            case 6:
                fragment = new Fragment3();
                mTitle = getString(R.string.title_section7);
                break;
            case 7:
                fragment = new Fragment1();
                mTitle = getString(R.string.title_section8);
                break;
            case 8:
                SharedPreferences preferencias=getSharedPreferences("datos",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=preferencias.edit();
                editor.putBoolean("validar_sesion", false);
                editor.commit();
                finish();
                System.runFinalization();
                System.exit(0);
                Main.this.finish();
                break;
        }
        restoreActionBar();
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            getMenuInflater().inflate(R.menu.menu_main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }  */
}
