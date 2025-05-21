package com.example.healthpalapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.example.healthpalapp.Utilities.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SelectionScreenActivity extends BaseActivity {

    EditText searchBar;
    ListView symptomListView;
    Button btnProceed;

    ArrayAdapter<String> adapter;
    ArrayList<String> allSymptoms;
    HashMap<String, String> prescriptionMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_screen);

        searchBar = findViewById(R.id.searchBar);
        symptomListView = findViewById(R.id.symptomListView);
        btnProceed = findViewById(R.id.btnProceed);


        String concernType = getIntent().getStringExtra("concernType");


        allSymptoms = new ArrayList<>();
        prescriptionMap = new HashMap<>();

        if ("physical".equalsIgnoreCase(concernType)) {
            populatePhysicalSymptoms();
        } else if ("mental".equalsIgnoreCase(concernType)) {
            populateMentalSymptoms();
        }

        adapter = new ArrayAdapter<>(this, R.layout.list_item_symptom, R.id.checkedTextView, allSymptoms);
        symptomListView.setAdapter(adapter);
        symptomListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);



        searchBar.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }
            @Override public void afterTextChanged(Editable s) { }
        });


        btnProceed.setOnClickListener(v -> {
            List<String> selectedSymptoms = new ArrayList<>();
            for (int i = 0; i < symptomListView.getCount(); i++) {
                if (symptomListView.isItemChecked(i)) {
                    selectedSymptoms.add(adapter.getItem(i));
                }
            }


            Intent intent = new Intent(SelectionScreenActivity.this, PrescriptionActivity.class);
            intent.putStringArrayListExtra("symptoms", new ArrayList<>(selectedSymptoms));
            intent.putExtra("prescriptionMap", prescriptionMap);
            startActivity(intent);
            finish();
        });
    }

    private void populatePhysicalSymptoms() {
        allSymptoms.add("Feeling less alert throughout the day.");
        allSymptoms.add("I often experience bad digestion.");
        allSymptoms.add("I think I have vitamin-deficiency.");
        allSymptoms.add("I am experiencing allergies during classes/in school.");
        allSymptoms.add("I feel that my energy is less when I'm doing some activity.");
        allSymptoms.add("I feel weak because of lack of sleep.");
        allSymptoms.add("I have unhealthy eating habits.");
        allSymptoms.add("I have hearing difficulties.");
        allSymptoms.add("I experience more physical symptoms like headaches or muscle tension.");
        allSymptoms.add("I rarely experience symptoms like dizziness and puking.");
        allSymptoms.add("My eyesight is becoming blurry when I look far away.");
        allSymptoms.add("I have a weakened immune system and frequently get sick.");
        allSymptoms.add("My face has acne or pimples.");
        allSymptoms.add("My skin feels dull and unhealthy.");
        allSymptoms.add("I feel I have low stamina (easily get tired).");
        allSymptoms.add("I cough often when I run, or do physical activity.");
        allSymptoms.add("Elevated blood pressure or heart issues.");
        allSymptoms.add("I have small appetite when I'm eating.");
        allSymptoms.add("I sweat a lot, especially during physical activities.");
        allSymptoms.add("I experience a great increase/decrease with my weight every week.");

        // Static symptom-to-drug mapping for physical symptoms
        prescriptionMap.put("Feeling less alert throughout the day.", "Vitamin B Complex");
        prescriptionMap.put("I often experience bad digestion.", "Antacids (e.g., Tums)");
        prescriptionMap.put("I think I have vitamin-deficiency.", "Multivitamins");
        prescriptionMap.put("I am experiencing allergies during classes/in school.", "Loratadine");
        prescriptionMap.put("I feel that my energy is less when I'm doing some activity.", "Iron Supplements");
        prescriptionMap.put("I feel weak because of lack of sleep.", "Melatonin");
        prescriptionMap.put("I have unhealthy eating habits.", "Probiotics");
        prescriptionMap.put("I have hearing difficulties.", "Consult a specialist");
        prescriptionMap.put("I experience more physical symptoms like headaches or muscle tension.", "Ibuprofen");
        prescriptionMap.put("I rarely experience symptoms like dizziness and puking.", "Meclizine");
        prescriptionMap.put("My eyesight is becoming blurry when I look far away.", "Consult an optometrist");
        prescriptionMap.put("I have a weakened immune system and frequently get sick.", "Vitamin C");
        prescriptionMap.put("My face has acne or pimples.", "Benzoyl Peroxide");
        prescriptionMap.put("My skin feels dull and unhealthy.", "Vitamin E Cream");
        prescriptionMap.put("I feel I have low stamina (easily get tired).", "Ginseng Supplements");
        prescriptionMap.put("I cough often when I run, or do physical activity.", "Salbutamol Inhaler");
        prescriptionMap.put("Elevated blood pressure or heart issues.", "Consult a cardiologist");
        prescriptionMap.put("I have small appetite when I'm eating.", "Appetite Stimulants");
        prescriptionMap.put("I sweat a lot, especially during physical activities.", "Antiperspirants");
        prescriptionMap.put("I experience a great increase/decrease with my weight every week.", "Consult a nutritionist");
    }

    private void populateMentalSymptoms() {
        allSymptoms.add("I often feel overwhelmed by stress.");
        allSymptoms.add("I experience frequent feelings of anxiety.");
        allSymptoms.add("Sudden and intense feelings of fear or dread.");
        allSymptoms.add("Relationship problems negatively impact my emotional well-being.");
        allSymptoms.add("Social anxiety prevents me from engaging in college.");
        allSymptoms.add("Exploring my identity, values, and goals is challenging.");
        allSymptoms.add("Negative thinking patterns affect me.");
        allSymptoms.add("Inadequate sleep impacts my mood and well-being.");
        allSymptoms.add("The stigma surrounding mental health prevents me from seeking help.");
        allSymptoms.add("I often feel lonely and isolated.");
        allSymptoms.add("I feel sad or down most of the time.");
        allSymptoms.add("I feel like I don't have enough control over my life.");
        allSymptoms.add("I feel like I'm not good enough.");
        allSymptoms.add("I feel like I'm always tired, even when I've slept.");
        allSymptoms.add("I have difficulty managing my emotions.");
        allSymptoms.add("I feel like I'm always on the go and never have time for myself.");
        allSymptoms.add("I have difficulty accepting compliments or praise.");
        allSymptoms.add("I have lost interest in activities I used to enjoy.");
        allSymptoms.add("I feel like I'm always comparing myself to others.");
        allSymptoms.add("I feel like I'm not good enough.");

        // Static symptom-to-drug mapping for mental symptoms
        prescriptionMap.put("I often feel overwhelmed by stress.", "Ashwagandha");
        prescriptionMap.put("I experience frequent feelings of anxiety.", "L-Theanine");
        prescriptionMap.put("Sudden and intense feelings of fear or dread.", "Valerian Root");
        prescriptionMap.put("Relationship problems negatively impact my emotional well-being.", "Omega-3 Supplements");
        prescriptionMap.put("Social anxiety prevents me from engaging in college.", "Magnesium");
        prescriptionMap.put("Exploring my identity, values, and goals is challenging.", "B Complex Vitamins");
        prescriptionMap.put("Negative thinking patterns affect me.", "St. John's Wort");
        prescriptionMap.put("Inadequate sleep impacts my mood and well-being.", "Melatonin");
        prescriptionMap.put("The stigma surrounding mental health prevents me from seeking help.", "Chamomile Tea");
        prescriptionMap.put("I often feel lonely and isolated.", "5-HTP");
        prescriptionMap.put("I feel sad or down most of the time.", "SAM-e");
        prescriptionMap.put("I feel like I don't have enough control over my life.", "Rhodiola Rosea");
        prescriptionMap.put("I feel like I'm not good enough.", "GABA Supplements");
        prescriptionMap.put("I feel like I'm always tired, even when I've slept.", "Coenzyme Q10");
        prescriptionMap.put("I have difficulty managing my emotions.", "Passionflower");
        prescriptionMap.put("I feel like I'm always on the go and never have time for myself.", "Lemon Balm");
        prescriptionMap.put("I have difficulty accepting compliments or praise.", "Vitamin D");
        prescriptionMap.put("I have lost interest in activities I used to enjoy.", "Saffron Extract");
        prescriptionMap.put("I feel like I'm always comparing myself to others.", "Turmeric Supplements");
        prescriptionMap.put("I feel like I'm not good enough.", "GABA Supplements");
    }
}
