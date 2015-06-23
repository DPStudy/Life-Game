package com.life.game.stone;

public class Stone {
	StoneState st = StoneState.die;
	
	public void alive() {
		st = StoneState.alive;
	}

	public void die() {
		st = StoneState.die;
	}

	public boolean isAlive() {
		return st == StoneState.alive ? true : false;
	}

	enum StoneState {
		alive, die
	}
}
