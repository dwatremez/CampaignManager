package vo.campaignmanager.core;

import java.io.Serializable;

public class CPlace implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int 			id;
	public String 		name;
	public String		emplacement;
	public String		description;	
	
	@Override
	public String toString() {
		return " - " + name;
	}
}
