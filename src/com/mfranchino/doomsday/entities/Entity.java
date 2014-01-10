package com.mfranchino.doomsday.entities;

import com.mfranchino.doomsday.game.GameLoop;

public interface Entity extends GameLoop {

	// Framework methods
	public boolean isExpired();
	public void expire();
	public void onExpire();
	public boolean isEnabled();
	public boolean isVisible();
}
