package com.example.dromnotificator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ReviewFragment extends Fragment {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override 
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
		View view  = (View)inflater.inflate(R.layout.review, container, false);
		return view;
	}
	
	@Override 
	public void onDestroyView() {
		super.onDestroyView();
	}

}
