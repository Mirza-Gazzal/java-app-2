package com.example.java_testing_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String[]> appsList = new ArrayList<String[]>();
        ArrayList<Drawable> appsListImages = new ArrayList<Drawable>();

        List<ApplicationInfo> apps = getPackageManager().getInstalledApplications(0);
        String appName = "";
        Drawable image;
        for(ApplicationInfo app : apps) {
            image = this.getPackageManager().getDrawable(app.packageName, app.icon, app);
            appName = this.getPackageManager().getApplicationLabel(app).toString();
            // image = this.getPackageManager().getApplicationIcon(app);

            if ((app.flags & (ApplicationInfo.FLAG_UPDATED_SYSTEM_APP | ApplicationInfo.FLAG_SYSTEM)) > 0) {
                // It is a system app
            } else {
                // It is installed by the user

            }

            appsList.add(new String[] {"Our Custom Data here :", appName});
            appsListImages.add(image);
            // Log.i("App manager", "App Name: " + appName);
        }


        /*ArrayList to Array Conversion */
        String[] array[] = new String[appsList.size()][];
        for(int j =0;j<appsList.size();j++){
            array[j] = appsList.get(j);
        }

        ListView listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(new CustomListView(this, array, appsListImages));
    }
}