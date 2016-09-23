package android.curso.appfilestorageexample;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("getExternalStorageDirectory", Environment.getExternalStorageDirectory().getAbsolutePath().toString());
        Log.d("getDataDirectory", Environment.getDataDirectory().getAbsolutePath().toString());
        Log.d("getDownloadCacheDirectory", Environment.getDownloadCacheDirectory().getAbsolutePath().toString());
        Log.d("getExternalStoragePublicDirectory", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath().toString());
        Log.d("getExternalFilesDir", getExternalFilesDir(null).getAbsolutePath().toString());

        try {
            writeExternalStorage("Text to write");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeExternalStorage(String text) throws IOException {
        // Get the directory for the user's public pictures directory.
        File file = new File(getExternalFilesDir(null), "file.txt");
        file.createNewFile();
        OutputStream out = new FileOutputStream(file);
        out.write(text.getBytes());
        out.flush();
        out.close();
    }

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }
}
