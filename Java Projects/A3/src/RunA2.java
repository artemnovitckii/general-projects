/*
 * Artem Novitckii
 * anov099
 * 207428057
 */

import javax.swing.SwingUtilities;

public class RunA2 implements Runnable {
	public void run() {
		A2 run = new A2();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new RunA2());
	}

}