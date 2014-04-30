package com.example.wearetherunningman;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Array {

	Player[] player = new Player[20]; // ��ü�迭 
	int j=0;
	
	/*public Array(){
		for (int i = 0; i < player.length; i++)  // ��ü�迭 �ʱ�ȭ!!
				{
					player[i] = new Player();
					player[i].id=null;
				}
	}*/
	
	public void compare(JSONObject jsondata) {
		// TODO Auto-generated method stub
		String receive_uid=null;
		try {
			receive_uid = jsondata.get("uid").toString();
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
		e1.printStackTrace();
		}
		
		Log.i("���� id",receive_uid);
		///�ذ��� �κ�
		for(int k=0; k<player.length; k++){
			
			if(receive_uid.equals(player[k].id)){ // �޾ƿ� ���̵� �迭0���� ��.. ������ �ִٸ�
				array_update(jsondata,k);			// ����
				break;
				
			}
			else		// ������ ���ٸ�
			{
				
				if (k==j)  //j�� �迭 ��ȣ, �� ��ȣ���� ����մٴ� ���̴�.
					{
						array_insert(jsondata);
						break;
					}
				
			}
					
		}
	}
		
	void array_update(JSONObject jsondata,int i){
		
		try {
				player[i].id = jsondata.get("uid").toString();
		} catch (JSONException e1) {
				// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		try {
			player[i].name = jsondata.get("uname").toString();
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			player[i].team = jsondata.get("team").toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			player[i].latitude = jsondata.get("gps_data1").toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			player[i].longitude = jsondata.get("gps_data2").toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(i);		
		
		Log.i("���ŵ�",player[i].id+""+player[i].name);
		}
		
		
		// ���� �޼ҵ�
		void array_insert(JSONObject jsondata){
				
		try {
				player[j].id = jsondata.get("uid").toString();
		} catch (JSONException e1) {
				// TODO Auto-generated catch block
			e1.printStackTrace();
		}
							
		try {
			player[j].name = jsondata.get("uname").toString();
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			player[j].team = jsondata.get("team").toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			player[j].latitude = jsondata.get("gps_data1").toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			player[j].longitude = jsondata.get("gps_data2").toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(j);		
		
		Log.i("������",player[j].id+""+player[j].name);
		j++; // �迭 �ε��� ����
		}
		
		
		
	
}
