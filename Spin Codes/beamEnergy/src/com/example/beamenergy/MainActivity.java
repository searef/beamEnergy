package com.example.beamenergy;

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
		Intent intent = new Intent(this, DisplayMessageActivity.class); //For 2 passes into hall B
		String energies = "";
		boolean flag = true;
		
		EditText editText = (EditText) findViewById(R.id.edit_message);
		EditText editText2 = (EditText) findViewById(R.id.edit_message2);
		EditText editText3 = (EditText) findViewById(R.id.edit_message3);
		EditText editText4 = (EditText) findViewById(R.id.edit_message4);
		EditText editText5 = (EditText) findViewById(R.id.edit_message5);
		
		double injector_energy = Double.parseDouble(editText3.getText().toString());
		double imbalence = Double.parseDouble(editText.getText().toString());
		double wien = Double.parseDouble(editText2.getText().toString()); //max polarization wien angle
		double guess = Double.parseDouble(editText4.getText().toString());
		double e_l = 0;
		double n = Double.parseDouble(editText5.getText().toString());
		double energy = 0;
		double energyA = 0;
		double energyB = 0;
		double energyC = 0;
		double angle = 37.5;
		double syncConstant = 0.0885;
		double syncRadiation = 0.0;
		double tempEnergy = 0.0;
		
		double last = 0;
		 
		//for(int b = 0; b < 3; b++) //Need a guess for every one? DON'T FORGET TO CHANGE ANGLE
		//{
			//for(int n = 1; n < 6; n++)
			//{
		for(int k = 0; k < 3; k++)
		{
				for(int i = 0; flag; i += 180)
				{
					e_l = ((me/a)*(i - wien) - injector_energy*(n*180 + (n-1)*180 + angle) - imbalence*(((n*(n-1))/2)*(180+180) + n*angle))/(Math.pow(n, 2)*180 + (Math.pow(n, 2) - n)*180 + 2*n*angle);
					if(guess - (injector_energy + n*(2*e_l+imbalence)) <= 0)
					{
						if(Math.abs(guess - (injector_energy + n*(2*e_l+imbalence))) < last)
							energy = injector_energy + n*(2*e_l+imbalence);
						else
							energy = Math.abs(last - guess);
						flag = false;
					}
					else
						last = guess - injector_energy + n*(2*e_l+imbalence);
				}
				if(k==0)
				{
					energyA = energy;
					angle = 0;
				}
				if(k==1)
				{
					energyB = energy;
					angle = -37.5;
				}
				if(k==2)
					energyC = energy;
				energy = 0;
				e_l = 0;
				last = 0;
				flag = true;
				
		}
				/*if((guess - injector_energy + n*(2*e_l+imbalence)) < (guess - injector_energy + n*(2*e_l2+imbalence)))
					energy = injector_energy + n*(2*e_l+imbalence);
					else
						energy = injector_energy + n*(2*e_l2+imbalence);*/
				
				/*if(n == 1)
				{
					if(b == 0)
						energies += "Hall A\nPass 1:"+df.format(energy)+"\n";
					if(b == 1)
						energies += "Hall B\nPass 1:"+df.format(energy)+"\n";
					if(b == 2)
						energies += "Hall C\nPass 1:"+df.format(energy)+"\n";
				}
				else
					energies += "Pass "+n+": "+df.format(energy)+"\n";
				
				//guess = 0;
				e_l = 0;
			}
		}*/
		//length of magnet 300.07 cm , bends beam by 4.2875 degrees (8 magnets) 
		for(int v = 0; v < n*2; v++)
		{
			tempEnergy += e_l;
			syncRadiation = 0;
		}
		
		syncRadiation = 0;
		energies += "Pass "+n+": \nHall A:"+df.format(energyA)+"\nHall B:"+df.format(energyB)+"\nHall C:"+df.format(energyC);
		intent.putExtra(EXTRA_MESSAGE, energies); 
		
		startActivity(intent);
		//response
	}
	
	

}
