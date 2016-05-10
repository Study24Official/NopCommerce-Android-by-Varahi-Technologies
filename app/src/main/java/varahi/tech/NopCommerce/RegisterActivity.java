package varahi.tech.NopCommerce;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RegisterActivity extends AppCompatActivity {

    EditText editText_emailAddress_register, editText_password_register;
    EditText editText_DOB_Register;
    Calendar newCalendar;
    SimpleDateFormat dateFormatter;
    DatePickerDialog fromDatePickerDialog;
    Button button_Register;
    ImageView datePickerImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Bundle extras = getIntent().getExtras();
        String email = extras.getString("email");
        String password = extras.getString("password");

        editText_emailAddress_register = (EditText) findViewById(R.id.editText_emailAddress_register);
        assert editText_emailAddress_register != null;
        editText_emailAddress_register.setText(email);

        editText_password_register = (EditText) findViewById(R.id.editText_password_register);
        assert editText_password_register != null;
        editText_password_register.setText(password);

        button_Register = (Button) findViewById(R.id.button_Register);

        button_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        editText_DOB_Register = (EditText) findViewById(R.id.editText_DOB_Register);
        datePickerImage = (ImageView) findViewById(R.id.datePickerImage);
        //editTextDOB.setText(dateFormatter.format(new Date().getTime()));
        assert editText_DOB_Register != null;
        editText_DOB_Register.setText("DD.MM.YYYY");

        dateFormatter = new SimpleDateFormat("dd.MM.yyyy", Locale.US);
        newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(RegisterActivity.this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                String nDate = dateFormatter.format(newDate.getTime());

                editText_DOB_Register.setText(nDate);
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        fromDatePickerDialog.getDatePicker().setMaxDate(newCalendar.getTimeInMillis());

        datePickerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromDatePickerDialog.show();
            }
        });
    }
}