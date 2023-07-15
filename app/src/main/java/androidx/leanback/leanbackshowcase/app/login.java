package androidx.leanback.leanbackshowcase.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.leanback.leanbackshowcase.R;

import com.google.android.material.button.MaterialButton;

public class login extends AppCompatActivity{

    EditText username, password;
    Button tombol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        tombol = findViewById(R.id.loginbutton);


        MaterialButton loginbutton = (MaterialButton) findViewById(R.id.loginbutton);


        //admin and admin

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (username.getText().toString().equals("fajarsidiqalfaris") && password.getText().toString().equals("12345678")) {
                    //password benar
                    Toast.makeText(login.this, "BERHASIL MASUK", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(login.this, androidx.leanback.leanbackshowcase.app.MainActivity.class);
                    startActivity(intent);
                } else
                    //password salah
                    Toast.makeText(login.this, "Username atau Password salah !!!", Toast.LENGTH_SHORT).show();


            }
        });
    }

}