package com.life.timer;

import com.life.game.rule.AbstractRule;

public class TickTimer implements Runnable{
	private long interval = 5000L;
	private boolean isRun = true;
	private AbstractRule map;
	
	public TickTimer(AbstractRule map){
		if(map == null)	throw new IllegalArgumentException("map must be not null");
		
		this.map = map;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRun){
			try {
				this.map.nextState();
				Thread.sleep(interval);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	
	public void restart(){
		isRun = true;
	}
	
	public void stop(){
		isRun = false;
	}
	
	public void changeInterval(long interval){
		this.interval = interval;
	}
}
