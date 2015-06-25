package com.life.manager;

import com.life.game.map.ArrayLifeMap;
import com.life.game.map.LifeMap;
import com.life.game.rule.AbstractRule;
import com.life.game.rule.CopyStrategyRule;
import com.life.viewer.ConsoleViewer;
import com.life.viewer.Viewer;

public class GameManager implements Runnable{
	private final long INTERVAL = 5000L;
	private final int X_LENGTH = 10;
	private final int Y_LENGTH = 10;
	
	private boolean isPlay = false;
	
	private AbstractRule rule = new CopyStrategyRule();
	private LifeMap map = new ArrayLifeMap(X_LENGTH,Y_LENGTH);
	private Viewer viewer = new ConsoleViewer();
	
	public void play(){
		new Thread(this).start();
	}
	
	public void stopPlay(){
		this.stop();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isPlay){
			try {
				this.rule.nextState();
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
