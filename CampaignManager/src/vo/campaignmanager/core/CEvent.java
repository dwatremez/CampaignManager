package vo.campaignmanager.core;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public abstract class CEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Les variables principales
	public int 			id;
	public String		name;
	public boolean		isActive;
	
	// La durée de l'événement
	public int  timeType;
	public static final int TIME_INSTANT = 1, TIME_LONG = 2;
	public Date startTime;
	public Date endTime;
	
	// Les participants, lieux;
	public int place;
	public Set<Integer> participants = new HashSet<Integer>();
	
	// Variables de texte
	
	public String		description;
	public String		summary;
	
	public String getName(){	
		return name;
	}
	
	
}
