package com.in28minutes.learnspringframework.game;

public class GameRunner {
	private GamingConsole game;

	public GameRunner(GamingConsole game) {
		this.game=game;
	}

	public void run() {
		System.out.println("Running " + game );
		game.down();
		game.left();
		game.right();
		game.up();
	}

}
