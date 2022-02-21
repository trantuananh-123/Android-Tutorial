package tran.tuananh.button;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.textView);
        btn = findViewById(R.id.button);

        changeContent(txt, btn);
    }

    @SuppressLint("SetTextI18n")
    private void changeContent(TextView txt, Button btn) {
        btn.setOnClickListener(view -> txt.setText("Hello android newbie!"));

    }
}