package com.lucidos.aboutlucidos;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

public class SplashActivity extends Activity {
	int splashSceneNumber;
	LinearLayout splashLayout;
	Handler mHandler;
	boolean isClick;

	@SuppressLint("HandlerLeak")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.splashactivity);
		splashLayout = (LinearLayout) findViewById(R.id.layout);
		splashSceneNumber = 1;
		isClick = true;
		mHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				switch (splashSceneNumber) {
				case 0:
					splashSceneNumber = 1;
					mHandler.sendEmptyMessage(splashSceneNumber);
					break;

				case 1:
					splashSceneNumber = 2;
					mHandler.sendEmptyMessageDelayed(splashSceneNumber, 2000);
					break;

				case 2:
					Intent i = new Intent(SplashActivity.this,
							MainActivity.class);

					startActivity(i);
					//overridePendingTransition(R.anim.fade, R.anim.hold);
					break;

				case 3:
					if (isClick && splashSceneNumber == 0) {
						splashSceneNumber = 0;
						mHandler.sendEmptyMessage(splashSceneNumber);
					}
					break;
				}
			}

		};
		mHandler.sendEmptyMessageDelayed(2, 1000);
	}

	public void hn_splashOnclick(View v) {

		switch (splashSceneNumber) {
		case 0:
			splashSceneNumber = 0;

			isClick = false;
			mHandler.sendEmptyMessage(splashSceneNumber);
			break;

		case 1:
			splashSceneNumber = 2;
			mHandler.sendEmptyMessage(splashSceneNumber);
			break;
		}
	}
}