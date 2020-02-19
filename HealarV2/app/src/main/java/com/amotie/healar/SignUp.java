package com.amotie.healar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
    public void SignUp(View view){

    }
    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.MaleRadioButton:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.FemaleRadioButton:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }
}
