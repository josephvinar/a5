package a5novice;

import java.util.Iterator;


public abstract class AnyPicture implements Picture{

	protected int width;
	protected int height;
	protected Pixel[][] pic;
	
	AnyPicture(int width, int height){
		this.height = height;
		this.width = width;
	}
	
	public Iterator<Pixel> iterator(){
		return new PixelIterator(this);
	}
	
	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}
	
	public SubPicture extract(int xOffset, int yOffset, int width, int height){
		SubPicture shot;
		shot = new SubPictureImpl(this, xOffset, yOffset, width, height);
		return shot;
	}
	
	public SubPicture extract(Coordinate corner_a, Coordinate corner_b){
		SubPicture shot;
		shot = new SubPictureImpl(this, corner_a.getX(), corner_a.getY(), corner_b.getX(), corner_b.getY());
		return shot;
	}
	
	public void setPixel(int x, int y, Pixel p) {
		this.pic[x][y] = p;
		
	}
	public void setPixel(Coordinate c, Pixel p){
		this.pic[c.getX()][c.getY()] = p;
	}

	public Pixel getPixel(int x, int y) {
		return this.pic[x][y];
	}
	public Pixel getPixel(Coordinate c){
		return this.pic[c.getX()][c.getY()];
	}
}
