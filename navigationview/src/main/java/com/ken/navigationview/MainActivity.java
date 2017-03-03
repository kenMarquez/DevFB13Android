package com.ken.navigationview;

import android.support.annotation.BoolRes;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.ken.navigationview.fragments.PrimerFragment;
import com.ken.navigationview.fragments.SegundoFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.drawer)
    DrawerLayout drawerLayout;

    @BindView(R.id.navigation_view)
    NavigationView navigationView;

    private ActionBarDrawerToggle mDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        configureNavigationView();
    }

    private void configureNavigationView() {

        //Configuramos drawer toggle para manejar los estados de
        // expandido y no expandido
        mDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout,
                R.string.app_name, R.string.app_name);

        drawerLayout.addDrawerListener(mDrawerToggle);

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);
        navigate(R.id.nav_home);
    }

    private void navigate(int itemId) {
        switch (itemId) {
            case R.id.nav_home:
                changeFragment(new PrimerFragment());
                break;
            case R.id.nav_histortial:
                changeFragment(new SegundoFragment());
                break;
        }

    }

    private void changeFragment(Fragment fragmentInstance) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.root, fragmentInstance)
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        int itemId = item.getItemId();
        item.setChecked(true);
        navigate(itemId);

        return true;

    }
}
