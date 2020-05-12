package c.bwegener.bookstore;

import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LoginActivity extends AppCompatActivity {

    private TextView antiqueBookstore;
    private EditText userNameLogin;
    private EditText passwordLogin;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        antiqueBookstore = findViewById(R.id.antiqueBookstore);
        userNameLogin = findViewById(R.id.userNameLogInET);
        passwordLogin = findViewById(R.id.passwordLogInET);
        loginButton = findViewById(R.id.loginButton);

        RunAnimation();
    }


    public void Login(View v)
    {
        if(!isValidInput())
            return;

        Intent launchLogin = new Intent(LoginActivity.this, HomeScreenActivity.class);
        startActivity(launchLogin);
    }

    private boolean isValidInput() {
        boolean valid = true;
        if(TextUtils.isEmpty(userNameLogin.getText())) {
            userNameLogin.setError("Required.");
            valid = false;
        }
        if(TextUtils.isEmpty(passwordLogin.getText())) {
            passwordLogin.setError("Required.");
            valid = false;
        }
        return valid;
    }

    private void RunAnimation() {
        Animation a = AnimationUtils.loadAnimation(this, R.anim.anim);
        a.reset();
        antiqueBookstore.clearAnimation();
        antiqueBookstore.startAnimation(a);
        userNameLogin.clearAnimation();
        userNameLogin.startAnimation(a);
        passwordLogin.clearAnimation();
        passwordLogin.startAnimation(a);
        loginButton.clearAnimation();
        loginButton.startAnimation(a);
    }
}
