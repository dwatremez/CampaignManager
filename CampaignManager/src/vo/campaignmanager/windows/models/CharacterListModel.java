package vo.campaignmanager.windows.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.swing.DefaultListModel;

import vo.campaignmanager.DataManager;
import vo.campaignmanager.DataManager.DataManagerListener;
import vo.campaignmanager.core.CCharacter;

public class CharacterListModel extends DefaultListModel implements DataManagerListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Set<Integer> _characters = null;
	
	public CharacterListModel(){
		refresh();
	}
	
	public CharacterListModel(Set<Integer> _participants){
		_characters = new HashSet<Integer>();
		_characters.addAll(_participants);
		refresh();
	}
	
	@Override
	public void onDataChanged() {

		refresh();
		
	}

	private void refresh() {

		
		clear();
		Collection<CCharacter> scn = DataManager.getInstance().getCharacters();
		if (_characters == null){
			for ( CCharacter sc : scn){
				addElement(sc);
			}
		} else {
			for ( CCharacter sc : scn){
				if (_characters.contains(sc.id))
					addElement(sc);
			}
		}
		
	}

	 
	
	
}
