package com.example.winestorm;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //actionbar
    private ActionBar actionBar;

    //UI Views
    private ViewPager viewPager;

    private ArrayList<MyModel> modelArrayList;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init actionbar
        actionBar = getSupportActionBar();

        //init UI views
        viewPager = findViewById(R.id.viewPager);
        loadCards();

        //set viewpager change listener
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //Cambio del titulo del action bar
                String title = modelArrayList.get(position).getTitle();
                actionBar.setTitle(title);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void loadCards() {
        //init list
        modelArrayList = new ArrayList<>();
        // add items to list
        modelArrayList.add(new MyModel(
                "Vino +UACH",
                "Cosecha del Viñedo de San Tepewachi, Aqui podemos agregar toda la descripcion que queramos del vino y su año de envase",
                "23/11/2022",
                R.drawable.wine1));
        modelArrayList.add(new MyModel(
                "Vino Andrezzio",
                "Cosecha del Viñedo de Menonia, Aqui podemos agregar toda la descripcion que queramos del vino.",
                "23/11/2021",
                R.drawable.wine2));
        modelArrayList.add(new MyModel(
                "Vino JefeSupremo",
                "Cosecha del Viñedo del piso 3, Aqui podemos agregar toda la descripcion que queramos del vino y su año de envase",
                "23/11/2020",
                R.drawable.wine3));
        modelArrayList.add(new MyModel(
                "Vino Bartolomeus",
                "Cosecha del Rio Cochino, Aqui podemos agregar toda la descripcion que queramos del vino y su año de envase",
                "23/11/2019",
                R.drawable.wine4));
        modelArrayList.add(new MyModel(
                "Vino Cesarinho",
                "Cosecha del viñedo de enfrente, Aqui podemos agregar toda la descripcion que queramos del vino y su año de envase",
                "23/11/2018",
                R.drawable.wine5));
        modelArrayList.add(new MyModel(
                "Vino Sorewa",
                "Cosecha del viñedo watashi-sorewa, Aqui podemos agregar toda la descripcion que queramos del vino y su año de envase",
                "23/11/2017",
                R.drawable.wine6));

        //setup adapter
        myAdapter = new MyAdapter(this, modelArrayList);
        //set adapter to view pager
        viewPager.setAdapter(myAdapter);
        //set default padding from left right
        viewPager.setPadding(100,0,100,0);

    }
}