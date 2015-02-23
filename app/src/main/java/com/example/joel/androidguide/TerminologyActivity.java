package com.example.joel.androidguide;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by joel on 08/02/15.
 */
public class TerminologyActivity extends MainActivity {
    private AutoCompleteTextView autocomp;
    private String[] terms;
    private String[] definitions1;
    private String[] definitions2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terminology);

        autocomp = (AutoCompleteTextView) findViewById(R.id.terminology_autocomp);
        terms = getResources().getStringArray(R.array.terms);
        definitions1 = getResources().getStringArray(R.array.definitions1);
        definitions2 = getResources().getStringArray(R.array.definitions2);

        // AutoComplete
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, terms);
        autocomp.setAdapter(adapter);
        autocomp.setThreshold(3);

        // Display definition
        autocomp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String termsId = (String) parent.getItemAtPosition(position);
                String toastText = new String();

                switch (termsId) {
                    case "Adb":
                        toastText = definitions1[0]; break;
                    case "Emulator":
                        toastText = definitions1[1]; break;
                    case "Android":
                        toastText = definitions1[2]; break;
                    case "Screenshot2":
                        toastText = definitions1[3]; break;
                    case "Gradle":
                        toastText = definitions1[4]; break;
                    case "pm command":
                        toastText = definitions1[5]; break;
                    case "Lint":
                        toastText = definitions1[6]; break;
                    case "src/main":
                        toastText = definitions1[7]; break;
                    case "build/outputs":
                        toastText = definitions1[8]; break;
                    case "res/layout":
                        toastText = definitions1[9]; break;
                    case "res/values":
                        toastText = definitions1[10]; break;

                    case "Project":
                        toastText = definitions2[0]; break;
                    case "Panel":
                        toastText = definitions2[1]; break;
                    case "Toolbar":
                        toastText = definitions2[2]; break;
                    case "Status Bar":
                        toastText = definitions2[3]; break;
                    case "Preview Pane":
                        toastText = definitions2[4]; break;
                    case "Android Pane":
                        toastText = definitions2[5]; break;
                    case "Project Explorer":
                        toastText = definitions2[6]; break;
                    case ".idea Folder":
                        toastText = definitions2[7]; break;
                    case "Intellisense":
                        toastText = definitions2[8]; break;
                    case "Android Module":
                        toastText = definitions2[9]; break;
                    case "Live Layout":
                        toastText = definitions2[10]; break;
                    default:
                        break;
                }

                Toast.makeText(getBaseContext(), termsId + " " + toastText, Toast.LENGTH_LONG).show();
            }
        });
    }
}
