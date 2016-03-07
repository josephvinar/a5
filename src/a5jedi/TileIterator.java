package a5jedi;

import java.util.Iterator;

public class TileIterator implements Iterator<SubPicture>{
	private int tile_width;
	private int tile_height;
	private Picture pic;
	private int idx_x;
	private int idx_y;
	
	public TileIterator(int tile_width, int tile_height, Picture pic){
		this.tile_width = tile_width;
		this.tile_height = tile_width;
		idx_x = 0;
		idx_y = 0;
		this.pic = pic;
	}
	
	public boolean hasNext(){
		if((idx_y + tile_height -1) > pic.getHeight()){
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
		SubPicture holder = pic.extract(idx_x, idx_y, tile_width, tile_height);
		idx_x += tile_width;
		if((idx_x + tile_width - 1) >= pic.getWidth()){
			idx_y += tile_height;
			idx_x = 0;
		}
		return holder;		
	}
	
	public void remove(){
		throw new UnsupportedOperationException("The remove() method is not supported :(");		
	}
}
