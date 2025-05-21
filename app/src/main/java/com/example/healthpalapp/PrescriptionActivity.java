package com.example.healthpalapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthpalapp.Utilities.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class PrescriptionActivity extends BaseActivity {

    TextView prescriptionResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription);

        prescriptionResult = findViewById(R.id.prescriptionResult);

        ArrayList<String> selectedSymptoms = getIntent().getStringArrayListExtra("symptoms");
        HashMap<String, String> prescriptionMap = (HashMap<String, String>) getIntent().getSerializableExtra("prescriptionMap");

        StringBuilder result = new StringBuilder("💊 Suggested OTC remedies:\n\n");

        if (selectedSymptoms != null && prescriptionMap != null) {
            for (String symptom : selectedSymptoms) {
                String remedy = prescriptionMap.get(symptom);
                if (remedy != null && !remedy.isEmpty()) {
                    result.append("• ").append(symptom).append("\n→ ").append(remedy).append("\n\n");
                }
            }
        }

        result.append("💡 Health Tip: Stay hydrated, eat balanced meals, and sleep well.\n");
        result.append("⚠️ Note: It’s still best to consult a medical professional.");

        TextView prescriptionText = findViewById(R.id.prescriptionResult);
        prescriptionText.setText(result.toString());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(PrescriptionActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        finish(); // Ensure this activity is closed
    }



}
