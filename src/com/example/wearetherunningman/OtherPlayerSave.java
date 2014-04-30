package com.example.wearetherunningman;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class OtherPlayerSave {

	OtherPlayer[] otherplayer = new OtherPlayer[20]; // ��ü�迭 
	int j=0;
	
	public OtherPlayerSave(){
		for (int i = 0; i < otherplayer.length; i++)  // ��ü�迭 �ʱ�ȭ!!
				{
					otherplayer[i] = new OtherPlayer();
					otherplayer[i].id=null;
				}
	}
	
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
		for(int k=0; k<otherplayer.length; k++){
			
			if(receive_uid.equals(otherplayer[k].id)){ // �޾ƿ� ���̵� �迭0���� ��.. ������ �ִٸ�
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
				otherplayer[i].id = jsondata.get("uid").toString();
		} catch (JSONException e1) {
				// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		try {
			otherplayer[i].name = jsondata.get("username").toString();
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			otherplayer[i].team = jsondata.get("team").toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			otherplayer[i].latitude = jsondata.get("latitude").toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			otherplayer[i].longitude = jsondata.get("longitude").toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(i);		
		
		Log.i("���ŵ�",otherplayer[i].id+""+otherplayer[i].name);
		}
		
		
		// ���� �޼ҵ�
		void array_insert(JSONObject jsondata){
				
		try {
			otherplayer[j].id = jsondata.get("uid").toString();
		} catch (JSONException e1) {
				// TODO Auto-generated catch block
			e1.printStackTrace();
		}
							
		try {
			otherplayer[j].name = jsondata.get("username").toString();
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			otherplayer[j].team = jsondata.get("team").toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			otherplayer[j].latitude = jsondata.get("latitude").toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			otherplayer[j].longitude = jsondata.get("longitude").toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(j);		
		
		Log.i("������",otherplayer[j].id+""+otherplayer[j].name);
		j++; // �迭 �ε��� ����
		}
		
		
		
	
}
