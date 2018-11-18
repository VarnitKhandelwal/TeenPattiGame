package com.varnit.teenpatti;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	List<String> players = new ArrayList<>();
	
	public Player() {
		super();
	}

	public void addPlayers(String name) {
		players.add(name);
	}
					
	public List<String> getPlayers() {
		return players;
	}
}
