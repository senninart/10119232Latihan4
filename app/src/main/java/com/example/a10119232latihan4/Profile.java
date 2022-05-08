package com.example.a10119232latihan4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Locale;

public class Profile extends AppCompatActivity{

    BottomNavigationView bottomNavigationView;

    Button btnAbout,btnClose;
    TextView btnWa, btnMail, btnFb;
    ImageView location;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnAbout = findViewById(R.id.btnAbout);
        btnWa = findViewById(R.id.btnWa);
        btnMail = findViewById(R.id.btnMail);
        btnFb = findViewById(R.id.btnFb);
        location = findViewById(R.id.location);

        dialog = new Dialog(this);

        btnWa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://api.whatsapp.com/send?phone=+6287739662235";
                Intent intent = new Intent();
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        btnFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://facebook.com/faisalthewow"));
                startActivity(intent);
            }
        });

        btnMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                String email = "klsfaisalobara@gmail.com";
                intent.putExtra(Intent.EXTRA_EMAIL, email);
                intent.setType("text/html");
                intent.setPackage("com.google.android.gm");
                startActivity(intent);
            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = String.format(Locale.ENGLISH, "geo:%f, %f", -6.953838, 107.593435);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAboutDialog();
            }
        });

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.profile);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), Home.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.schedule:
                        startActivity(new Intent(getApplicationContext(), Daily.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.gallery:
                        startActivity(new Intent(getApplicationContext(), Gallery.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.favorite:
                        startActivity(new Intent(getApplicationContext(), Favorite.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    private void openAboutDialog() {
        dialog.setContentView(R.layout.about_layout_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageView imageViewClosed = dialog.findViewById(R.id.btnClose);

        imageViewClosed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Toast.makeText(Profile.this, "Dialog close", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();

    }
}