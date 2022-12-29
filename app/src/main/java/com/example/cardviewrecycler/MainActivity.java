package com.example.cardviewrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cardviewrecycler.databinding.ActivityMainBinding;

import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




//titlebarcolorstart code
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.mycll));
        //title bar color code end







binding.nextpage.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity(new Intent(MainActivity.this,recyclerActivity.class));
    }
});


        binding.carousel.addData(new CarouselItem("https://tse2.mm.bing.net/th?id=OIP.ouMydkFyZW3oDwH2s_NtUwHaK5&pid=Api&P=0","Janat ky paty"));
        binding.carousel.addData(new CarouselItem("https://tse4.mm.bing.net/th?id=OIP.ceVvV3liIDWQ5BK-Jh08UQHaGA&pid=Api&P=0",""));
        binding.carousel.addData(new CarouselItem("https://tse4.mm.bing.net/th?id=OIP.n6dBj0KiSIwXSPL-PyZn_wHaHd&pid=Api&P=0",""));
        binding.carousel.addData(new CarouselItem("https://tse1.mm.bing.net/th?id=OIP.GFGC2Z5lEffmi9z9iOYTBQHaFb&pid=Api&P=00",""));





    }
}