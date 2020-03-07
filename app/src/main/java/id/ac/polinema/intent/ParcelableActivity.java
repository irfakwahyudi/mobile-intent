package id.ac.polinema.intent;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import id.ac.polinema.intent.model.User;

public class ParcelableActivity extends AppCompatActivity {

    public static final String USER_KEY = "user";

    private TextView usernameText, nameText, ageText;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable);

        usernameText = findViewById(R.id.input_username);
        nameText = findViewById(R.id.input_name);
        ageText = findViewById(R.id.input_age);
    }

    public void handleSubmit(View view) {
        String username = usernameText.getText().toString();
        String name = nameText.getText().toString();
        int age = Integer.parseInt(ageText.getText().toString());

        User user = new User(username, name, age);
        Intent intent = new Intent(this, ProfileParcelableActivity.class);
        intent.putExtra(USER_KEY, user);
        startActivity(intent);
    }
}
