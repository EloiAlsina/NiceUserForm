package cat.itb.niceuserfrom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    Button login, register, forgotPassword;
    TextInputLayout password, username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login2_login);
        register = findViewById(R.id.register2_login);
        forgotPassword = findViewById(R.id.forgetPassword);
        username = findViewById(R.id.username_login);
        password = findViewById(R.id.password_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username.setError(null);
                password.setError(null);
                boolean allRight = true;
                if(username.getEditText().getText().toString().equals("")){
                    username.setError("Camp obligatori");
                    allRight = false;
                }

                if(!password.getEditText().getText().toString().equals("")){
                    if(password.getEditText().getText().length() < 7) {
                        password.setError("Contrasenya massa curta");
                        allRight = false;
                    }
                } else {
                    allRight = false;
                    password.setError("Camp obligatori");
                }

                if(allRight){
                    Intent i = new Intent(LoginActivity.this, WelcomeActivity.class);
                    startActivity(i);
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}