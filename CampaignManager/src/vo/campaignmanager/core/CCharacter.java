package vo.campaignmanager.core;

import java.io.Serializable;

public class CCharacter implements ITimeline, Serializable {

	/*
	 * TODO G�rer le syst�me d'exp�rience
	 * TODO G�rer le syst�me d'attributs
	 * TODO Faire le constructeur / l'interface de cr�ation de personnage
	 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int 			id;
	public String 		name;
	public String		description;	
	public int			currentXP;
	public int			totalXP;
	
	@Override
	public String toString() {
		return " - " + name;
	}
}
