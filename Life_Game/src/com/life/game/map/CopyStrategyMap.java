package com.life.game.map;

import com.life.game.stone.Stone;

public class CopyStrategyMap extends AbstractMap {
	
	Stone[][] nextStateMap;
	
	@Override
	void nextState() {
		for(int x = 0; x < srcMap.length; x++) {
			for(int y = 0; y < srcMap[0].length; y++) {
				if(isAlive(x, y)) nextStateMap[y][x].alive();
				else nextStateMap[y][x].die();
			}
		}
	}

	private boolean isAlive(int x, int y) {
		int ncout = 0;
		ncout += neighborAlive(x - 1, y - 1);
		ncout += neighborAlive(x + 0, y - 1);
		ncout += neighborAlive(x + 1, y - 1);
		ncout += neighborAlive(x - 1, y + 0);
		ncout += neighborAlive(x + 1, y + 0);
		ncout += neighborAlive(x - 1, y + 1);
		ncout += neighborAlive(x + 0, y + 1);
		ncout += neighborAlive(x + 1, y + 1);
		return ncout >= 3 ? true : false;
	}

	private int neighborAlive(int x, int y) {
		return isXRange(x) && isYRange(y) && srcMap[y][x].isAlive() ? 1 : 0;
	}

	private boolean isYRange(int y) {
		return y >= 0 && y < srcMap.length;
	}
	
	private boolean isXRange(int x) {
		return x >= 0 && x < srcMap[0].length;
	}
}
