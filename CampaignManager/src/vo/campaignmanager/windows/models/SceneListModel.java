package vo.campaignmanager.windows.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.DefaultListModel;

import vo.campaignmanager.DataManager;
import vo.campaignmanager.DataManager.DataManagerListener;
import vo.campaignmanager.core.CScene;

public class SceneListModel extends DefaultListModel implements DataManagerListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Collection<Integer> _scenes = new ArrayList<Integer>();
	
	public SceneListModel(){
		refresh();
	}
	
	@Override
	public void onDataChanged() {

		refresh();
		
	}

	private void refresh() {

		clear();
		Collection<CScene> scn = DataManager.getInstance().getScenes();
		for ( CScene sc : scn){
			addElement(sc);
		}
		
		
	}

	 
	
	
	
}
