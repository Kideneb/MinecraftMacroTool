package logic;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Config {
	static double mouseSensitivity = 0.5;
	static int mouseSensitivityPercent = -1;
	static int forwardKey = KeyEvent.VK_W;
	static int leftKey = KeyEvent.VK_A;
	static int backKey = KeyEvent.VK_S;
	static int rightKey = KeyEvent.VK_D;
	static int sprintKey = KeyEvent.VK_CONTROL;
	static int sneakKey = KeyEvent.VK_SHIFT;
	static int jumpKey = KeyEvent.VK_SPACE;
	static int attackKey = InputEvent.BUTTON1_DOWN_MASK;
	static int useKey = InputEvent.BUTTON3_DOWN_MASK;
	
	public static Map<Integer, Integer> keyCodesHash;
	static{
		keyCodesHash = new HashMap<Integer, Integer>();
		keyCodesHash.put(0x01, 0x1B);
		keyCodesHash.put(0x02, 0x31);
		keyCodesHash.put(0x03, 0x32);
		keyCodesHash.put(0x04, 0x33);
		keyCodesHash.put(0x05, 0x34);
		keyCodesHash.put(0x06, 0x35);
		keyCodesHash.put(0x07, 0x36);
		keyCodesHash.put(0x08, 0x37);
		keyCodesHash.put(0x09, 0x38);
		keyCodesHash.put(0x0A, 0x39);
		keyCodesHash.put(0x0B, 0x30);
		keyCodesHash.put(0x0C, 0x2D);
		keyCodesHash.put(0x0D, 0x3D);
		keyCodesHash.put(0x0E, Character.getNumericValue('\b'));
		keyCodesHash.put(0x0F, Character.getNumericValue('\t'));
		keyCodesHash.put(0x10, 0x51);
		keyCodesHash.put(0x11, 0x57);
		keyCodesHash.put(0x12, 0x45);
		keyCodesHash.put(0x13, 0x52);
		keyCodesHash.put(0x14, 0x54);
		keyCodesHash.put(0x15, 0x59);
		keyCodesHash.put(0x16, 0x55);
		keyCodesHash.put(0x17, 0x49);
		keyCodesHash.put(0x18, 0x4F);
		keyCodesHash.put(0x19, 0x50);
		keyCodesHash.put(0x1A, 0x0207);
		keyCodesHash.put(0x1B, 0x020A);
		keyCodesHash.put(0x1C, Character.getNumericValue('\n'));
		keyCodesHash.put(0x1D, 0x11);
		keyCodesHash.put(0x1E, 0x41);
		keyCodesHash.put(0x1F, 0x53);
		keyCodesHash.put(0x20, 0x44);
		keyCodesHash.put(0x21, 0x46);
		keyCodesHash.put(0x22, 0x47);
		keyCodesHash.put(0x23, 0x48);
		keyCodesHash.put(0x24, 0x4A);
		keyCodesHash.put(0x25, 0x4B);
		keyCodesHash.put(0x26, 0x4C);
		keyCodesHash.put(0x27, 0x3B);
		keyCodesHash.put(0x28, 0xDE);
		keyCodesHash.put(0x29, 0);
		keyCodesHash.put(0x2A, 0x10);
		keyCodesHash.put(0x2B, Character.getNumericValue('\b'));
		keyCodesHash.put(0x2C, 0x5A);
		keyCodesHash.put(0x2D, 0x58);
		keyCodesHash.put(0x2E, 0x43);
		keyCodesHash.put(0x2F, 0x56);
		keyCodesHash.put(0x30, 0x42);
		keyCodesHash.put(0x31, 0x4E);
		keyCodesHash.put(0x32, 0x4D);
		keyCodesHash.put(0x33, 0x2C);
		keyCodesHash.put(0x34, 0x2E);
		keyCodesHash.put(0x35, 0x2F);
		keyCodesHash.put(0x36, 0x10);
		keyCodesHash.put(0x37, 0x6A);
		keyCodesHash.put(0x38, 0x12);
		keyCodesHash.put(0x39, 0x20);
		keyCodesHash.put(0x3A, 0x14);
		keyCodesHash.put(0x3B, 0x70);
		keyCodesHash.put(0x3C, 0x71);
		keyCodesHash.put(0x3D, 0x72);
		keyCodesHash.put(0x3E, 0x73);
		keyCodesHash.put(0x3F, 0x74);
		keyCodesHash.put(0x40, 0x75);
		keyCodesHash.put(0x41, 0x76);
		keyCodesHash.put(0x42, 0x77);
		keyCodesHash.put(0x43, 0x78);
		keyCodesHash.put(0x44, 0x79);
		keyCodesHash.put(0x45, 0x90);
		keyCodesHash.put(0x46, 0x91);
		keyCodesHash.put(0x47, 0x67);
		keyCodesHash.put(0x48, 0x68);
		keyCodesHash.put(0x49, 0x69);
		keyCodesHash.put(0x4A, 0x6D);
		keyCodesHash.put(0x4B, 0x64);
		keyCodesHash.put(0x4C, 0x65);
		keyCodesHash.put(0x4D, 0x66);
		keyCodesHash.put(0x4E, 0x6B);
		keyCodesHash.put(0x4F, 0x61);
		keyCodesHash.put(0x50, 0x62);
		keyCodesHash.put(0x51, 0x63);
		keyCodesHash.put(0x52, 0x60);
		keyCodesHash.put(0x53, 0x6E);
		keyCodesHash.put(0x57, 0x7A );
		keyCodesHash.put(0x58, 0x7B);
		keyCodesHash.put(0x64, 0xF000);
		keyCodesHash.put(0x65, 0xF001);
		keyCodesHash.put(0x66, 0xF002);
		keyCodesHash.put(0x67, 0xF003);
		keyCodesHash.put(0x68, 0xF004);
		keyCodesHash.put(0x69, 0xF005);
		keyCodesHash.put(0x70, 0x0015);
		keyCodesHash.put(0x71, 0xF006);
		keyCodesHash.put(0x79, 0x001C);
		keyCodesHash.put(0x7B, 0x001D);
		keyCodesHash.put(0x7D, 0);
		keyCodesHash.put(0x8D, 0x3D);
		keyCodesHash.put(0x90, 0x0202);
		keyCodesHash.put(0x91, 0x0200);
		keyCodesHash.put(0x92, 0x0201);
		keyCodesHash.put(0x93, 0x020B);
		keyCodesHash.put(0x94, 0x0019);
		keyCodesHash.put(0x95, 0xFFC8);
		keyCodesHash.put(0x96, 0);
		keyCodesHash.put(0x97, 0);
		keyCodesHash.put(0x9C, Character.getNumericValue('\n'));
		keyCodesHash.put(0x9D, 0x11);
		keyCodesHash.put(0xA7, 0);
		keyCodesHash.put(0xB3, 0x2C);
		keyCodesHash.put(0xB5, 0x6F);
		keyCodesHash.put(0xB7, 0);
		keyCodesHash.put(0xB8, 0x020D);
		keyCodesHash.put(0xC4, 0);
		keyCodesHash.put(0xC5, 0x13);
		keyCodesHash.put(0xC7, 0x24);
		keyCodesHash.put(0xC8, 0x26);
		keyCodesHash.put(0xC9, 0x21);
		keyCodesHash.put(0xCB, 0x25);
		keyCodesHash.put(0xCD, 0x27);
		keyCodesHash.put(0xCF, 0x23);
		keyCodesHash.put(0xD0, 0x28);
		keyCodesHash.put(0xD1, 0x22);
		keyCodesHash.put(0xD2, 0x9B);
		keyCodesHash.put(0xD3, 0x7F);
        keyCodesHash.put(0xDA, 0x0C);
        keyCodesHash.put(0xDB, 0x020C);
        keyCodesHash.put(-98, MouseEvent.BUTTON2_DOWN_MASK);
        keyCodesHash.put(-99, MouseEvent.BUTTON3_DOWN_MASK);
        keyCodesHash.put(-100, MouseEvent.BUTTON1_DOWN_MASK);
	}
	
	

	public static void readConfig() {
			try {
				BufferedReader in = new BufferedReader(new FileReader(Macro.WORKING_DIR + "config.txt"));
				in.readLine();
				String dir = in.readLine();
				in.readLine();
				String sensitivity = in.readLine();
				try {
					mouseSensitivityPercent = Integer.parseInt(sensitivity.substring(sensitivity.indexOf(':') + 1));
				} catch (NumberFormatException e) {}
				in.close();
				
				 String optPath = dir.substring(dir.indexOf(':') + 1) + File.separator + "options.txt";
				in = new  BufferedReader(new FileReader(optPath));
				while (in.ready()) {
					int var;
					String l = in.readLine();
					if (l.startsWith("mouseSensitivity")) {
						mouseSensitivity = Double.parseDouble(l.substring(l.indexOf(":") + 1));
						
					} else if (l.startsWith("key_key.")) {
						l = l.substring(l.indexOf(".") + 1);
						switch (l.substring(0, l.indexOf(":"))) {
						case "attack":
							var = Integer.parseInt(l.substring(l.indexOf(":") + 1));
							if (var > 0) {attackKey = var;}
							break;
						case "use":
							var = Integer.parseInt(l.substring(l.indexOf(":") + 1));
							if (var > 0) {useKey = var;}
							break;
						case "forward":
							var = keyCodesHash.get(Integer.parseInt(l.substring(l.indexOf(":") + 1)));
							forwardKey = var;
							break;
						case "left":
							var = keyCodesHash.get(Integer.parseInt(l.substring(l.indexOf(":") + 1)));
							leftKey = var;
							break;
						case "back":
							var = keyCodesHash.get(Integer.parseInt(l.substring(l.indexOf(":") + 1)));
							backKey = var;
							break;
						case "right":
							var = keyCodesHash.get(Integer.parseInt(l.substring(l.indexOf(":") + 1)));
							rightKey = var;
							System.out.println("Right mouse code: " + rightKey);
							break;
						case "jump":
							var = keyCodesHash.get(Integer.parseInt(l.substring(l.indexOf(":") + 1)));
							jumpKey = var;
							break;
						case "sneak":
							var = keyCodesHash.get(Integer.parseInt(l.substring(l.indexOf(":") + 1)));
							sneakKey = var;
							break;
						case "sprint":
							var = keyCodesHash.get(Integer.parseInt(l.substring(l.indexOf(":") + 1)));
							sprintKey = var;
							System.out.println("Sprint key code: " + var);
							break;
						default:
							break;
						}
					}
				}
				
			 System.out.println(mouseSensitivity);
			 if(mouseSensitivityPercent != -1) {
				 Helper helper = new Helper();
				 mouseSensitivity = helper.convertmouseSensitivity(mouseSensitivityPercent);
			 }
			 System.out.println("Mouse sensitivity: " + mouseSensitivity);
			 Macro.currentXPixels = Main.calcFullX();
				
			} catch (FileNotFoundException e) {
				CommandHelper.printError("The config file could not be found in the directory. Default state will be applied.");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	}
}
