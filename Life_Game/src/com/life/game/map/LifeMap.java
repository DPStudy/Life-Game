package com.life.game.map;


public interface LifeMap {
	public int getXRange();
	public int getYRange();
	public boolean isAlive(int x, int y);
	public boolean alive(int x, int y);
	public boolean die(int x, int y);
}
