package com.example.dromnotificator;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.message.BasicNameValuePair;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyDromFragment extends Fragment {
	
	private Requester requester = new Requester();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}
	
	@Override 
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
		View view  = inflater.inflate(R.layout.my_drom, container, false);
		return view;
	}
	
	public boolean signIn(String accountID, String pass) {
		try {		
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			nameValuePairs.add(new BasicNameValuePair("id", accountID));
			nameValuePairs.add(new BasicNameValuePair("password", pass));
			nameValuePairs.add(new BasicNameValuePair("action", "restore"));
			String response = requester.sendPost(Requester.enterUrl, nameValuePairs);
			if(response == null) {
				Log.d("Errors", requester.errorMessage);
			}

		
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public void checkSignIn() {
		
	}
	
	@Override 
	public void onDestroyView() {
		super.onDestroyView();
	}

}
