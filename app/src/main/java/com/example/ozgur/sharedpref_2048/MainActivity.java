package com.example.ozgur.sharedpref_2048;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.textview_name)
    TextView name;
    @Bind(R.id.textview_age)
    TextView age;
    @Bind(R.id.textview_adress)
    TextView adress;
    @Bind(R.id.textview_zipcode)
    TextView zipcode;
    @Bind(R.id.textview_city)
    TextView city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);
        this.showDetailsUser();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, UpdateUserActivity.class));
            }
        });
    }

    private void showDetailsUser() {

        if (PreferencesHelper.isUserSaved(this)) {
            name.setText(Html.fromHtml("<b>Naam: </b>" + PreferencesHelper.getName(this)));
            age.setText(Html.fromHtml("<b>Leeftijd: </b>" + PreferencesHelper.getAge(this)));
            adress.setText(Html.fromHtml("<b>Adres: </b>" + PreferencesHelper.getAdress(this)));
            zipcode.setText(Html.fromHtml("<b>Postcode: </b>" + PreferencesHelper.getZipcode(this)));
            city.setText(Html.fromHtml("<b>Gemeente: </b>" + PreferencesHelper.getCity(this)));
        } else {
            name.setText("Nog geen gegevens ingevuld.");
        }
    }
}
