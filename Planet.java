
public class Planet {
	double myXPos;
	double myYPos;
	double myXVel;
	double myYVel;
	double myMass;
	String myFileName = "";
	
	public Planet(double xP, double yP,double xV, double yV ,double m, String img){
		this.myXPos = xP;
		this.myYPos = yP;
		this.myXVel = xV;
		this.myYVel = yV;
		this.myMass = m;
		this.myFileName = img;
	}
	
	public Planet(Planet p){
		myXPos = p.myXPos;
		myYPos = p.myYPos;
		myXVel = p.myXVel;
		myYVel = p.myYVel;
		myMass = p.myMass;
		myFileName = p.myFileName;
	}
	
	public double calcDistance(Planet otherPlanet){
		return Math.sqrt((otherPlanet.myXPos - this.myXPos)*(otherPlanet.myXPos - this.myXPos)
				+ (otherPlanet.myYPos - this.myYPos)*(otherPlanet.myYPos - this.myYPos));
	}
	
	public double calcForceExertedBy(Planet otherPlanet){
		double G = 6.67 * Math.pow(10, -11);
		return G * otherPlanet.myMass * this.myMass / (calcDistance(otherPlanet)*(calcDistance(otherPlanet)));
	}
	
	public double calcForceExertedByX(Planet otherPlanet){
		return calcForceExertedBy(otherPlanet) * (otherPlanet.myXPos - this.myXPos) / (calcDistance(otherPlanet));
	}
	
	public double calcForceExertedByY(Planet otherPlanet){
		return calcForceExertedBy(otherPlanet) * (otherPlanet.myYPos - this.myYPos) / (calcDistance(otherPlanet));
	}
	public double calcNetForceExertedByX(Planet [] planets){
		double xNetForce = 0;
		 for (Planet current : planets) {
	            if (current.myXPos != this.myXPos || current.myYPos != this.myYPos) {
	                xNetForce += this.calcForceExertedByX(current);
	            }
	        }
		return xNetForce;
	}
	public double calcNetForceExertedByY(Planet [] planets){
		double yNetForce = 0;
		 for (Planet current : planets) {
	            if (current.myXPos != this.myXPos || current.myYPos != this.myYPos) {
	                yNetForce += this.calcForceExertedByY(current);
	            }
	        }
		return yNetForce;
	}
	
	public void update(double seconds, double myXForce, double myYForce){
		double xAcc = myXForce / this.myMass;
		double yAcc = myYForce / this.myMass;
		this.myXVel = this.myXVel + (seconds * xAcc);
		this.myYVel = this.myYVel + (seconds * yAcc);
		this.myXPos = this.myXPos + (seconds * this.myXVel);
		this.myYPos = this.myYPos + (seconds * this.myYVel);	
	}
	
	
}
	
