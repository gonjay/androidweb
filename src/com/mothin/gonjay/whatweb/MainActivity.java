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
        menu.add(0, 3, 3, "����");
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item){
		if(item.getItemId() == 1){
			//����Intent����actionΪELITOR_CLOCK  
			Intent intent = new Intent("ELITOR_CLOCK");  
			intent.putExtra("msg","ÿ10����");    
			 
			//����һ��PendingIntent����PendingIntent.getBroadcast������sendBroadcast�Ķ�����  
			//Ҳ���Ƿ�����action Ϊ"ELITOR_CLOCK"��intent  
			PendingIntent pi = PendingIntent.getBroadcast(this,0,intent,0);
			//AlarmManager����,ע�����ﲢ����newһ������AlarmmanagerΪϵͳ������  
			AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);    
			  
			//�������Ӵӵ�ǰʱ�俪ʼ��ÿ��5sִ��һ��PendingIntent����pi��ע���һ��������ڶ��������Ĺ�ϵ  
			// 5���ͨ��PendingIntent pi�����͹㲥  
			am.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),10000,pi);
		}else if(item.getItemId() == 2){
			Intent intent = new Intent(MainActivity.this,ImagePagerActivity.class);
			startActivity(intent);
		}else if(item.getItemId() == 3){
			
		}
		return true;
	}

}
