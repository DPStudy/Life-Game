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
		map.alive(4, 3);
		map.alive(5, 3);
		map.alive(6, 3);
		
		map.alive(4, 4);
		map.alive(4, 5);
		
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
		// TODO Auto-generated method stub
		while(isPlay){
			try {
				map = rule.nextState();
				Thread.sleep(INTERVAL);
				viewer.draw(map);
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
