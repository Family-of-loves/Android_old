package com.example.wearetherunningman;

import android.app.Application;
import android.content.Context;

public class Player extends Application {
	String id ;
	String name ;
	String team ;
	String latitude ;
	String longitude ;
	String item;
	boolean isAlive = true;
	boolean isSetComplete = false;
	
	GPSListener gc;
	
	public Player(String id, String name, String team, String item, Context context){
		// ���̾�α� ���� �Է� �� �����Ϳ� ���� �ʱ�ȭ
		this.id = id;
		this.name = name;
		this.team = team;
		this.item = item;
		gc = new GPSListener(context, this);
	}
}

