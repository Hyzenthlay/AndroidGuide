package com.example.joel.androidguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by joel on 12/02/15.
 */
public class WebsiteActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.websites);

        final ListView lv = (ListView)findViewById(R.id.websiteslist);
        final String[] websiteNames = getResources().getStringArray(R.array.website_names);
        final String[] websitesLinks = getResources().getStringArray(R.array.website_links);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, websiteNames);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String[] websitesLinks = getResources().getStringArray(R.array.website_links);
                Uri address = Uri.parse(websitesLinks[position]);
                Intent redirect = new Intent(Intent.ACTION_VIEW, address);
                startActivity(redirect);
            }
        });






    }
}
