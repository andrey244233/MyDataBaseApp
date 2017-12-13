package com.example.home_pc.mydatabaseapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.home_pc.mydatabaseapp.data.CatsContract;
import com.example.home_pc.mydatabaseapp.data.DataBaseHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Button btn_delete = findViewById(R.id.btn_delete);
//        btn_delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                deleteAll();
//            }
//        });


        Button btn_show = findViewById(R.id.btn_show);
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAll();
            }
        });

    }

    private void deleteAll() {
        int deletedRows = getContentResolver().delete(CatsContract.CatsEntry.CONTENT_URI, null, null);
        Log.v("tag", "DELETED ROWS = " + deletedRows);
    }

    private void showAll() {
        Cursor cursor = getContentResolver().query(CatsContract.CatsEntry.CONTENT_URI, null, null, null, null);

        StringBuilder stringBuilder = new StringBuilder();
        while (cursor.moveToNext()) {

            int idIndex = cursor.getColumnIndex(CatsContract.CatsEntry._ID);
            int nameIndex = cursor.getColumnIndex(CatsContract.CatsEntry.COLUMN_NAME);
            int ageIndex = cursor.getColumnIndex(CatsContract.CatsEntry.COLUMN_AGE);

            int id = cursor.getInt(idIndex);
            String name = cursor.getString(nameIndex);
            String age = cursor.getString(ageIndex);

            stringBuilder.append("\n" + id + " - " +
                    name + " - " +
                    age + " - "
            );
        }
        Log.v("tag", "DATABASE = " + stringBuilder);

    }


}
