package a5jedi;

import java.util.Iterator;

public class WindowIterator implements Iterator<SubPicture>{
	
	private int window_width;
	private int window_height;
	private int idx_x;
	private int idx_y;
	private Picture pic;
	
	public WindowIterator(int window_width, int window_height, Picture pic){
		this.window_width = window_width;
		this.window_height = window_height;
		this.idx_x = 0;
		this.idx_y = 0;
		this.pic = pic;
	}
	
	public boolean hasNext(){
		if(idx_y + window_height -1 > pic.getHeight()){
			return false;
		}
		else{
			return true;
		}
	}
	
	public SubPicture next(){
		if(!hasNext()){
			throw new RuntimeException("No next SubPicture available");
		}
		SubPicture holder = pic.extract(idx_x, idx_y, window_width, window_height);
		if(idx_x + 1 > pic.getWidth()){
			idx_x = 0;
			idx_y += window_height;
		}
		return holder;
	}
	public void remove(){
		throw new UnsupportedOperationException("The remove() method is not supported :(");		
	}
	
}
