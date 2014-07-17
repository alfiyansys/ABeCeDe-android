package com.yammy.abecede;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	Button buttonhuruf[];
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonhuruf = new Button[26];
        buttonhuruf[0] = (Button) this.findViewById(R.id.button1);
        buttonhuruf[1] = (Button) this.findViewById(R.id.button2);
        buttonhuruf[2] = (Button) this.findViewById(R.id.button3);
        buttonhuruf[3] = (Button) this.findViewById(R.id.button4);
        buttonhuruf[4] = (Button) this.findViewById(R.id.button5);
        buttonhuruf[5] = (Button) this.findViewById(R.id.button6);
        buttonhuruf[6] = (Button) this.findViewById(R.id.button7);
        buttonhuruf[7] = (Button) this.findViewById(R.id.button8);
        buttonhuruf[8] = (Button) this.findViewById(R.id.button9);
        buttonhuruf[9] = (Button) this.findViewById(R.id.button10);
        buttonhuruf[10] = (Button) this.findViewById(R.id.button11);
        buttonhuruf[11] = (Button) this.findViewById(R.id.button12);
        buttonhuruf[12] = (Button) this.findViewById(R.id.button13);
        buttonhuruf[13] = (Button) this.findViewById(R.id.button14);
        buttonhuruf[14] = (Button) this.findViewById(R.id.button15);
        buttonhuruf[15] = (Button) this.findViewById(R.id.button16);
        buttonhuruf[16] = (Button) this.findViewById(R.id.button17);
        buttonhuruf[17] = (Button) this.findViewById(R.id.button18);
        buttonhuruf[18] = (Button) this.findViewById(R.id.button19);
        buttonhuruf[19] = (Button) this.findViewById(R.id.button20);
        buttonhuruf[20] = (Button) this.findViewById(R.id.button21);
        buttonhuruf[21] = (Button) this.findViewById(R.id.button22);
        buttonhuruf[22] = (Button) this.findViewById(R.id.button23);
        buttonhuruf[23] = (Button) this.findViewById(R.id.button24);
        buttonhuruf[24] = (Button) this.findViewById(R.id.button25);
        buttonhuruf[25] = (Button) this.findViewById(R.id.button26);
        
        for(int i=0;i<buttonhuruf.length;i++){
        	final int n = i;
        	buttonhuruf[i].setOnClickListener(new View.OnClickListener() {	
				@Override
				public void onClick(View v) {					
					Intent intent = new Intent(MainActivity.this,Huruf.class);
					intent.putExtra("huruf", n);
					startActivity(intent);
				}
			});
        }
    }
}
