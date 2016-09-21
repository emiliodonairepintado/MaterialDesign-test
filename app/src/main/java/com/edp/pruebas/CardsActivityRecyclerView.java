package com.edp.pruebas;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.edp.pruebas.adapter.AlbumsAdapter;
import com.edp.pruebas.model.Album;

import java.util.ArrayList;
import java.util.List;

public class CardsActivityRecyclerView extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AlbumsAdapter adapter;
    private List<Album> albumList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initCollapsingToolbar();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_album);

        albumList = new ArrayList<>();
        adapter = new AlbumsAdapter(this, albumList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();

        try {
            Glide.with(this).load(R.drawable.fondo).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */

    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_album);
        collapsingToolbar.setTitle("Cardview + recyclerview");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar_album);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle("Cardview + recyclerview");
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle("Cardview + recyclerview");
                    isShow = false;
                }
            }
        });
    }


    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    public void prepareAlbums() {

        final String android_image_urls[] = {
                "http://api.learn2crack.com/android/images/donut.png",
                "http://api.learn2crack.com/android/images/eclair.png",
                "http://api.learn2crack.com/android/images/froyo.png",
                "http://api.learn2crack.com/android/images/ginger.png",
                "http://api.learn2crack.com/android/images/honey.png",
                "http://api.learn2crack.com/android/images/icecream.png",
                "http://api.learn2crack.com/android/images/jellybean.png",
                "http://api.learn2crack.com/android/images/kitkat.png",
                "http://api.learn2crack.com/android/images/lollipop.png",
                "http://api.learn2crack.com/android/images/marshmallow.png",
                "http://www.adminspoint.com/attach/2013/Android%201.5,%20Cupcake.jpg",
                "http://images.clarin.com/next/gadgets/Nougat-operativo-Android-celulares-tablets_CLAIMA20160708_0132_28.jpg"
        };

        Album a = new Album("Cupcake", "1.5", android_image_urls[10]);
        albumList.add(a);

        a = new Album("Donut", "1.6", android_image_urls[0]);
        albumList.add(a);

        a = new Album("Eclair", "2.0", android_image_urls[1]);
        albumList.add(a);

        a = new Album("Froyo", "2.2", android_image_urls[2]);
        albumList.add(a);

        a = new Album("Gingerbread", "2.3", android_image_urls[3]);
        albumList.add(a);

        a = new Album("Honeycomb", "3.0", android_image_urls[4]);
        albumList.add(a);

        a = new Album("Icecream", "4.0", android_image_urls[5]);
        albumList.add(a);

        a = new Album("Jelly Bean", "4.1", android_image_urls[6]);
        albumList.add(a);

        a = new Album("Kitkat", "4.4", android_image_urls[7]);
        albumList.add(a);

        a = new Album("Lollipop", "5.0", android_image_urls[8]);
        albumList.add(a);

        a = new Album("Marshmallow", "6.0", android_image_urls[9]);
        albumList.add(a);

        a = new Album("Nougat", "7.0", android_image_urls[11]);
        albumList.add(a);

        adapter.notifyDataSetChanged();
    }


}
