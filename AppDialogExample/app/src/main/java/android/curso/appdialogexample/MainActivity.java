package android.curso.appdialogexample;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickFragment(View view) {
        FireMissilesDialogFragment fragment = new FireMissilesDialogFragment();
        fragment.show(getSupportFragmentManager(), "FireMissilesDialogFragment");
    }

    public void clickPicker(View view) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(this, this, year, month, day);
        dialog.show();
    }

    public void clickAlert(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Message")
                .setTitle("Title");
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

    }
}
