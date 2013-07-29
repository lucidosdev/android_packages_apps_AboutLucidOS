package com.lucidos.aboutlucidos;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

@SuppressLint("ValidFragment")
public class Members extends Fragment {
		Context mContext;
		
		public Members(Context context) {
			mContext = context;
		}
		
		@Override
		public View onCreateView(LayoutInflater inflater, 
				ViewGroup container, Bundle savedInstanceState) {
			View view = inflater.inflate(R.layout.members_screen, null);
			
			Button like_lee, like_jeon;
			like_lee = (Button) view.findViewById(R.id.likelee);
			like_jeon = (Button) view.findViewById(R.id.likejeon);
			
			like_lee.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
			    	Uri uri = Uri.parse("http://likel.wk.to");
			    	Intent it  = new Intent(Intent.ACTION_VIEW,uri);
			    	startActivity(it);
				}
	    	});
			
			like_jeon.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
			    	Uri uri = Uri.parse("http://likej.wk.to");
			    	Intent it  = new Intent(Intent.ACTION_VIEW,uri);
			    	startActivity(it);
				}
	    	});
			
	    	return view;
	    	
		}
    
}
