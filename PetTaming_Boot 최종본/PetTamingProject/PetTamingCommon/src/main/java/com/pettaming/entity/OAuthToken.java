package com.pettaming.entity;

import lombok.Data;

public class OAuthToken {
	
	private String access_token;
	
	private String token_type;
	
	private String refresh_token;
	
	private int expires_in;
	
	private String scope;
	
	private int refresh_token_expired_in;
	
	private int app_id;
	
	public OAuthToken() {

	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public int getRefresh_token_expired_in() {
		return refresh_token_expired_in;
	}

	public void setRefresh_token_expired_in(int refresh_token_expired_in) {
		this.refresh_token_expired_in = refresh_token_expired_in;
	}	

	public int getApp_id() {
		return app_id;
	}

	public void setApp_id(int app_id) {
		this.app_id = app_id;
	}

	@Override
	public String toString() {
		return "OAuthToken [access_token=" + access_token + ", token_type=" + token_type + ", refresh_token="
				+ refresh_token + ", expires_in=" + expires_in + ", scope=" + scope + ", refresh_token_expired_in="
				+ refresh_token_expired_in + "]";
	}
	
}

