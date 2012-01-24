package vo.campaignmanager.windows;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import vo.campaignmanager.DataManager;
import vo.campaignmanager.core.CCharacter;
import vo.campaignmanager.core.CPlace;
import vo.campaignmanager.core.CScene;
import vo.campaignmanager.windows.editor.CampaignEditor;
import vo.campaignmanager.windows.editor.CharacterEditor;
import vo.campaignmanager.windows.editor.PlaceEditor;
import vo.campaignmanager.windows.editor.SceneEditor;
import vo.campaignmanager.windows.models.CampaignTreeModel;

public class CampaignManager extends JFrame {


	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JTabbedPane _principalPane;

	public CampaignManager(){
    this.setTitle("Gestionnaire de campagne");
    this.setSize(800, 800);
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    
    _principalPane = new JTabbedPane(JTabbedPane.TOP);
    getContentPane().add(_principalPane, BorderLayout.CENTER);
    
    _principalPane.addTab("Suivi de l'action", null, new ActionFollower(), null);
    _principalPane.setEnabledAt(0, true);
    
    JPanel panel_1 = new JPanel();
    _principalPane.addTab("New tab", null, panel_1, null);
    
    final JTree tree = new JTree();
    tree.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		
    		if (e.getClickCount() == 2){
    			
    			DefaultMutableTreeNode dmn = (DefaultMutableTreeNode)tree.getClosestPathForLocation(e.getX(), e.getY()).getLastPathComponent();
    			System.out.println(dmn.getUserObject().getClass());
    			JComponent tab = null;
    			if (dmn.getUserObject() instanceof CCharacter){
    				tab = new CharacterEditor((CCharacter)dmn.getUserObject());
    			} else if (dmn.getUserObject() instanceof CPlace){
    				tab = new PlaceEditor((CPlace)dmn.getUserObject());			
    			} else if (dmn.getUserObject() instanceof CScene){
    				tab = new SceneEditor((CScene)dmn.getUserObject());		
    			}
    			
    			if (tab != null){
    				_principalPane.addTab(dmn.getUserObject().toString(), null, tab, null);
    				_principalPane.setSelectedComponent(tab);
    				
    			}
    			
    		}
    	}
    });
    
    CampaignTreeModel ctm = new CampaignTreeModel();
    DataManager.getInstance().addListener(ctm);
    tree.setModel(ctm);
    getContentPane().add(tree, BorderLayout.WEST);
    
    JPopupMenu popupMenu = new JPopupMenu();
    addPopup(tree, popupMenu);
    
    JMenu menu = new JMenu("Nouveau...");
    popupMenu.add(menu);
    
    JMenuItem menuItem = new JMenuItem("Personnage");
    menuItem.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		_principalPane.addTab("Nouveau personnage", null, new CharacterEditor(), null);
    		_principalPane.setSelectedIndex(_principalPane.getTabCount()-1);
    	}
    });
    menu.add(menuItem);
    
    JMenuItem menuItem_1 = new JMenuItem("Sc\u00E8ne");
    menuItem_1.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		_principalPane.addTab("Nouvelle scène", null, new SceneEditor(), null);
    		_principalPane.setSelectedIndex(_principalPane.getTabCount()-1);
    	}
    });
    menu.add(menuItem_1);
    
    JMenuItem menuItem_2 = new JMenuItem("Lieu");
    menuItem_2.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		_principalPane.addTab("Nouveau lieu", null, new PlaceEditor(), null);
    		_principalPane.setSelectedIndex(_principalPane.getTabCount()-1);
    	}
    });
    menu.add(menuItem_2);
    
    JMenuItem menuItem_3 = new JMenuItem("Ev\u00E9nement");
    menu.add(menuItem_3);
    
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);
    
    JMenu mnNewMenu = new JMenu("Fichier");
    menuBar.add(mnNewMenu);
    
    JMenuItem mntmNewMenuItem = new JMenuItem("Sauvegarder");
    mntmNewMenuItem.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		DataManager.saveFull();
    	}
    });
    
    JMenuItem mntmNouveau = new JMenuItem("Nouvelle chronique");
    mntmNouveau.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		DataManager.getInstance().clear();
    		_principalPane.removeAll();
    		_principalPane.addTab("Suivi d'action", new ActionFollower());
    		_principalPane.addTab("Nouvelle chronique", null, new CampaignEditor(), null);
    		_principalPane.setSelectedIndex(_principalPane.getTabCount()-1);
    	}
    });
    mnNewMenu.add(mntmNouveau);
    
    JMenuItem mntmNewMenuItem_1 = new JMenuItem("Charger");
    mntmNewMenuItem_1.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		DataManager.loadFull();
    	}
    });
    mnNewMenu.add(mntmNewMenuItem_1);
    mnNewMenu.add(mntmNewMenuItem);
    
    JMenuItem mntmFermer = new JMenuItem("Fermer");
    mntmFermer.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		System.exit(DISPOSE_ON_CLOSE);
    	}
    });
    mnNewMenu.add(mntmFermer);
    
    JMenu mnNouveau = new JMenu("Nouveau...");
    menuBar.add(mnNouveau);
    
    JMenuItem mntmPersonnage = new JMenuItem("Personnage");
    mntmPersonnage.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		_principalPane.addTab("Nouveau personnage", null, new CharacterEditor(), null);
    		_principalPane.setSelectedIndex(_principalPane.getTabCount()-1);
    	}
    });
    mnNouveau.add(mntmPersonnage);
    
    JMenuItem mntmScne = new JMenuItem("Sc\u00E8ne");
    mntmScne.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		_principalPane.addTab("Nouvelle scène", null, new SceneEditor(), null);
    		_principalPane.setSelectedIndex(_principalPane.getTabCount()-1);
    		
    	}
    });
    mnNouveau.add(mntmScne);
    
    JMenuItem mntmLieu = new JMenuItem("Lieu");
    mntmLieu.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		_principalPane.addTab("Nouveau lieu", null, new PlaceEditor(), null);
    		_principalPane.setSelectedIndex(_principalPane.getTabCount()-1);
    		
    	}
    });
    mnNouveau.add(mntmLieu);
    
    JMenuItem mntmEvnement = new JMenuItem("Ev\u00E9nement");
    mnNouveau.add(mntmEvnement);
    
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
