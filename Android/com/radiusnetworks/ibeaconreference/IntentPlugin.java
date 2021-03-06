package com.radiusnetworks.ibeaconreference;

import java.io.IOException;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import android.util.Log;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.Intent;
import android.webkit.WebSettings.PluginState;


public class IntentPlugin extends CordovaPlugin{
	public static final String TAG = "IntentPlugin";
	private MonitoringActivity monitoringActivity = null;
	private void startScan() throws IOException {
		Log.e(TAG, "start scan....");
		Context context =  cordova.getActivity().getApplicationContext();
		/*monitoringActivity = new MonitoringActivity();
		monitoringActivity.onCreate();*/
	   // Intent intent = new Intent(this, MonitoringActivity.class);
	   Intent intent= new Intent(this.cordova.getActivity().getApplicationContext(), MonitoringActivity.class);
	    context.startActivity(intent);
		//this.cordova.getActivity().startActivity(intent);
		//this.cordova.getActivity().startService(intent);
		//Log.e(TAG, "Success"+intent);
		
	}
	/*private Context getActivity() {
		// TODO Auto-generated method stub
		return true;
	}*/
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
		PluginResult.Status status = PluginResult.Status.OK;
	    String result = "";
	    try {
			//return true;
	    	  if (action.equals("startScan")) {
	    		  startScan();
	          } 
	           else {
	              status = PluginResult.Status.INVALID_ACTION;
	          }
	        //return new PluginResult(status, result);
	    	  PluginResult pluginResult = new PluginResult(status);
	            pluginResult.setKeepCallback(true);
	    	  callbackContext.sendPluginResult(pluginResult);
	    } catch (IOException e) {
		return false;
	        //return new PluginResult(PluginResult.Status.IO_EXCEPTION);
	        /*callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.IO_EXCEPTION));*/
	    }
		return true;
	}
	

}
