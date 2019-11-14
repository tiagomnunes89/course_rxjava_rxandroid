package br.com.courserxjavarxandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btRX00Intro;
    private Button btRX01Disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
    }

    private void setUpView() {
        btRX00Intro = findViewById(R.id.btRX00Intro);
        btRX01Disposable = findViewById(R.id.btRX01Disposable);
        btRX00Intro.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),Rx00IntroActivity.class)));
        btRX01Disposable.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),Rx01DisposableActivity.class)));
    }
}
