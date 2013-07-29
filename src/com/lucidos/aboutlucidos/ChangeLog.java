package com.lucidos.aboutlucidos;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class ChangeLog extends Fragment {
		Context mContext;
		
		public ChangeLog(Context context) {
			mContext = context;
		}
		
		@Override
		public View onCreateView(LayoutInflater inflater, 
				ViewGroup container, Bundle savedInstanceState) {
			View view = inflater.inflate(R.layout.change_log_screen, null);
			
			TextView tv;
			tv = (TextView) view.findViewById(R.id.changelog);
			try{
			        tv.setText(readtest());
			}catch(IOException e){}
			
	    	return view;
		}
		
	    private String readtest() throws IOException {
	    	String test;
	    	      FileInputStream textfis = new FileInputStream("/system/etc/changelog.txt");
	    	BufferedInputStream textbis = new BufferedInputStream(textfis);
	    	byte[] buffer = new byte[1024];
	        textbis.read(buffer);
	        test = new String(buffer);
	    	return test ;
	    	}
	    
	    // 출처 : http://kin.naver.com/qna/detail.nhn?d1id=1&dirId=1070402&docId=133544596&qb=7Ja07ZSMIHR4dCDrtojrn6zsmKTripQg7IaM7Iqk&enc=utf8&section=kin&rank=12&search_sort=0&spq=0
}

