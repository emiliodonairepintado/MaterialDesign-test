package com.edp.pruebas;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.edp.pruebas.fragments.FifthFragment;
import com.edp.pruebas.fragments.FirstFragment;
import com.edp.pruebas.fragments.FourthFragment;
import com.edp.pruebas.fragments.SecondFragment;
import com.edp.pruebas.fragments.ThirdFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

public class BottomBarMenu extends AppCompatActivity {

    private BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bb_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Carga el primer fragment por defecto
        final Bundle bundle = new Bundle();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contenidoBottomMenu, FirstFragment.newInstance(bundle))
                .commit();

        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.noTopOffset();
        mBottomBar.noTabletGoodness();
        mBottomBar.useFixedMode();

        mBottomBar.setItemsFromMenu(R.menu.bottombar_menu, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {

                if (menuItemId == R.id.one_menu_bb) {

                    final Bundle bundle = new Bundle();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.contenidoBottomMenu, FirstFragment.newInstance(bundle))
                            .commit();

                } else if (menuItemId == R.id.two_menu_bb) {

                    final Bundle bundle = new Bundle();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.contenidoBottomMenu, SecondFragment.newInstance(bundle))
                            .commit();

                } else if (menuItemId == R.id.three_menu_bb) {

                    final Bundle bundle = new Bundle();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.contenidoBottomMenu, ThirdFragment.newInstance(bundle))
                            .commit();

                } else if (menuItemId == R.id.four_menu_bb) {

                    final Bundle bundle = new Bundle();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.contenidoBottomMenu, FourthFragment.newInstance(bundle))
                            .commit();

                } else if (menuItemId == R.id.five_menu_bb) {

                    final Bundle bundle = new Bundle();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.contenidoBottomMenu, FifthFragment.newInstance(bundle))
                            .commit();

                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {

            }

        });

        // Setting colors for different tabs when there's more than three of them.
        // You can set colors for tabs in three different ways as shown below.
        mBottomBar.mapColorForTab(0, ContextCompat.getColor(this, R.color.colorAccent));
        mBottomBar.mapColorForTab(1, 0xFF5D4037);
        mBottomBar.mapColorForTab(2, "#7B1FA2");
        mBottomBar.mapColorForTab(3, "#FF5252");
        mBottomBar.mapColorForTab(4, "#FF9800");
    }

}
