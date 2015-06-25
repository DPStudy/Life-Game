package com.life.viewer;

import com.life.game.map.LifeMap;

public interface Viewer {
	public void setHandle(DrawHandle handle);
	public void draw(LifeMap map);
}
