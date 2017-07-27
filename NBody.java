import java.util.*;
import java.io.*;

public class NBody {
	
	public static void main(String[] args){
		double T = 157788000.0;
		double dt = 25000.0;
		String pfile = "data/planets.txt";
		
		double uniRadius = readRadius(pfile);
		Planet[] nPlanet = readPlanets(pfile);
		double[] xForce =  new double[nPlanet.length];
		double[] yForce = new double[nPlanet.length];
		
		double time = 0;
		StdAudio.play("audio/2001.mid");

		while(time <= T){

		for(int i = 0; i< nPlanet.length; i ++){
			xForce[i] = nPlanet[i].calcNetForceExertedByX(nPlanet);
			yForce[i] = nPlanet[i].calcNetForceExertedByY(nPlanet);
		}
			for(int i = 0; i< nPlanet.length; i ++){
			nPlanet[i].update(dt, xForce[i], yForce[i]);
			}
			StdDraw.setScale(-uniRadius, uniRadius);
			StdDraw.picture(0, 0,"images/starfield.jpg");
			for(int k =0; k < nPlanet.length; k++){
				StdDraw.picture(nPlanet[k].myXPos,nPlanet[k].myYPos , "images/"+nPlanet[k].myFileName);
			}
			 StdDraw.show(10);
			
			time = time + dt;
		}
		
		System.out.printf("%d\n", nPlanet.length);
		System.out.printf("%.2e\n", uniRadius);
		for (int i = 0; i < nPlanet.length; i++) {
		    System.out.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		                      nPlanet[i].myXPos, nPlanet[i].myYPos, 
		                      nPlanet[i].myXVel, nPlanet[i].myYVel, 
		                      nPlanet[i].myMass, nPlanet[i].myFileName);	
		}
	}
	
	public static double readRadius(String fname){
		try{
			Scanner scan = new Scanner(new File(fname));
			double nPlanet = scan.nextDouble();
			double radius = scan.nextDouble();
			scan.close();
			return radius;
		}
		catch(Exception FileNotFoundException){
			return 0;
		}
	}
		
	public static Planet[] readPlanets(String fname) {
		try {
			Scanner scan = new Scanner(new File(fname));
			int nPla = scan.nextInt();
			scan.next();
			Planet[] pOne = new Planet[nPla];
				for (int i = 0; i < nPla; i++) {
					Planet pThree = new Planet(scan.nextDouble(),scan.nextDouble(),scan.nextDouble(), scan.nextDouble(), scan.nextDouble(),scan.next());
					pOne[i] = pThree;
				}
			scan.close();
			return pOne;

		} catch (Exception FileNotFoundException) {
			Planet[] pTwo = new Planet[0];
			return pTwo;
		}

	}

}
