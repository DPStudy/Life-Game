package com.life.game.map;

import com.life.game.stone.Stone;

public class ArrayLifeMap implements LifeMap {
	Stone[][] map;
	
	public ArrayLifeMap(int xLength, int yLength) {
		map = new Stone[yLength][xLength];
	}
	
	@Override
	public int getXRange() {
		return map.length;
	}

	@Override
	public int getYRange() {
		if(map[0] != null)
			return map[0].length;
		else 
			return 0;
	}
	
	@Override
	public boolean isAlive(int x, int y) {
		if(isValidXY(x, y))
			return map[y][x].isAlive();
		else 
			return false;
	}

	private boolean isValidXY(int x, int y) {
		if(isValidXY(x, y))
			return map[y] != null && map[y][x] != null;
		else 
			return false;
	}

	@Override
	public boolean alive(int x, int y) {
		if(isValidXY(x, y)) {
			map[y][x].alive();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean die(int x, int y) {
		if(isValidXY(x, y)) {
			map[y][x].die();
			return true;
		} else {
			return false;
		}
	}
}
