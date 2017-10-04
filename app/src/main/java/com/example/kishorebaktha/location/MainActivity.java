package com.example.kishorebaktha.location;

import android.location.Address;
import android.location.Geocoder;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    Geocoder geocoder;
    List<Address> addresses;
    Button b;
    double Latitude=12.751291;
    double Longitude=80.195464;
   // Double Longitude, Latitude;
    private LocationManager locationManager;
    private LocationListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (TextView) findViewById(R.id.textView);
        geocoder = new Geocoder(this, Locale.getDefault());
        b = (Button) findViewById(R.id.button);
    }

    public void Locate2(View v) {
        try {
            addresses=geocoder.getFromLocation(Latitude,Longitude,1);
            String address=addresses.get(0).getAddressLine(0);
            String area=addresses.get(0).getLocality();
            String city=addresses.get(0).getAdminArea();
            String country=addresses.get(0).getCountryName();
            String postalcode=addresses.get(0).getPostalCode();
            String fullAddress=address+" ,"+area+" ,"+city+" ,"+country+" ,"+postalcode;
            t1.setText(fullAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
