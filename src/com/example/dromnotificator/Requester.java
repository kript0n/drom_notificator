package com.example.dromnotificator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import android.net.http.AndroidHttpClient;
import android.os.StrictMode;

public class Requester {
	
	private static AndroidHttpClient httpClient;
	private HttpContext context = new BasicHttpContext();
	private CookieStore cookieStore = new BasicCookieStore();
	public List<Cookie> cookies = new ArrayList<Cookie>();
	public static final String enterUrl = "http://drom.ru/myreg.php";
	public static final String registerUrl = "http://drom.ru/myreg.php?action=create";
	public String errorMessage = ""; 
	
	public Requester() {
		/*if(android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}*/
		
		httpClient = AndroidHttpClient.newInstance("DromNotificator");
		context.setAttribute(ClientContext.COOKIE_STORE, cookieStore);			
	}
	
	public String sendPost(String url, List<NameValuePair> params) throws ClientProtocolException, IOException, UnsupportedEncodingException  {
		HttpResponse resp = null;
		HttpPost post = new HttpPost();
		post.setEntity(new UrlEncodedFormEntity(params));
		resp = httpClient.execute(post);
		if(resp.getStatusLine().getStatusCode() != 200) {
			errorMessage = "Status line is " + resp.getStatusLine();
			return null;		
		}
		if(resp.getEntity().getContentLength() == 0) {
			errorMessage = "Empty response";
			return null;
		}
		cookies = cookieStore.getCookies();
		BufferedReader reader = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()));
		StringBuilder total = new StringBuilder();
		String line = null;
		while((line = reader.readLine()) != null) {
			total.append(line);
		}
		reader.close();
		return total.toString();
	}
	
}
