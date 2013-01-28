package com.mothin.gonjay.whatweb;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class MainActivity extends Activity {

	private WebView myWebview = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myWebview = (WebView)findViewById(R.id.webview);
		//myWebview.loadUrl("http://www.baidu.com");
		myWebview.loadUrl("file:///android_asset/fromed.html");
		//myWebview.loadUrl("file:///android_asset/informationed.html");		 

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.activity_main, menu);
        menu.add(0, 1, 1, R.string.timeclock);
        menu.add(0, 2, 2, R.string.imagelook);
        menu.add(0, 3, 3, "设置");
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item){
		if(item.getItemId() == 1){
			//创建Intent对象，action为ELITOR_CLOCK  
			Intent intent = new Intent("ELITOR_CLOCK");  
			intent.putExtra("msg","每10秒钟");    
			 
			//定义一个PendingIntent对象，PendingIntent.getBroadcast包含了sendBroadcast的动作。  
			//也就是发送了action 为"ELITOR_CLOCK"的intent  
			PendingIntent pi = PendingIntent.getBroadcast(this,0,intent,0);
			//AlarmManager对象,注意这里并不是new一个对象，Alarmmanager为系统级服务  
			AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);    
			  
			//设置闹钟从当前时间开始，每隔5s执行一次PendingIntent对象pi，注意第一个参数与第二个参数的关系  
			// 5秒后通过PendingIntent pi对象发送广播  
			am.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),10000,pi);
		}else if(item.getItemId() == 2){
			Intent intent = new Intent(MainActivity.this,ImagePagerActivity.class);
			startActivity(intent);
		}else if(item.getItemId() == 3){
			
		}
		return true;
	}

}
