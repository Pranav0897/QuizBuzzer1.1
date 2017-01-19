package in.ac.iitd.ees.eesquizbuzzer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import in.ac.iitd.ees.layout.LoginActivity;
import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    public final static String EXTRA_MESSAGE = "in.ac.iitd.ees.buzzer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_username);
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String name;
        boolean registered;
        registered=sharedPreferences.getBoolean("registered",false);
        name=sharedPreferences.getString("username","nulll");
        if(registered&&name!="null")
        {
                Intent intent = new Intent(this, Username.class);
                intent.putExtra(EXTRA_MESSAGE, name);
                startActivity(intent);
                finish();
        }
        else {
            username = (EditText) findViewById(R.id.editText);
            Button mRegisterButton = (Button) findViewById(R.id.button);
            mRegisterButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    attemptLogin();
                }
            });
        }
    }

    private LoginActivity.UserLoginTask mAuthTask = null;

    private void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        username.setError(null);

        // Store values at the time of the login attempt.
        String un = username.getText().toString().toLowerCase();
        boolean cancel = false;
        View focusView = null;


        // Check for a valid email address.
        if (TextUtils.isEmpty(un)) {
            username.setError(getString(R.string.error_field_required));
            focusView = username;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("registered",true);
            editor.putString("username",un);
            editor.commit();
            Intent intent = new Intent(this, Username.class);
            intent.putExtra(EXTRA_MESSAGE, un);
            startActivity(intent);
            finish();
        }
    }
}
