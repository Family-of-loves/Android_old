package com.example.wearetherunningman;


import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class GPSListener implements LocationListener {
	
	private LocationManager locationManager;
    private String locationProvider = null;
    
    private double latitude;
	private double longitude;

    private Context ct;
    
    private Player player;
    
    public GPSListener(Context c, Player p){
        ct = c;
        player = p;
    	start();
    }
    
    protected void start() {
        // TODO Auto-generated method stub
    	long minTime = 10000;
		float minDistance = 0;
        try {
        	Toast.makeText(ct, "��ġ Ȯ���� ���۵Ǿ����ϴ�.", Toast.LENGTH_SHORT).show();
            
        	// LocationManager ��ü ����, LocationManager ��ü��
            // Context.getSystemService(Context.LOCATION_SERVICE) �� �����ȴ�.
            locationManager = (LocationManager) ct.getSystemService(Context.LOCATION_SERVICE);
            Toast.makeText(ct, "LocationManager ����", Toast.LENGTH_SHORT).show();
            
            // LocationManaer.NETWORK_PROVIDER : ��������κ��� ���� ��ġ Ȯ��
            // LocationManaer.GPS_PROVIDER : GPS��κ��� ���� ��ġ Ȯ��
            // boolean isProviderEnabled(String provider)
            // provider�� ���°� ���� ����� boolean���� return ���ش�.
            if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) == true) {
                // NETWORK_PROVIDER�� Enabled ���..
                locationProvider = LocationManager.NETWORK_PROVIDER;
            } else {
                // GPS_PROVIDER�� Enabled ���..
                locationProvider = LocationManager.GPS_PROVIDER;
            }
 
            // ���� ��ġ�� ��ȸ�Ѵ�. ����� locationListener�� ���� ����
            // public void requestLocationUpdates
            // (String provider, ���
            // long minTime, ��ġ ������Ʈ�ϴ� �ּ����� ����(���� �и�������)
            // float minDistance, ��ġ ������Ʈ�Ǵ� �ּ����� �Ÿ�(���� ����)
            // LocationListener listener )
            locationManager.requestLocationUpdates(locationProvider, minTime, minDistance,this);
            Toast.makeText(ct, "RequestLocationUpdates", Toast.LENGTH_SHORT).show();
            
            /*
            // �ֱ� ��ġ�� ��ȸ�Ѵ�. ����� �ٷ� ���� �� ����
            // Location getLastKnownLocation(String provider)
            // Provider�� ���ڷ� �޾� ���������� �˷��� ��ġ�� �����ؼ� ��ġ�� ������
            // Provider�� ��Ȱ��ȭ �Ǿ��ִ� ���� null�� return �ȴ�.
            Location lastKnowLocation = locationManager.getLastKnownLocation(locationProvider);
            */
        } catch (Exception e) {
            Log.d("GPSListener Start() Exception", e.getMessage()); //�α������� Ȯ���Ϸ���
        }
    }
    
    public void onLocationChanged(Location location) {
		// TODO �ڵ� ������ �޼ҵ� ����
        if (location != null) {
        	longitude = location.getLongitude();
        	latitude = location.getLatitude();
        	
        	player.longitude = Double.toString(longitude);
        	player.latitude = Double.toString(latitude);
        	player.isSetComplete = true;
        } 
	}
	public void onProviderDisabled(String provider) {}
    public void onProviderEnabled(String provider) {}
    public void onStatusChanged(String provider, int status, Bundle extras) {}
}
