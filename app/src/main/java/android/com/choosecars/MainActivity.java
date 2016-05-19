package android.com.choosecars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText userName, password;
    Button logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
    }


//  Go to user list of items when clicks on login button
    public void goToListItems(View view) {

        if (userName.getText().toString().isEmpty()){
            userName.setError("Please enter username");
            return;
        }
        if (password.getText().toString().isEmpty()){
            password.setError("Please enter password");
            return;
        }

        startActivity(new Intent(this,FlowerListActivity.class));
    }
}
