package com.life.manager;

import com.life.game.map.LifeMap;
import com.life.game.rule.AbstractRule;
import com.life.game.rule.CopyStrategyRule;
import com.life.viewer.ConsoleViewer;
import com.life.viewer.Viewer;

public class GameManager implements Runnable {
	private final long INTERVAL = 1000L;
	private boolean isPlay = false;
	
	private AbstractRule rule;
	private LifeMap map;
	private Viewer viewer = new ConsoleViewer();
	
	public GameManager(LifeMap map) {
		this.map = map;
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
		viewer.draw(map);
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
