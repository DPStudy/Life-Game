package com.life.game.rule;

import com.life.game.map.ArrayLifeMap;

import com.life.game.map.LifeMap;

public class CopyStrategyRule extends AbstractRule {
	
	LifeMap nextStateMap;
	
	public CopyStrategyRule(int xLength, int yLength) {
		super(xLength, yLength);
		nextStateMap = new ArrayLifeMap(xLength, yLength);
	}
	
	@Override
	public void nextState() throws Exception {
		for(int x = 0; x < srcMap.getXRange(); x++) {
			for(int y = 0; y < srcMap.getYRange(); y++) {
				if(isAlive(x, y)) {
					nextStateMap.alive(x, y);
				} else {
					nextStateMap.die(x, y);
				}
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
		return isXRange(x) && isYRange(y) && srcMap.isAlive(x, y) ? 1 : 0;
	}

	private boolean isYRange(int y) {
		return y >= 0 && y < srcMap.getXRange();
	}
	
	private boolean isXRange(int x) {
		return x >= 0 && x < srcMap.getYRange();
	}
}
