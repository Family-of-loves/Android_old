package com.example.wearetherunningman;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	Player player;
	WsCallbackInterface callback;
	WsConn ws = new WsConn(callback);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button sendbutton=(Button)findViewById(R.id.button01);	
		Button ackbutton=(Button)findViewById(R.id.button02);

		ws.run("http://dev.hagi4u.net:3000");

		sendbutton.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v) {  // ��ư Ŭ����
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "����� ����!",  Toast.LENGTH_SHORT).show();
				player = new Player("0","������","1","0",getApplicationContext());
			}
		});

		ackbutton.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v){
				ws.emitJoin("hagi4u", player.name);
				sendServer();
			}
		});
	}
	public void sendServer(){
		new Thread(new Runnable() {           
			public void run() {
				while (true) {
					try {
						Location location = null;
						player.gc.onLocationChanged(location);
						ws.emitMessage(player);
						Thread.sleep(10000);                       
                    } catch (InterruptedException e) {
                    	e.printStackTrace();
                    }
                }
            }
        }).start();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	/**
	 * A placeholder fragment containing a simple view.
	 */
	@SuppressLint("NewApi")
	public static class PlaceholderFragment extends Fragment {
		public PlaceholderFragment() {}
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,false);
			
			return rootView;
		}
	}

}
