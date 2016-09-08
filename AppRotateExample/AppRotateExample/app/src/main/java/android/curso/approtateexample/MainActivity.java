package android.curso.approtateexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> systems;
    private static final String KEY_LIST_VALUE = "KEY_LIST_VALUE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Event", "onCreate");

        if (savedInstanceState != null) {
            systems = savedInstanceState.getStringArrayList(KEY_LIST_VALUE);
            Log.d("SavedState", "Restored");
        } else {
            systems = loadSystems();
            Log.d("SavedState", "Create");
        }

    }

    public void clickNew(View view) {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private List<String> loadSystems() {
        return new ArrayList<String>(Arrays.asList("Android", "Linux", "Windows", "iOS", "OSX", "Meego", "Bada", "FirefoxOS", "UbuntuTouch", "Maemo", "Tizen"));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("Event", "onSaveInstanceState");
        outState.putStringArrayList(KEY_LIST_VALUE, (ArrayList<String>) systems);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("Event", "onRestoreInstanceState");
        // O mesmo código do onCreate para restaurar o estado pode ser aplicado aqui
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Event", "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Event", "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Event", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Event", "onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Event", "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Event", "onPause");
    }
}

