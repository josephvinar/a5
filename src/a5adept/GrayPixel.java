package a5adept;



public class GrayPixel implements Pixel{
	private double intensity;

	public GrayPixel(double intensity){
		if (intensity < 0.0 || intensity > 1.0){
			throw new RuntimeException("Explanation string");
		}
		this.intensity = intensity;
	}
	
	
	public char getChar(){
		
		if (intensity < 0.1 && intensity >= 0.0){
			return '#';
		}
		else if(intensity < 0.2 && intensity >= 0.1){
			return 'M';
		}
		else if(intensity < 0.3 && intensity >= 0.2){
			return 'X';
		}
		else if(intensity < 0.4 && intensity >= 0.3){
			return 'D';
		}
		else if(intensity < 0.5 && intensity >= 0.4){
			return '<';
		}
		else if(intensity < 0.6 && intensity >= 0.5){
			return '>';
		}
		else if(intensity < 0.7 && intensity >= 0.6){
			return 's';
		}
		else if (intensity < 0.8 && intensity >= 0.7){
			return ':';
		}
		else if (intensity < 0.9 && intensity >= 0.8){
			return '-';
		}
		return ' ';
	}	


	public double getRed() {
		return intensity;
	}


	public double getGreen() {
		return intensity;
	}


	public double getBlue() {
		return intensity;
	}


	public double getIntensity() {
		return intensity;
	}


	public Pixel blend(Pixel p, double weight){ //p is the pixel we're mixing with
		
		double redHolder = p.getRed() - ((p.getRed() - this.getRed()) * weight); //0.0 = p
		double greenHolder = p.getGreen() - ((p.getGreen() - this.getGreen()) * weight);
		double blueHolder = p.getBlue() - ((p.getBlue() - this.getBlue()) * weight);
		
		Pixel n = new ColorPixel(redHolder, greenHolder, blueHolder); //new pixel
		
		return n;
	}
	
	public Pixel lighten(double factor){ 
		Pixel white = new ColorPixel(1.0,1.0,1.0);
		
		return blend(white, 1- factor);
	}
	
	public Pixel darken(double factor){ 
		Pixel black = new ColorPixel(0.0,0.0,0.0);
		return blend(black, 1 -factor);
	}

}
