package jfws.gameplay.economy.resources;

public class ResourceTransfer
{
	private Resource resource_;
	private double amount_per_unit_;
	
	public ResourceTransfer(Resource resource, double amount_per_unit)
	{
		resource_ = resource;
		amount_per_unit_ = amount_per_unit;
	}
	
	public Resource getResource()
	{
		return resource_;
	}
	
	public double getAmountPerUnit()
	{
		return amount_per_unit_;
	}
	
	public double getAmount(double units)
	{
		if(units <= 0.0)
			throw new IllegalArgumentException("Units must be greater than 0!");
		
		return amount_per_unit_ * units;
	}
}
