package sg.edu.rp.c346.id20028828.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    EditText editNum;
    EditText editPax;
    DatePicker datePicker;
    TimePicker timePicker;
    RadioGroup radioGroup;
    RadioButton radioSmoke;
    RadioButton radioNonSmoke;
    Button btnSubmit;
    Button btnReset;
    TextView textResult;
    String check;
    String stringDate;
    String stringTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editTextName);
        editNum = findViewById(R.id.editTextNumber);
        editPax = findViewById(R.id.editTextPax);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        radioGroup = findViewById(R.id.rgSmoke);
        radioSmoke = findViewById(R.id.radioButtonSmoke);
        radioNonSmoke = findViewById(R.id.radioButtonNonSmoke);
        btnReset = findViewById(R.id.buttonDisplayReset);
        btnSubmit = findViewById(R.id.buttonDisplayForm);
        textResult = findViewById(R.id.textViewDisplay);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editName.getText().toString().matches("") || editNum.getText().toString().matches("") || editPax.getText().toString().matches("") || radioGroup.getCheckedRadioButtonId() == -1) {
                    Toast a = Toast.makeText(getApplicationContext(), "Missing Information!", Toast.LENGTH_SHORT);
                    a.show();
                } else {
                    if (radioSmoke.isChecked() == true) {
                        check = "Smoking area";
                    } else {
                        check = "Non-Smoking area";
                    }
                    stringTime = timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute();
                    stringDate = datePicker.getDayOfMonth() + "/" + datePicker.getMonth() + "/" + datePicker.getYear();
                    Toast toast = Toast.makeText(getApplicationContext(), "Reservation: " + editName.getText().toString() + "\nMobile Number: " + editNum.getText().toString() + "\nSize of Group: " + editPax.getText().toString() + "\nSeating Position: " + check + "\nDate: " + stringDate + "\nTime: " + stringTime, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editName.setText("");
                editNum.setText("");
                editPax.setText("");
                radioSmoke.setChecked(false);
                radioNonSmoke.setChecked(false);
                datePicker.updateDate(2020,5,1);
                timePicker.setCurrentHour(19);
                timePicker.setCurrentMinute(30);
            }
        });
    }



    }
