package a5adept;
import java.util.Iterator;

public class SampleIterator implements Iterator<Pixel>{
	
	private Picture pic; //do i need to construct a new picture
	private int cur_idx;
	private int init_x;
	private int init_y;
	private int dx;
	private int dy;
	//public Iterator<Pixel> sample(int init_x, int init_y, int dx, int dy);
	
	
	public SampleIterator(int init_x, int init_y, int dx, int dy){
		this.init_x = init_x;
		this.init_y = init_y;
		this.dx = dx;
		this.dy = dy;
		cur_idx = this.init_x + (this.init_y * pic.getWidth());
	}
	
	public boolean hasNext(){
		if (cur_idx >= pic.getHeight() * pic.getWidth()) return false;
		
		else if(dy%(cur_idx / pic.getWidth()) == 0 && (cur_idx%pic.getWidth())%dx == 0){
			return true;
		}
		else{
			cur_idx++;
			return false;
         }
	}
	
	public Pixel next(){
		if (!hasNext()) {
            throw new RuntimeException("No next pixel in iteration.");
		}
		else{
			Pixel p = pic.getPixel(cur_idx%pic.getWidth(), cur_idx/pic.getWidth());
			cur_idx += 1;
			return p;
		}
	}
	public void remove(){
		throw new UnsupportedOperationException("The remove() method is not supported :(");		
	}
}
