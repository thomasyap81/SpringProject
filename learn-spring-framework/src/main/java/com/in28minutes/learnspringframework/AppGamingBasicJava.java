package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.PacmanGame;
import com.in28minutes.learnspringframework.game.SuperContraGame;

public class AppGamingBasicJava {

	public static void main(String[] args) {
		//var game = new MarioGame();
		//var game = new SuperContraGame();
		
		var game = new PacmanGame();			
		//object creation
		var gameRunner = new GameRunner(game);	
		//object creation + Wiring of dependencies
		//game is a Dependency of GameRunner 
		gameRunner.run();
		
	}

}
/***
notes:
3 things changes:
1. create new GamingConsole interface
2. Implements Interface on Games Class
3. Change the main class instance to "game" as argument in GameRunner();
***/
