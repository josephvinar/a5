package a5novice;

public class SubPictureImpl extends AnyPicture implements SubPicture{
	
	Picture source;
	int xOffset;
	int yOffset;


	public SubPictureImpl(Picture source, int xOffset, int yOffset, int width, int height){
		super (width, height);
		
		if (source == null){
			throw new IllegalArgumentException("The source photo you inputted appears to be null");
		} else{
			this.source = source;
		}
		
		if((width + xOffset) > source.getWidth() || xOffset < 0){
			throw new IllegalArgumentException("The xOffset value is out of bounds");
		} else{
			this.xOffset = xOffset;
		}
		
		if((height + yOffset) > source.getHeight() || yOffset < 0){
			throw new IllegalArgumentException("The yOffset value is out of bounds");
		} else{
			this.yOffset = yOffset;
		}
		
		if(width < 0 || height < 0){
			throw new IllegalArgumentException("The height or width is negative");
		} else{
			this.width = width;
			this.height = height;
		}
		
//		if(width > (source.getWidth() - xOffset) || width < 0){
//			throw new IllegalArgumentException("The width value is out of bounds");
//		}
//		else{
//			this.width = width;
//		}
//		
//		if(height > (source.getHeight() - yOffset) || height < 0){
//			throw new IllegalArgumentException("The height value is out of bounds");
//		}
//		else{
//			this.height = height;
//		}
	}
	
//	Any interactions with a SubPicture object to get/set pixel information should be "delegated" to the 
//	underlying source Picture object. This means that a SubPicture object will need to "translate" any 
//	coordinate information using xOffset and yOffset and will not store its own pixel information.
	
	public void setPixel(int x, int y, Pixel p) {
		source.setPixel((x + xOffset), (y + yOffset), p); 
	}

	public Pixel getPixel(int x, int y) {
		return source.getPixel(x + xOffset, y + yOffset); //derp not sure if y should be added or subtracted
	}
	
	
	
//	public SubPicture extract(int xOffset, int yOffset, int width, int height){
//		SubPicture shot;
//		shot = new SubPictureImpl(this, xOffset, yOffset, width, height);
//		return shot;
//	}

//	@Override
//	public int getWidth() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int getHeight() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//

	public int countRange(double low, double high) {
		return source.countRange(low, high);
	}


	public void print() {
		source.print();
	}

	public Picture getSource() {
		return source;
	}

	public int getXOffset() {
		return xOffset;
	}


	public int getYOffset() {
		return yOffset;
	}


}
