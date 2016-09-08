package android.curso.appintentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SlaveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slave);

        if (getIntent().getExtras()!= null && getIntent().getExtras().containsKey(Intent.EXTRA_TEXT))
            Log.d("MESSAGE", getIntent().getExtras().getString(Intent.EXTRA_TEXT));

        // Need to be set before onDestroy
        //setResult(RESULT_OK);


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK);
            }
        });
    }



}
