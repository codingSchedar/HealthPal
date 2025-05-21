package com.example.healthpalapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.healthpalapp.Utilities.BaseActivity;

public class MainActivity extends BaseActivity {

    private TextView txtAboutUs;
    private Button btnPhysical, btnMental;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_main);

        txtAboutUs = findViewById(R.id.about_us);

        btnPhysical = findViewById(R.id.physical_button);
        btnMental = findViewById(R.id.mental_button);

        txtAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AboutUsActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        btnPhysical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SelectionScreenActivity.class);
                intent.putExtra("concernType", "physical");
                MainActivity.this.startActivity(intent);
            }
        });

        btnMental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SelectionScreenActivity.class);
                intent.putExtra("concernType", "mental");
                MainActivity.this.startActivity(intent);
            }
        });




    }
}