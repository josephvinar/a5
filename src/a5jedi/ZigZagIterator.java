package a5jedi;

import java.util.Iterator;

public class ZigZagIterator implements Iterator<Pixel>{
	
	private Picture pic;
	private int idx_x;
	private int idx_y;
//	private boolean fstTurn;
//	private boolean scdTurn;
	private boolean zig_up;

	
	public ZigZagIterator(Picture pic){
		this.pic = pic;
		idx_x = 0;
		idx_y = 0;
//		fstTurn = true;
//		scdTurn = false;
		zig_up = false;
	}

	public boolean hasNext() {
		if(idx_x * idx_y >= pic.getHeight()*pic.getWidth()){
			return false;
		}
		else{
			return true;
		}
	}

	public Pixel next() {
		 Coordinate holder = new Coordinate(idx_x, idx_y);
		 if(!hasNext()){
		 		throw new RuntimeException("This is not a next pixel :/");
		 }
		 if(idx_x == pic.getWidth() -1 && zig_up){
			 idx_y++;
			 zig_up = false;
		 }
		 else if(idx_y == pic.getHeight() - 1 && !zig_up){
			 idx_x++;
			 zig_up = true;
		 }
		 else if(idx_y == 0 && idx_x %2 == 0){
			 idx_x++;
			 zig_up = false;
		 }
		 else if(idx_x == 0 && idx_y % 2 == 1){
			 idx_y++;
			 zig_up = true;
		 }
		 else if(!zig_up){
			 idx_y++;
			 idx_x--;
		 }
		 else if(zig_up){
			 idx_x++;
			 idx_y--;
		 }
		 return pic.getPixel(holder);
	}
		
////	Other implementation	
//		if(!hasNext()){
//			throw new RuntimeException("There isn't a next pixel :/");
//		}
//		if(idx_y == 0 && idx_x == pic.getWidth() - 1){
//			scdTurn = true;
//		}
//		if(idx_y == 0){
//			Coordinate holder = new Coordinate(idx_x, idx_y);
//			if(fstTurn){
//				idx_x++;
//				fstTurn = false;	
//			}
//			else if(scdTurn){
//				idx_y++;
//				scdTurn = false;
//			}
//			else{
//				idx_x--;
//				idx_y++;
//				fstTurn = true;
//			}
//			zig_up = false;
//			return pic.getPixel(holder);
//		}
//		
//		else if(idx_x == 0){
//			Coordinate holder = new Coordinate(idx_x, idx_y);
//			if(fstTurn){
//				idx_y--;
//				fstTurn = false;
//			} 
//			else{
//				idx_x++;
//				idx_y--;
//				fstTurn = true;
//			}
//			zig_up = true;
//			return pic.getPixel(holder);
//		}
//		else if(idx_x == pic.getWidth() - 1){	//turning point is (pic.getWidth(),0)
//			Coordinate holder = new Coordinate(idx_x, idx_y);
//			if(scdTurn){
//				idx_y++;
//				scdTurn = false;
//			}else{
//				idx_x--;
//				idx_y++;
//				scdTurn = true;
//				zig_up = false;
//			}
//			return pic.getPixel(holder);
//		}
//		else if(idx_y == pic.getHeight() - 1){
//			if(scdTurn){
//				idx_x++;
//				scdTurn = false;
//			}else{
//				idx_x++;
//				idx_y--;
//				scdTurn = true;
//				zig_up = true;
//			}
//		}
//		else if(!zig_up){
//			Coordinate holder = new Coordinate(idx_x, idx_y);
//			idx_x--;
//			idx_y++;
//			return pic.getPixel(holder);
//		}
//		else if(zig_up){
//			Coordinate holder = new Coordinate(idx_x, idx_y);
//			idx_x++;
//			idx_y--;
//			return pic.getPixel(holder);
//		}
//		return pic.getPixel(idx_x,idx_y);
//	}
	
	public void remove(){
		throw new UnsupportedOperationException("The remove() method is not supported :(");		
	}

	
}
