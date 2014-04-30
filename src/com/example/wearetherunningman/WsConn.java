package com.example.wearetherunningman;

import io.socket.SocketIO;

import java.net.MalformedURLException;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Application;

public class WsConn extends Application {

	private SocketIO socket;
    private WsCallback callback;
       
	public WsConn(WsCallbackInterface callback){
		this.callback = new WsCallback(callback);
	}
    
    public void run(String URL) {
    	try {
			socket = new SocketIO(URL, callback);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }
    
    public void sendMsg(String username, String msg){
    	JSONObject json = new JSONObject();
    	
    	try {
    		json.put("username", username);
		    json.put("msg", msg);
		    
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    	socket.emit("data-changed", json);
    	
    }
    // 메시지 전달
    public void sendMessage(Double message0,Double message1) {
    	
    	System.out.println(message0);
    	JSONObject json = new JSONObject();
    	
    	try {
    		json.put("uid", 0);
		    json.put("uname", "최연상");
		    json.put("team",1);
            json.put("latitude", message0);
            json.put("longitude", message1);
            
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    	
        socket.emit("data-changed", json);
       
    }
    
    // 방 참가 메소드 
    public void joinRoom(String username, String roomname ){
    	try {
            JSONObject json = new JSONObject();
            json.put("username", username);
            json.put("roomname", roomname);
            socket.emit("join", callback, json);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void joinUser(String username) {
        try {
            JSONObject json = new JSONObject();
            json.putOpt("username", username);
            socket.emit("username", callback, json);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
   
    
    
    
}
