package com.life.game.map;

import com.life.game.stone.Stone;

public abstract class AbstractMap {
	protected Stone[][] srcMap;
	abstract void nextState();
}
