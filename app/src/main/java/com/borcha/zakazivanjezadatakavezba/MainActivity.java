package com.borcha.zakazivanjezadatakavezba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void pokreniZadatak(View v){
        pokreniServis();
    }


    private void pokreniServis(){
        Intent intZadatak=new Intent(this,TestServis.class);
        startService(intZadatak);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


    @Override
    protected void onPause() {
        super.onPause();

    }
}
