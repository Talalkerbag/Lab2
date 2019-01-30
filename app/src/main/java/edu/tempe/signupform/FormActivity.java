package edu.tempe.signupform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        final Button save_button = (Button) findViewById(R.id.save_button);
        final EditText name = (EditText) findViewById(R.id.name_field);
        final EditText email = (EditText) findViewById(R.id.email_field);
        final EditText password = (EditText) findViewById(R.id.password_field);
        final EditText confirmation = (EditText) findViewById(R.id.confirmation_field);

        save_button.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!isEmpty(name) && !isEmpty(email) && !isEmpty(password) && !isEmpty(confirmation)){
                    if(!isEqual(password,confirmation)){
                        Toast toast = Toast.makeText(getApplicationContext(), "Password and Confirmation Must Match", Toast.LENGTH_LONG);
                        toast.show();
                    }
                    else{
                        Toast toast = Toast.makeText(getApplicationContext(), "Welcome " + name.getText() + ", to the SignUpForm App", Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Please Fill in All of The Fields", Toast.LENGTH_LONG);
                    toast.show();
                }

            }
        });

    }
    private boolean isEmpty(EditText editText) {
        if (editText.getText().toString().trim().length() > 0) {
            return false;
        }
        return true;
    }

    private boolean isEqual(EditText one, EditText two){
        if(one.getText().toString().equals( two.getText().toString())){
            return true;
        }
        return false;
    }


}
