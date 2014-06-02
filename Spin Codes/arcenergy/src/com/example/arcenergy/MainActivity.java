package com.example.arcenergy;

import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import java.text.DecimalFormat;

public class MainActivity extends Activity {

	public final static String EXTRA_MESSAGE = "com.example.beamenergy.MESSAGE";
	public final static double a = 0.00115965;
	public final static double me = 0.51099891;
	public final static double constant = 1/(a/me);
	public static String messages = "\t\t\t\tPRECESSIONS FOR PASSES\n"; //FOR HALLS A, B, C
	
	public static DecimalFormat df = new DecimalFormat("#####.####");
	
	public static double[] hallA_PassPrecession = new double[5];
	public static double[] hallB_PassPrecession = new double[5];
	public static double[] hallC_PassPrecession = new double[5];
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/*public double[] totalSpinPrecession()
	{
		double[] precession = new double[11]; //initial time = wien! cell for each time it precesses.

		
		EditText editText = (EditText) findViewById(R.id.edit_message);
		EditText editText2 = (EditText) findViewById(R.id.edit_message2);
		
		double total_precession = Double.parseDouble(editText.getText().toString());
		double wien = Double.parseDouble(editText2.getText().toString());
		
		/*double energy = I;
		precession[0] = w;
		
		//System.out.println(message);
		//if(i == 1) //HALL A
		//{
			for(int n = 1; n < precession.length; n++)
			{
				if(n%2 == 0) //when n is even aka the 2nd, 4th, etc time the beam precesses
				{
					energy += S;
					precession[n] = precession[n-1] + (a)*(energy/me)*(180);
				}
				else //when n is odd aka the 1st, 3rd, etc time the beam precesses
				{
					energy += N;
					precession[n] = precession[n-1] + (a)*(energy/me)*(180);
				}
			}
			
			energy += S; //for last bend into hall
			
			
				hallA_PassPrecession[0] = precession[1] + (a)*((I+N+S)/me)*(37); // to hall a FIRST PASS
				hallA_PassPrecession[1] = precession[3] + (a)*((I+2*(N+S))/me)*(37); // to hall a SECOND PASS
				hallA_PassPrecession[2] = precession[5] + (a)*((I+3*(N+S))/me)*(37); // to hall a THIRD PASS
				hallA_PassPrecession[3] = precession[7] + (a)*((I+4*(N+S))/me)*(37); // to hall a FOURTH PASS
				//hallA_PassPrecession[4] = precession[9] + (a)*(energy/me)*(37); // to hall a FIFTH PASS
			
				hallB_PassPrecession[0] = precession[1]; // to hall b FIRST PASS
				hallB_PassPrecession[1] = precession[3]; // to hall b SECOND PASS
				hallB_PassPrecession[2] = precession[5]; // to hall b THIRD PASS
				hallB_PassPrecession[3] = precession[7]; // to hall b FOURTH PASS
				//hallB_PassPrecession[4] = precession[9]; // to hall b FIFTH PASS
				hallA_PassPrecession[4] = precession[9]+ (a)*((I+5*(N+S))/me)*(37); //TO TEST
				hallB_PassPrecession[4] = precession[9]; //TO TEST
				hallC_PassPrecession[4] = precession[9] + (a)*((I+5*(N+S))/me)*(-37); //TO TEST, REAL IN COMMENT. STILL NOT WORKING EVEN THOUGH [3] WORKS. 
			
				hallC_PassPrecession[0] = precession[1] + (a)*(I+N+S/me)*(-37); // to hall c FIRST PASS
				hallC_PassPrecession[1] = precession[3] + (a)*((I+2*(N+S))/me)*(-37); // to hall c SECOND PASS
				hallC_PassPrecession[2] = precession[5] + (a)*((I+3*(N+S))/me)*(-37); // to hall c THIRD PASS
				hallC_PassPrecession[3] = precession[7] + (a)*((I+4*(N+S))/me)*(-37); // to hall c FOURTH PASS
				//hallC_PassPrecession[4] = precession[9] + (a)*(energy/me)*(-37); // to hall c FIFTH PASS
			    for(int i = 0; i < 5; i++)
			    {
			    	messages += "\nHall A, Pass "+(i+1)+"\t"+df.format(Math.pow(Math.cos(hallA_PassPrecession[i]+(a)),2))+"\nHall B, Pass "+(i+1)+"\t"+df.format(Math.pow(Math.cos(hallB_PassPrecession[i]),2))+"\nHall C, Pass "+(i+1)+"\t"+df.format(Math.pow(Math.cos(hallC_PassPrecession[i]),2))+"\n";
			    }
		//}
		/*if(i == 2) //HALL B
		{
			precession[0] = w + (a)*((I+N)/me)*(180);
			for(int n = 1; n < 5; n++)
			{
				precession[n] = precession[0] + (n*2)*(a)*((I+N)/me)*(180);
			}
		}
		if(i == 3) //HALL C
		{
			precession[0] = w+(a)*(((I+N)/me)*(180)+((I+N+S)/me)*(-37));
			for(int n = 1; n < 5; n++)
			{
				precession[n] = precession[0] + (n*2)*(a)*((I+N)/me)*(180);
			}
		}*/
		
		//return precession;
	//}
	
	public void sendMessage(View view) //Button to show each precession.
	{
		Intent intent = new Intent(this, DisplayMessageActivity.class); 
		String energies = "";
		
		EditText editText = (EditText) findViewById(R.id.edit_message);
		EditText editText2 = (EditText) findViewById(R.id.edit_message2);
		
		double BdL = Double.parseDouble(editText.getText().toString());
		double beamAngle = Double.parseDouble(editText2.getText().toString());
		double k = 0.299792;
		double energy = 0;
		double syncConstant = 0.0885;
		double r = 300.4;
		
		for(int i = 0; i < 8; i++)
		{
			energy =  k*(BdL/beamAngle);
			energy -= syncConstant*(Math.pow(energy,4)/r);
		}
		
		energies += "Beam energy:\n"+df.format(energy);
		intent.putExtra(EXTRA_MESSAGE, energies); 
		
		startActivity(intent);
		//response
	}
	
	

}
