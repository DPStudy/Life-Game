package com.life.game.rule;

import com.life.game.map.ArrayLifeMap;

import com.life.game.map.LifeMap;

public abstract class AbstractRule {
	protected LifeMap srcMap;
	public AbstractRule(int xLength, int yLength) {
		srcMap = new ArrayLifeMap(xLength, yLength);
	}
	
	abstract void nextState() throws Exception;
}
