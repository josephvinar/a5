package a5novice;



public class ColorPixel implements Pixel{

	private double red;	//creates instance variables
	private double green;
	private double blue;

	public ColorPixel(double red, double green, double blue){
		
		if (red < 0.0 || red > 1.0){
			throw new RuntimeException("Explanation string");
		}
		this.red = red;
		
		if (green < 0.0 || green > 1.0){
			throw new RuntimeException("Explanation string");
		}
		this.green = green;
		
		if (blue < 0.0 || blue > 1.0){
			throw new RuntimeException("Explanation string");
		}
		this.blue = blue;
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
			
	public double getIntensity(){
		return (0.299*red) + (0.587*green) + (0.114*blue);
	}

	
	public double getRed(){
		return this.red;
	}
	public double getGreen(){
		return this.green;
	}
	public double getBlue(){
		return this.blue;
	}

	
	public void setRed(double red){
		this.red = constrain(red);
	}
	public void setGreen(double green){
		this.green = constrain(green);
	}
	public void setBlue(double blue){
		this.blue = constrain(blue);
	}

	public char getChar(){
		double intensity = getIntensity();
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

	public double constrain(double i){
		if (i < 0.0 || i > 1.0){
			throw new RuntimeException("Explanation string");
		}
		return i;
	}

}
