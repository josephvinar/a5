package a5jedi;

import java.util.Iterator;

public class PictureImpl extends AnyPicture implements Picture{
	
	private int width;
	private int height;
	
	private Pixel[][] pic;
	

	public PictureImpl(int width, int height){
		super(width, height);
		
		this.width = width;
		this.height = height;
		pic = new Pixel[width][height];
		for (int x = 0; x < this.width; x++){
			for (int y = 0; y < this.height; y++){
				pic[x][y]= new ColorPixel(1,1,1);
					
			}
		}
	}
	
	
//	public int getWidth() {
//		return this.width;
//	}
//
//	public int getHeight() {
//		return this.height;
//	}

//	public void setPixel(int x, int y, Pixel p) {
//		this.pic[x][y] = p;
//		
//	}
//	public void setPixel(Coordinate c, Pixel p){
//		this.pic[c.getX()][c.getY()] = p;
//	}
//
//	public Pixel getPixel(int x, int y) {
//		return this.pic[x][y];
//	}
//	public Pixel getPixel(Coordinate c){
//		return this.pic[c.getX()][c.getY()];
//	}

	public int countRange(double low, double high) {
		int counter = 0;
		
		for (int x = 0; x < this.width; x++){
			for (int y = 0; y < this.height; y++){
				if (low <= pic[x][y].getIntensity() && pic[x][y].getIntensity() <= high){
					counter++;
				}
			}
		}
		
		return counter;
	}


	public void print() {
		for (int x = 0; x < this.getWidth(); x++){
			for (int y = 0; y < this.getHeight(); y++){	
				System.out.print(this.pic[x][y].getChar());
			}
		}
		
	}
//	public SubPicture extract(int xOffset, int yOffset, int width, int height){
//		SubPicture shot;
//		shot = new SubPictureImpl(this, xOffset, yOffset, width, height);
//		return shot;
//	}


	@Override
	public Iterator<Pixel> sample(int init_x, int init_y, int dx, int dy) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Iterator<SubPicture> window(int window_width, int window_height) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Iterator<SubPicture> tile(int tile_width, int tile_height) {
		// TODO Auto-generated method stub
		return null;
	}

}





















