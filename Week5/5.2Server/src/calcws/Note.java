package calcws;

import java.util.Date;

public class Note{
	
	private String text;
	private int id;
	private Date timeStamp;
	
	public Note(){
		text = "";
		id = 0;
		timeStamp = new Date();
	}
	
	public void setText(String tex){
		text = tex;
	}
	
	public void setId(int i){
		id = i;
	}
	
	public void setDate(Date stamp){
		timeStamp = stamp;
	}
	
	public String getText(){
		return text;
	}
	
	public int getId(){
		return id;
	}
	
	public Date getDate(){
		return timeStamp;
	}
}