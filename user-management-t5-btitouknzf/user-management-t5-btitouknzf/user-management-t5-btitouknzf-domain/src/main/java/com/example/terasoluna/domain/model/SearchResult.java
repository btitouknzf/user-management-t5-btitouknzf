package com.example.terasoluna.domain.model;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.SerializationUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SearchResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Map<String, UserSearchResultInfo> userSearchResultInfo = new LinkedHashMap<>();

	public Collection<UserSearchResultInfo> getUserSearchResultInfo(){
		return userSearchResultInfo.values();
	}
	
	public UserSearchResultInfo getSelectUserSearchResultInfo(String selectNum){
		return userSearchResultInfo.get(selectNum);
	}
	
	public void setUsersearchResultInfo(Collection<UserSearchResultInfo> userSearchResultInfo){
		
		int i = 0;
		for(UserSearchResultInfo s: userSearchResultInfo){
			this.userSearchResultInfo.put(String.valueOf(i), s);
			
			i++;
		}
		
	}
	
	public SearchResult clear(){
		userSearchResultInfo.clear();
		return this;
	}
	
	/**
	 * ユーザー情報の状態を表すハッシュ値を作成する
	 * 
	 * @param searchResult
	 * @return
	 */
	public String calcSignature(){
		byte[] serialized = SerializationUtils.serialize(this);
		byte[] signature = null;
		try{
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			signature = messageDigest.digest(serialized);
		}catch (NoSuchAlgorithmException ignored){
			
		}
		return new String(Base64.encode(signature));
	}
	
}
