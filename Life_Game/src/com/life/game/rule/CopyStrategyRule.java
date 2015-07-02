package com.life.game.rule;

import com.life.game.map.ArrayLifeMap;

import com.life.game.map.LifeMap;

public class CopyStrategyRule extends AbstractRule {
	
	LifeMap nextStateMap;
	
	public CopyStrategyRule(LifeMap srcMap) {
		super(srcMap);
		nextStateMap = new ArrayLifeMap(srcMap.getXRange(), srcMap.getYRange());
		for(int x = 0; x < srcMap.getXRange(); x++) {
			for(int y = 0; y < srcMap.getYRange(); y++) {
				if(srcMap.isAlive(x, y)) nextStateMap.alive(x, y);
			}
		}
	}
	
	@Override
	public LifeMap nextState() throws Exception {
		for(int x = 0; x < srcMap.getXRange(); x++) {
			for(int y = 0; y < srcMap.getYRange(); y++) {
				if(isAlive(x, y, srcMap.isAlive(x, y))) {
					nextStateMap.alive(x, y);
				} else {
					nextStateMap.die(x, y);
				}
			}
		}
		
		for(int x = 0; x < srcMap.getXRange(); x++) {
			for(int y = 0; y < srcMap.getYRange(); y++) {
				if(nextStateMap.isAlive(x, y)) {
					srcMap.alive(x, y);
				} else {
					srcMap.die(x, y);
				}
			}
		}
		return nextStateMap;
	}

	private boolean isAlive(int x, int y, boolean isAlive) {
		int ncout = 0;
		ncout += neighborAlive(x - 1, y - 1);
		ncout += neighborAlive(x + 0, y - 1);
		ncout += neighborAlive(x + 1, y - 1);
		ncout += neighborAlive(x - 1, y + 0);
		ncout += neighborAlive(x + 1, y + 0);
		ncout += neighborAlive(x - 1, y + 1);
		ncout += neighborAlive(x + 0, y + 1);
		ncout += neighborAlive(x + 1, y + 1);
		if(isAlive) {
			return ncout == 2  || ncout == 3;
		} else {
			return ncout == 3;
		}
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
