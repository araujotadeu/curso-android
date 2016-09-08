package android.curso.appintentexample;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("RESULT", String.valueOf(resultCode));
        Log.d("REQUEST", String.valueOf(requestCode));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickImplicit(View view) {
        /*Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "Message");
        intent.setType("text/plain");

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }*/


        String url = "http://www.google.com";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }

    public void clickResult(View view) {
        Intent intent = new Intent(this, SlaveActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, "Message");
        startActivityForResult(intent, 99);
    }

    public void clickExplicit(View view) {
        Intent intent = new Intent(this, SlaveActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, "Message");
        startActivity(intent);
    }
}
