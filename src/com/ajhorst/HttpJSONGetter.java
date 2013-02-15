package com.ajhorst;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class HttpJSONGetter {
	
	private final HttpGet httpGet;
	private final DefaultHttpClient httpclient;

	// private constructor 
	private HttpJSONGetter(String url){
		httpGet = new HttpGet(url);
		httpclient = new DefaultHttpClient();
	}
	
	// static factory method
	public static HttpJSONGetter createBasicGetter(String url){
		return new HttpJSONGetter(url);
	}
	
	/* note: method call has to be parameterized AND a class object
	 * must be passed as an argument. There's some funky Java at work here.
	 * 
	 * A call will look something like getter.<String>getClassFromJSON(String.class);
	 */
	public <T> T getClassFromJSON (Class<T> instanceClass){
		HttpResponse response = null;
		
		try {
			response = httpclient.execute(httpGet);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		HttpEntity entity = response.getEntity();
		
		String jsonString = null;
		
		try {
			jsonString = EntityUtils.toString(entity);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		T result = gson.fromJson(jsonString, instanceClass);
		
		return result;
	}
}
