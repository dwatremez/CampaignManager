package vo.campaignmanager.core;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class CScene extends CEvent implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String theme;
	public String ambiance;
	public int irlDuration;
	public int igDuration;
	
	public int state;
	public static final int STATE_CANCELED = -1, STATE_COMPLETED = 1, STATE_CREATED = 0, STATE_ACTIVE = 2;
	
	public Set<Integer> nextScenes = new HashSet<Integer>();
	
	@Override
	public String toString() {
		return " - " + name;
	}
	
}
