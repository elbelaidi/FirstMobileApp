package com.example.tp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner citySpinner = findViewById(R.id.citySpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.city_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(adapter);

        findViewById(R.id.Submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText lastNameEditText = findViewById(R.id.Lastname);
                EditText emailEditText = findViewById(R.id.Email);
                EditText phoneEditText = findViewById(R.id.Phone);

                String lastName = lastNameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String phone = phoneEditText.getText().toString();

                String city = citySpinner.getSelectedItem().toString();

                RadioGroup genreRadioGroup = findViewById(R.id.genreRadioGroup);
                int selectedGenderId = genreRadioGroup.getCheckedRadioButtonId();
                RadioButton selectedGenderButton = findViewById(selectedGenderId);
                String gender = selectedGenderButton.getText().toString();

                String message = "Last Name: " + lastName + "\n" +
                        "Email: " + email + "\n" +
                        "Phone: " + phone + "\n" +
                        "City: " + city + "\n" +
                        "Gender: " + gender;

                Intent intent = new Intent(MainActivity.this, RecapActivity.class);
                intent.putExtra("message", message);
                startActivity(intent);
            }
        });
    }
}
