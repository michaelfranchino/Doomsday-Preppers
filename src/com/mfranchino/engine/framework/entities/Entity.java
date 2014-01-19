package com.mfranchino.engine.framework.entities;

import com.mfranchino.engine.framework.game.GameLoop;

public interface Entity extends GameLoop {

	// Framework methods
	public boolean isExpired();
	public void expire();
	public void onExpire();
	public boolean isEnabled();
	public boolean isVisible();
}
