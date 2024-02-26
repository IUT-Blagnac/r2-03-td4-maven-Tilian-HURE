package test;

import lesschtroumpfs.Schtroumpf;

public class MainSchtroumpf {

	public static void main (String[] args) {
		
		/*Schtroumpf grognon*/
		Schtroumpf grognon = new Schtroumpf("Grognon", 135);
		grognon.sePresenter();
		grognon.allerTravailler();
		grognon.sePresenter();
		grognon.manger(10);
		grognon.sePresenter();
		grognon.anniversaire();
		grognon.sePresenter();
	}

}
