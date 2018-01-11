package pt.sipa.controller;

import java.io.FileNotFoundException;

import pt.sipa.view.Login;



public class Init {

	public static void main(String[] args) {
		// 1.   load
				try {
					Sipa.load();
				} catch (FileNotFoundException e) {
					System.out.println(e.getMessage());
				}
				
				// 2. 1 JFrame
				Login f = new Login();
				f.setVisible(true);
				
				
	}
}
	


