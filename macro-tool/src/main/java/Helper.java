import java.util.HashMap;
import java.util.Map;

public class Helper {
	public static int[] outputKey = {Config.forwardKey, Config.leftKey, Config.backKey, Config.rightKey, Config.sprintKey, Config.sneakKey, Config.jumpKey, 
			Config.attackKey, Config.useKey};
	public static int actualMouseSensitivity;
	public static Map<Integer, Integer> sensitivityHash;
	static{
		sensitivityHash = new HashMap<Integer, Integer>();
		sensitivityHash.put(0, 0);
		sensitivityHash.put(1, 1);
		sensitivityHash.put(2, 2);
		sensitivityHash.put(4, 3);
		sensitivityHash.put(5, 4);
		sensitivityHash.put(7, 5);
		sensitivityHash.put(8, 6);
		sensitivityHash.put(9, 7);
		sensitivityHash.put(11, 8);
		sensitivityHash.put(12, 9);
		sensitivityHash.put(14, 10);
		sensitivityHash.put(15, 11);
		sensitivityHash.put(16, 12);
		sensitivityHash.put(18, 13);
		sensitivityHash.put(19, 14);
		sensitivityHash.put(21, 15);
		sensitivityHash.put(22, 16);
		sensitivityHash.put(23, 17);
		sensitivityHash.put(25, 18);
		sensitivityHash.put(26, 19);
		sensitivityHash.put(28, 20);
		sensitivityHash.put(29, 21);
		sensitivityHash.put(30, 22);
		sensitivityHash.put(32, 23);
		sensitivityHash.put(33, 24);
		sensitivityHash.put(35, 25);
		sensitivityHash.put(36, 26);
		sensitivityHash.put(38, 27);
		sensitivityHash.put(39, 28);
		sensitivityHash.put(40, 29);
		sensitivityHash.put(42, 30);
		sensitivityHash.put(43, 31);
		sensitivityHash.put(45, 32);
		sensitivityHash.put(46, 33);
		sensitivityHash.put(47, 34);
		sensitivityHash.put(49, 35);
		sensitivityHash.put(50, 36);
		sensitivityHash.put(52, 37);
		sensitivityHash.put(53, 38);
		sensitivityHash.put(54, 39);
		sensitivityHash.put(56, 40);
		sensitivityHash.put(57, 41);
		sensitivityHash.put(59, 42);
		sensitivityHash.put(60, 43);
		sensitivityHash.put(61, 44);
		sensitivityHash.put(63, 45);
		sensitivityHash.put(64, 46);
		sensitivityHash.put(66, 47);
		sensitivityHash.put(67, 48);
		sensitivityHash.put(69, 49);
		sensitivityHash.put(70, 50);
		sensitivityHash.put(71, 51);
		sensitivityHash.put(73, 52);
		sensitivityHash.put(74, 53);
		sensitivityHash.put(76, 54);
		sensitivityHash.put(77, 55);
		sensitivityHash.put(78, 56);
		sensitivityHash.put(80, 57);
		sensitivityHash.put(81, 58);
		sensitivityHash.put(83, 59);
		sensitivityHash.put(84, 60);
		sensitivityHash.put(85, 61);
		sensitivityHash.put(87, 62);
		sensitivityHash.put(88, 63);
		sensitivityHash.put(90, 64);
		sensitivityHash.put(91, 65);
		sensitivityHash.put(92, 66);
		sensitivityHash.put(94, 67);
		sensitivityHash.put(95, 68);
		sensitivityHash.put(97, 69);
		sensitivityHash.put(98, 70);
		sensitivityHash.put(100, 71);
		sensitivityHash.put(101, 72);
		sensitivityHash.put(102, 73);
		sensitivityHash.put(104, 74);
		sensitivityHash.put(105, 75);
		sensitivityHash.put(107, 76);
		sensitivityHash.put(108, 77);
		sensitivityHash.put(109, 78);
		sensitivityHash.put(111, 79);
		sensitivityHash.put(112, 80);
		sensitivityHash.put(114, 81);
		sensitivityHash.put(115, 82);
		sensitivityHash.put(116, 83);
		sensitivityHash.put(118, 84);
		sensitivityHash.put(119, 85);
		sensitivityHash.put(121, 86);
		sensitivityHash.put(122, 87);
		sensitivityHash.put(123, 88);
		sensitivityHash.put(125, 89);
		sensitivityHash.put(126, 90);
		sensitivityHash.put(128, 91);
		sensitivityHash.put(129, 92);
		sensitivityHash.put(130, 93);
		sensitivityHash.put(132, 94);
		sensitivityHash.put(133, 95);
		sensitivityHash.put(135, 96);
		sensitivityHash.put(136, 97);
		sensitivityHash.put(138, 98);
		sensitivityHash.put(139, 99);
		sensitivityHash.put(140, 100);
		sensitivityHash.put(142, 101);
		sensitivityHash.put(143, 102);
		sensitivityHash.put(145, 103);
		sensitivityHash.put(146, 104);
		sensitivityHash.put(147, 105);
		sensitivityHash.put(149, 106);
		sensitivityHash.put(150, 107);
		sensitivityHash.put(152, 108);
		sensitivityHash.put(153, 109);
		sensitivityHash.put(154, 110);
		sensitivityHash.put(156, 111);
		sensitivityHash.put(157, 112);
		sensitivityHash.put(159, 113);
		sensitivityHash.put(160, 114);
		sensitivityHash.put(161, 115);
		sensitivityHash.put(163, 116);
		sensitivityHash.put(164, 117);
		sensitivityHash.put(166, 118);
		sensitivityHash.put(167, 119);
		sensitivityHash.put(169, 120);
		sensitivityHash.put(170, 121);
		sensitivityHash.put(171, 122);
		sensitivityHash.put(173, 123);
		sensitivityHash.put(174, 124);
		sensitivityHash.put(176, 125);
		sensitivityHash.put(177, 126);
		sensitivityHash.put(178, 127);
		sensitivityHash.put(180, 128);
		sensitivityHash.put(181, 129);
		sensitivityHash.put(183, 130);
		sensitivityHash.put(184, 131);
		sensitivityHash.put(185, 132);
		sensitivityHash.put(187, 133);
		sensitivityHash.put(188, 134);
		sensitivityHash.put(190, 135);
		sensitivityHash.put(191, 136);
		sensitivityHash.put(192, 137);
		sensitivityHash.put(194, 138);
		sensitivityHash.put(195, 139);
		sensitivityHash.put(197, 140);
		sensitivityHash.put(198, 141);
		sensitivityHash.put(200, 142);
	}
	public Helper() {
	}
	
	public double convertmouseSensitivity(int percent) {
		int sensitivity = sensitivityHash.get(percent);
		if (percent % 100 == 0) {
			return (double)Math.round(percent / 200d * 10d) / 10d;
		} else if (percent < 50){
			return sensitivity * (0.5 / 71);
		} else if (percent < 100) {
			return 0.5 - ((71 - sensitivity) * (0.5 / 71));
		}else if (percent < 150) {
			return 0.5 + ((sensitivity - 71) * (0.5 / 71));
		}else if (percent < 200) {
			return 1.0 - ((142 - sensitivity) * (0.5 / 71));
		}
		return 0.0;
	}

}
