package tran.tuananh.random_number;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtNumber;
    Button buttonRandom;
    EditText editText1, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();

        buttonRandom.setOnClickListener(v -> {
            String text1 = editText1.getText().toString().trim();
            String text2 = editText2.getText().toString().trim();
            if (validate1(text1, text2)) {
                int firstNumber = Integer.parseInt(text1);
                int secondNumber = Integer.parseInt(text2);
                Random random = new Random();
                if (validate2(firstNumber, secondNumber)) {
                    int number = random.nextInt(secondNumber - firstNumber + 1) + firstNumber;
                    txtNumber.setText(String.valueOf(number));
                }
            }
        });
    }

    private void findView() {
        txtNumber = findViewById(R.id.textViewNumber);
        buttonRandom = findViewById(R.id.buttonRandom);
        editText1 = findViewById(R.id.editTextNumberOne);
        editText2 = findViewById(R.id.editTextNumberTwo);
    }

    private boolean validate1(String text1, String text2) {
        if (text1 == null || text1.isEmpty()) {
            Toast.makeText(this, "First number is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (text2 == null || text2.isEmpty()) {
            Toast.makeText(this, "Second number is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean validate2(int num1, int num2) {
        if (num1 > num2) {
            Toast.makeText(this, "First number must smaller than second number", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}