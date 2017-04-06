package chap11.ObjectClass;

public class Rectangle implements Cloneable{
	int width, height;

	public Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		try{
		return super.clone();
		}catch(CloneNotSupportedException e){
			return null;
		}
	}
	
	
}
