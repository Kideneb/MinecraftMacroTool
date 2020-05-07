package logic;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import ext.GlobalKeyListener;
import ui.JConsole;

public abstract class Main {
	
	static public String versionName = "Macro Parkour Tool 0.1.2";
	static public String versionDate = "2020-05-07";
	
	static long millis;
	static String[] args;

	public static void main(String[] args) throws IOException, AWTException {
		Main.args = args;
		JConsole console = new JConsole();
		console.setVisible(true);
		CommandHelper ch = new CommandHelper();
		Robot robot = new Robot();
		GlobalKeyListener.start();
		
		ArrayList<Macro> mac  = new ArrayList<Macro>();
		Config.readConfig();

		millis = System.currentTimeMillis();
		millis = millis - millis % 50;
		sleepTillTick();
		while(true){
				
				ch.listen();
				if(Macro.currentMacros.size() != 0) {
					try {
                        mac.addAll(Macro.currentMacros);
						mac.forEach(Macro::readLine);
						mac.clear();
					} catch (ConcurrentModificationException e1) {}
					
					Macro.currentMacros.removeIf((Macro m) -> {
						try {
							return !m.userInput.ready();
						} catch (IOException e2) { }
						return false;
					});
				} 
					if (!Macro.allOutputsClosed) {
						outputStuff(robot);
					} else if (Macro.justClosed){
						for (int i = 0; i <= 8; i++) {
							if (Helper.outputKey[i] < 1000) {
							robot.keyRelease(Helper.outputKey[i]);
							} else {
								robot.mouseRelease(Helper.outputKey[i]);
							}
						}
						Macro.justClosed = false;
					}

				sleepTillTick();
				
				
				millis += 50;
		
		}
	}

	
	public static void outputStuff(Robot robot) {
		for (int i = 0; i < 9; i++) {
			if (Macro.pressIterations[i] > -1) {
				Macro.pressIterations[i]--;
				//System.out.println(logic.Helper.outputKey[i]);
				if (Helper.outputKey[i] < 1000) {
					if (Macro.pressIterations[i] > -1) {
						robot.keyPress(Helper.outputKey[i]);
					} else {
						robot.keyRelease(Helper.outputKey[i]);}
				} else {
					if (Macro.pressIterations[i] > -1) {
						robot.mousePress(Helper.outputKey[i]);
					} else {robot.mouseRelease(Helper.outputKey[i]);}
				}
			}
		}
		
		if (Macro.currentXRotation != Macro.xRotation) {
			Point p = MouseInfo.getPointerInfo().getLocation();
			int x = p.x;
			int y = p.y;
			
			int fullX = calcFullX();
			
			int deltaX = fullX - Macro.currentXPixels;
			Macro.currentXPixels = fullX;
			//System.out.println(logic.Macro.currentXPixels);
			//System.out.println(fullX);
			//System.out.println(deltaX);
			
			robot.mouseMove(x+deltaX, y);
			Macro.currentXRotation = Macro.xRotation;
		}
		if (Macro.currentYRotation != Macro.yRotation) {
			Point p = MouseInfo.getPointerInfo().getLocation();
			int x = p.x;
			int y = p.y;
			
			int fullY = calcFullY();
			
			int deltaY = fullY - Macro.currentXPixels;
			Macro.currentXPixels = fullY;
			//System.out.println(logic.Macro.currentXPixels);
			//System.out.println(fullX);
			//System.out.println(deltaX);
			
			robot.mouseMove(x, y+deltaY);
			Macro.currentXRotation = Macro.xRotation;
		}
		
	}
	
	static int calcFullX() {
		float num;
		num = Macro.xRotation;
		num = (float) (num / 0.15);
		
		float f = (float) (Config.mouseSensitivity * 0.6F + 0.2F);
		float f1 = f * f * f * 8.0F;
		int fullX = (int) (num / f1);
		return fullX;
			
	}
	static int calcFullY() {
		float num;
		num = Macro.yRotation;
		num = (float) (num / 0.15);
		
		float f = (float) (Config.mouseSensitivity * 0.6F + 0.2F);
		float f1 = f * f * f * 8.0F;
		int fullY = (int) (num / f1);
		return fullY;
			
	}
	public static void sleepTillTick() {
		//System.out.println(Arrays.toString(logic.Macro.pressIterations));
		//System.out.println(50 - (System.currentTimeMillis() - millis));
		
		if (50 - (System.currentTimeMillis() - millis) > 0) {
			try {
				Thread.sleep((50 - (System.currentTimeMillis() - millis)));
				//System.out.println(System.currentTimeMillis());
			} catch (InterruptedException e3) {}
		}
	}
	
}


