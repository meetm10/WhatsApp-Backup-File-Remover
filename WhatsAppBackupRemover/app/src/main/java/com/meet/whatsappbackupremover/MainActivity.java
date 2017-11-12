package com.meet.whatsappbackupremover;

import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton btn = (FloatingActionButton)findViewById(R.id.delete);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File dir = new File(Environment.getExternalStorageDirectory()+"/WhatsApp/Databases");
                String[] children = dir.list();
                if(children.length>0) {
                    for (int i = 0; i < children.length; i++) {
                        new File(dir, children[i]).delete();
                    }
                    Toast.makeText(getApplication(), "Files Deleted Successfully!", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplication(), "No Backup Files Found!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
