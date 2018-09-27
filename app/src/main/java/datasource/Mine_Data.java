package datasource;

public class Mine_Data {
	int     image;
	String  text;
	public Mine_Data(int image, String text) {
		super();
		this.image = image;
		this.text = text;
	}
	public int getImage() {
		return image;
	}
	public void setImage(int image) {
		this.image = image;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "Mine_Data [image=" + image + ", text=" + text + "]";
	}
	

}
