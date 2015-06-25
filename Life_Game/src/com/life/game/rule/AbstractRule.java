package com.life.game.rule;

import com.life.game.map.LifeMap;

public abstract class AbstractRule {
	protected LifeMap srcMap;
	abstract public void nextState() throws Exception;
}
