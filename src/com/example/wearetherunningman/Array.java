package com.example.wearetherunningman;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Array {

	Player[] player = new Player[20]; // 객체배열 
	int j=0;
	
	/*public Array(){
		for (int i = 0; i < player.length; i++)  // 객체배열 초기화!!
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
		
		Log.i("받은 id",receive_uid);
		///해결할 부분
		for(int k=0; k<player.length; k++){
			
			if(receive_uid.equals(player[k].id)){ // 받아온 아이디를 배열0부터 비교.. 같은게 있다면
				array_update(jsondata,k);			// 갱신
				break;
				
			}
			else		// 같은게 없다면
			{
				
				if (k==j)  //j가 배열 번호, 그 번호부터 비어잇다는 말이다.
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
		
		Log.i("갱신됨",player[i].id+""+player[i].name);
		}
		
		
		// 생성 메소드
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
		
		Log.i("생성됨",player[j].id+""+player[j].name);
		j++; // 배열 인덱스 증가
		}
		
		
		
	
}
