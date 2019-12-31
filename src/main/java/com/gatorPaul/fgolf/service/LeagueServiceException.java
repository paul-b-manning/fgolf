package com.gatorPaul.fgolf.service;

import java.util.HashMap;
import java.util.Map;

import com.gatorPaul.fgolf.data.model.League;

public class LeagueServiceException extends Exception{

	public static final int ERROR_SAVE_GENERAL = 100;
	
	public static final Map<Integer, String> messageMap = new HashMap<>();
	static {
		messageMap.put(ERROR_SAVE_GENERAL, "Error occurred trying to save the League.");
	}
	
	public LeagueServiceException(int code, League league, Throwable ex) {
		super(getLeagueServiceExceptMessage(code, league), ex);
	}
	
	private static String getLeagueServiceExceptMessage(int code, League league) {
		StringBuilder message = new StringBuilder();
		message.append(messageMap.get(code));
		if(league != null) {
			message.append(" League = ");
			message.append(league.toString());
		}
		return message.toString();		
	}
}
