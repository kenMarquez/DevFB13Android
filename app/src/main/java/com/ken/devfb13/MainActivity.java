package com.ken.devfb13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ekalips.fancybuttonproj.FancyButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Charizard charizard = new Charizard("chari", "fuego/volador");
        Pikachu pikachu = new Pikachu("pikachu", "electrico");

//        ataquePokemon(charizard);
        ataquePokemon(pikachu);


        FancyButton button1 = (FancyButton) findViewById(R.id.btn1);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view instanceof  FancyButton)
                {
                    if (((FancyButton)view).isExpanded())
                        ((FancyButton)view).collapse();
                    else
                        ((FancyButton)view).expand();
                }

            }
        };
        button1.setOnClickListener(listener);

    }


    public void ataquePokemon(Pokemon pokemon) {

        if (pokemon instanceof Pikachu) {
            Pikachu pikachu = (Pikachu) pokemon;
            pikachu.impactrueno();
        } else if (pokemon instanceof Charizard) {
            Charizard charizard = (Charizard) pokemon;
            charizard.vuela();
        }
    }



}
