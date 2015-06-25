package com.life.manager;

import com.life.game.map.ArrayLifeMap;
import com.life.game.map.LifeMap;
import com.life.game.rule.AbstractRule;
import com.life.game.rule.CopyStrategyRule;
import com.life.viewer.ConsoleViewer;
import com.life.viewer.Viewer;

public class GameManager implements Runnable {
	private final long INTERVAL = 1000L;
	private final int X_LENGTH = 10;
	private final int Y_LENGTH = 10;
	
	private boolean isPlay = false;
	
	private AbstractRule rule;
	private LifeMap map = new ArrayLifeMap(X_LENGTH,Y_LENGTH);
	private Viewer viewer = new ConsoleViewer();
	
	public GameManager() {
		map.alive(1, 0);
		map.alive(2, 0);
		map.alive(3, 0);
		
		map.alive(0, 1);
		map.alive(1, 1);
		map.alive(2, 1);
		
		rule = new CopyStrategyRule(map);
	}
	
	public void play(){
		new Thread(this).start();
		isPlay = true;
	}
	
	public void stopPlay(){
		this.stop();
	}
	
	@Override
	public void run() {
		viewer.draw(map);
		try {
			Thread.sleep(INTERVAL);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// TODO Auto-generated method stub
		while(isPlay){
			try {
				map = rule.nextState();
				viewer.draw(map);
				Thread.sleep(INTERVAL);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	
	public void restart(){
		isPlay = true;
	}
	
	public void stop(){
		isPlay = false;
	}
}
