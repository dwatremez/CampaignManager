package vo.campaignmanager.windows.models;

import java.util.Collection;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import vo.campaignmanager.DataManager;
import vo.campaignmanager.DataManager.DataManagerListener;
import vo.campaignmanager.core.CCharacter;
import vo.campaignmanager.core.CPlace;
import vo.campaignmanager.core.CScene;

public class CampaignTreeModel extends DefaultTreeModel implements DataManagerListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DefaultMutableTreeNode campaignNode;
	private DefaultMutableTreeNode eventNode;
	private DefaultMutableTreeNode sceneNode;
	private DefaultMutableTreeNode placeNode;
	private DefaultMutableTreeNode characterNode;
	
	
	public CampaignTreeModel(TreeNode arg0) {
		
		this();
		campaignNode = (DefaultMutableTreeNode)arg0;
		

		
		}

	public CampaignTreeModel(){
		super(null);
		
		refresh();
		
	}
	
	public void refresh(){
		
		campaignNode = new DefaultMutableTreeNode(DataManager.getInstance().getCampaign());
		
		sceneNode = new DefaultMutableTreeNode("Sc\u00E8ne");
		characterNode = new DefaultMutableTreeNode("Personnage");
		placeNode = new DefaultMutableTreeNode("Lieu");
		eventNode = new DefaultMutableTreeNode("Ev\u00E9nement");
		
		campaignNode.add(characterNode);
		
		Collection<CCharacter> chArray = DataManager.getInstance().getCharacters();
		for (CCharacter ch : chArray){
			characterNode.add(new DefaultMutableTreeNode(ch));
		}
		
		campaignNode.add(placeNode);
		
		Collection<CPlace> plArray = DataManager.getInstance().getPlaces();
		for (CPlace pl : plArray){
			placeNode.add(new DefaultMutableTreeNode(pl));
		}
		
		campaignNode.add(eventNode);
		campaignNode.add(sceneNode);
		
		Collection<CScene> scArray = DataManager.getInstance().getScenes();
		for (CScene sc : scArray){
			sceneNode.add(new DefaultMutableTreeNode(sc));
		}
		
		setRoot(campaignNode);
		
	}

	public void getObject(TreePath tp){
		
		
		
	}
	
	@Override
	public void onDataChanged() {
		refresh();
	}
}
