package beans;

public class CalculatorBean 
{
    int xvalue = 0;
    int yvalue = 0;
    int xstatus = 1;  // 1: success 0: error
	int ystatus = 1;  // 1: success 0: error

	public CalculatorBean() {
        // Default constructor.
    }
	
    public void setXvalue(String sx)
    {
    	try
    	{
    		xvalue = Integer.parseInt(sx);
    	}
    	catch(Exception e)
    	{
    		xstatus = 0;
    	}
    }
    
    public int getXvalue()
    {
    	return xvalue;
    }   
	
    public int getXstatus()
    {
    	return xstatus;
    }   
		
    public int getYstatus()
    {
    	return ystatus;
    }   
    
    public void setYvalue(String sy)
    {
    	try
    	{
    		yvalue = Integer.parseInt(sy);
    	}
    	catch(Exception e)
    	{
    		ystatus = 0;
    	}    	
    }
    
    public int getYvalue()
    {
    	return yvalue;
    }  
        
    public int getSum() 
    {
        return xvalue + yvalue; 
    }
    
    public boolean xisValid() 
    {
        return xstatus == 1; 
    }
	public boolean yisValid() 
    {
        return ystatus == 1; 
    }
}
