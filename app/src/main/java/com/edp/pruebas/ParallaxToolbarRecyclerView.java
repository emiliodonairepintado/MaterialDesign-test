package com.edp.pruebas;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.edp.pruebas.adapter.SimpleRecyclerAdapter;
import com.edp.pruebas.model.VersionModel;

import java.util.ArrayList;
import java.util.List;

public class ParallaxToolbarRecyclerView extends AppCompatActivity {
    CollapsingToolbarLayout collapsingToolbar;
    RecyclerView recyclerView;
    int mutedColor = R.attr.colorPrimary;
    SimpleRecyclerAdapter simpleRecyclerAdapter;
    private int mFabTranslationSize = 0;
    private boolean mFabIsVisible = true;
    FloatingActionButton botonFlotante;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.parallax_toolbar);
        botonFlotante = (FloatingActionButton)findViewById(R.id.fab);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.anim_toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("Parallax Toolbar");

        ImageView header = (ImageView) findViewById(R.id.header);

        /*Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.header);

        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @SuppressWarnings("ResourceType")
            @Override
            public void onGenerated(Palette palette) {

                mutedColor = palette.getMutedColor(R.color.primary_500);
                collapsingToolbar.setContentScrimColor(mutedColor);
                collapsingToolbar.setStatusBarScrimColor(R.color.black_trans80);
            }
        });*/

        recyclerView = (RecyclerView) findViewById(R.id.scrollableview);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        List<String> listData = new ArrayList<String>();
        for (int i = 0; i < VersionModel.data.length; i++) {
            listData.add(VersionModel.data[i]);
        }

        if (simpleRecyclerAdapter == null) {
            simpleRecyclerAdapter = new SimpleRecyclerAdapter(listData);
            recyclerView.setAdapter(simpleRecyclerAdapter);
        }

        botonFlotante.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Snackbar snackbar = Snackbar.make(v, "Click", Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void animateFab(boolean show) {
        if (show && !mFabIsVisible) {
            //Show
            mFabIsVisible = true;
            botonFlotante.animate().translationY(0);
        } else if (!show && mFabIsVisible) {
            //Hide
            mFabIsVisible = false;
            if (mFabTranslationSize == 0) {
                int margin = ((CoordinatorLayout.LayoutParams) botonFlotante.getLayoutParams()).bottomMargin;
                mFabTranslationSize = botonFlotante.getHeight() + margin * 2;
            }
            botonFlotante.animate().translationY(mFabTranslationSize);
        }
    }
}
