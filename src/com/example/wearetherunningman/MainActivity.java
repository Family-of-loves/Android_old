package com.example.wearetherunningman;


import android.annotation.SuppressLint;
import android.app.Fragment;
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
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button sendbutton=(Button)findViewById(R.id.button01);	
		Button ackbutton=(Button)findViewById(R.id.button02);	

		//socket.joinRoom("�ȵ���̵�23", "hagi4u");
		// ����� ���� �Է� ���̾�α׿��� �Է��ϸ� ���� ���Խ�Ŵ
		
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
				Toast.makeText(getApplicationContext(), player.longitude + " / " +player.latitude,  Toast.LENGTH_SHORT).show();
			}
		});
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

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
