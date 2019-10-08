package org.elimu.androidtest.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import org.elimu.androidtest.R;
import org.elimu.androidtest.utils.Constants;

public class MainActivity extends AppCompatActivity {


    private TextInputEditText mUsename;
    private Button mSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSearch = findViewById(R.id.searchUser);
        mUsename = findViewById(R.id.etUserName);

        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = mUsename.getText().toString().trim();
                Log.e("USE", username);
                if (username.isEmpty()) {
                    mUsename.setError("Username cannot be empty");
                } else {
                    Intent intent = new Intent(getBaseContext(), RepoListActivity.class);
                    intent.putExtra("Username", username);
                    startActivity(intent);
                }
            }
        });

    }
}
