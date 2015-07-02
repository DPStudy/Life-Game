package com.life.client;

import com.life.game.map.ArrayLifeMap;
import com.life.game.map.LifeMap;
import com.life.manager.GameManager;

public class Main {

	public static void main(String[] args) {
		LifeMap map = new ArrayLifeMap(10, 10);
		map.alive(1, 0);
		map.alive(2, 1);
		map.alive(0, 2);
		map.alive(1, 2);
		map.alive(2, 2);
		
		GameManager m = new GameManager(map);
		m.play();
	}

}
