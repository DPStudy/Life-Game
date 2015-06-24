package com.life.game.stone;

public class Stone {
	State st = State.die;
	
	public void alive() {
		st = State.alive;
	}

	public void die() {
		st = State.die;
	}

	public boolean isAlive() {
		return st == State.alive ? true : false;
	}

	public enum State {
		alive, die
	}
}
