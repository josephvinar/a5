package a5jedi;
import java.util.Iterator;

public class PixelIterator implements Iterator<Pixel>{
	
	private Picture pic;
	private int cur_idx;
	
	public PixelIterator(Picture pic){
		this.pic = pic;
		cur_idx = 0;
	}
	
	public boolean hasNext(){
		if (cur_idx >= pic.getHeight() * pic.getWidth()) return false;
		else{
			return true;
         }
	}
	
	public Pixel next(){
		if (!hasNext()) {
            throw new RuntimeException("No next pixel in iteration.");
		}
		Pixel p = pic.getPixel(cur_idx%pic.getWidth(), cur_idx/pic.getWidth());
    	cur_idx += 1;
    	return p;
	}
	public void remove(){
		throw new UnsupportedOperationException("The remove() method is not supported :(");		
	}
}
