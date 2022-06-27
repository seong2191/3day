package com.study.common.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

// package이름은 보통 회사이름(또는 url) 반대
public class CookieUtils {
	
	private Map<String, Cookie> cookieMap = new HashMap<>();
	
	// 특정 쿠키 찾기
	
	// CookieUtils 만들 때 cookieMap에 request에 있는 모든 쿠키가 저장
	public CookieUtils(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
	}
	
	public Cookie getCookie(String name) {
		return cookieMap.get(name);
	}
	public String getValue(String name) {
		return cookieMap.get(name).getValue();
	}
	public boolean exists(String name) {
		return cookieMap.get(name)!=null;
	}
	
	// 쿠키생성
	public static Cookie createCookie(String name, String value) {
		/*
		 * Cookie cookie = new Cookie(name,value); return cookie;
		 */
		return createCookie(name, value,"","",-1);
	}
	public static Cookie createCookie(String name, String value, int maxAge) {
		/*
		 * Cookie cookie = new Cookie(name,value); cookie.setMaxAge(maxAge); return
		 * cookie;
		 */
		return createCookie(name, value,"","",maxAge);
	}
	public static Cookie createCookie(String name, String value, String path) {
		/*
		 * Cookie cookie = new Cookie(name,value); cookie.setPath(path); return cookie;
		 */
		return createCookie(name, value,"",path,-1);
	}
	public static Cookie createCookie(String name, String value, String path, int maxAge) {
		/*
		 * Cookie cookie = new Cookie(name,value); cookie.setPath(path);
		 * cookie.setMaxAge(maxAge); return cookie;
		 */
		return createCookie(name, value,"",path,maxAge);
	}
	public static Cookie createCookie(String name, String value, String domain, String path, int maxAge) {
		Cookie cookie = new Cookie(name,value);
		cookie.setDomain(domain);
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		return cookie;
	}
	
	
	

}
