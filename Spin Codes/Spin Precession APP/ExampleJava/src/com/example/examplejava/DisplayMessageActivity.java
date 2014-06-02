package com.example.examplejava;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
@SuppressLint("NewApi")
public class DisplayMessageActivity extends Activity {

	
	@SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        
        // Make sure we're running on Honeycomb or higher to use ActionBar APIs
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // Show the Up button in the action bar.
            getActionBar().setDisplayHomeAsUpEnabled(true);
            
        }
        Intent intent = getIntent();
        //Intent intent2 = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        //String message2 = intent2.getStringExtra(MainActivity.EXTRA_MESSAGE2);
        	//try{
        		//message = ""+(Double.parseDouble(message));
        		
        	//}
        	//catch(Exception e){
        		//message = "Error! Not a number!";
        	//}
        	//try{
        		//if(message2 == null)
        			//message2 = "2";
        		//message2 = ""+(Integer.parseInt(message2));
        		//if(!(message.equals("Error! MESSAGE 1 not a number!")))
        			//message2 = ""+message+" + "+message2+" = "+(Integer.parseInt(message)+Integer.parseInt(message2));
        	//}
        	//catch(Exception e){
        		//message2 = "Error! MESSAGE 2 not a number!";
        		//message = "";
        	//}
     // Create the text view
        TextView textView = new TextView(this);
        textView.setTextSize(16);
        textView.setText("Calculation for: \n"+message);
     

        // Set the text view as the activity layout
        setContentView(textView);
    }

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB-1) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_message, menu);
		return true;
	}

	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
