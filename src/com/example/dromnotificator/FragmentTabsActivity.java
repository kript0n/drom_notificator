package com.example.dromnotificator;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;

public class FragmentTabsActivity extends FragmentActivity {
	
	private FragmentTabHost tabHost;
	
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.fragment_activity);
        
		if(android.os.Build.VERSION.SDK_INT > 0) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
        
        tabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        tabHost.addTab(tabHost.newTabSpec("ReviewFragment").setIndicator("בחמנ"), ReviewFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("SearchPointFragment").setIndicator("SearchPoints"), SearchPointsFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("MyDromFragment").setIndicator("מי Drom"), MyDromFragment.class, null);
        tabHost.setCurrentTabByTag("ReviewFragment");
    }
}
