package com.life.viewer;

import java.io.IOException;

import com.life.game.map.LifeMap;

public class ConsoleViewer implements Viewer{
	private DrawHandle handle;
	
	@Override
	public void draw(LifeMap map){
		final int X_LENGTH = map.getXRange();
		final int Y_LENGTH = map.getYRange();
		
		try {
			Runtime.getRuntime().exec("cls");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int y=0; y<Y_LENGTH; y++){
			for(int x=0; x<X_LENGTH; x++){
				boolean isAlive = map.isAlive(x, y);
				System.out.println((isAlive ? "○" : "●")+"\t");
			}
			System.out.println();
		}
	}

	@Override
	public void setHandle(DrawHandle handle) {
		this.handle = handle;
	}
}
