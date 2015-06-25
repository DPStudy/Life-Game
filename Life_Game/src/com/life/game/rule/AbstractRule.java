package com.life.game.rule;

import com.life.game.map.LifeMap;

public abstract class AbstractRule {
	protected LifeMap srcMap;
	public AbstractRule(LifeMap srcMap) {
		this.srcMap = srcMap;
	}
	
	abstract public LifeMap nextState() throws Exception;
}
