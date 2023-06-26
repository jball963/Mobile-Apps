package com.example.mod10;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<TextView> listItems = new ArrayList<>();
    LinearLayout parentLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parentLayout = findViewById(R.id.main);
        setContentView(R.layout.activity_main);
        TextInputEditText textInput = findViewById(R.id.UserInput);
        TextView label = findViewById(R.id.textView);
        label.setText("no Items Added");
        Button button = findViewById(R.id.button);
        button.setText("Add Note");
        button.setOnClickListener(v -> {
            addItem(textInput.getText().toString());
            textInput.getText().clear();
        });
    }
    void addItem(String text){
        TextInputLayout hint = findViewById(R.id.UserInputLayout);
        TextView layout = findViewById(R.id.textView);
        if (text.equals("")){
            hint.setHint("You need to Type Something");
            return;
        }
        hint.setHint("");
        TextView newItem = new TextView(this);
        newItem.setText(text);
        listItems.add(newItem);
        parentLayout = findViewById(R.id.main);
        for (TextView tv : listItems){
            parentLayout.removeView(tv);
            parentLayout.addView(tv);
        }
        layout.setText(listItems.size() + " Items Added");
    }
}
