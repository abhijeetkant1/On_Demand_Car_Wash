package com.cg.services;

import com.cg.models.Washers;
import java.util.List;

public interface WasherService {

	public void save(Washers washer);

	public void updateWasherDetails( Washers washer);

	public List<Washers> getWashers();

	void deleteWasher(int id);

	public int getSequenceNumber(String sequenceName);
	public  Washers viewWasher(int id);
	//Washers updateWasherDetails(Washers washer);
}
