package vo.campaignmanager.windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.AbstractListModel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import vo.campaignmanager.DataManager;
import vo.campaignmanager.core.CCharacter;
import vo.campaignmanager.core.CScene;
import vo.campaignmanager.windows.editor.CharacterEditor;
import vo.campaignmanager.windows.models.CharacterListModel;
import vo.campaignmanager.windows.models.SceneListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ActionFollower extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList _nextSceneList;
	private JTextField _gameTime;
	private JLabel _titre;
	private JLabel _theme;
	private JLabel _ambiance;
	private JLabel _description;
	private JList _characterList;
	private JLabel _place;

	/**
	 * Create the panel.
	 */
	public ActionFollower() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(128, 128, 128)), new EmptyBorder(5, 5, 5, 5)));
		panel.setBackground(new Color(255, 228, 181));
		panel.setMaximumSize(new Dimension(150, 32767));
		add(panel, BorderLayout.EAST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		Component rigidArea = Box.createRigidArea(new Dimension(150, 10));
		panel.add(rigidArea);
		
		JLabel lblTempsEnJeu = new JLabel("Temps en jeu :");
		lblTempsEnJeu.setFont(new Font("Segoe Script", Font.PLAIN, 14));
		lblTempsEnJeu.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lblTempsEnJeu);
		
		JSeparator separator = new JSeparator();
		separator.setMaximumSize(new Dimension(150, 2));
		panel.add(separator);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(5, 5));
		panel.add(rigidArea_1);
		
		_gameTime = new JTextField();
		_gameTime.setMaximumSize(new Dimension(150, 200));
		_gameTime.setPreferredSize(new Dimension(150, 20));
		_gameTime.setSize(new Dimension(150, 20));
		panel.add(_gameTime);
		_gameTime.setColumns(10);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(5, 5));
		panel.add(rigidArea_2);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(5, 5));
		panel.add(rigidArea_4);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(5, 5));
		panel.add(rigidArea_5);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setMaximumSize(new Dimension(150, 2));
		panel.add(separator_2);
		
		JLabel lblNewLabel = new JLabel("Sc\u00E8ne suivante :");
		lblNewLabel.setFont(new Font("Segoe Script", Font.PLAIN, 14));
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lblNewLabel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setMaximumSize(new Dimension(150, 2));
		panel.add(separator_1);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(5, 5));
		panel.add(rigidArea_3);
		
		_nextSceneList = new JList();
		_nextSceneList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		_nextSceneList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				
				if (me.getClickCount() ==2){
					load((CScene) _nextSceneList.getSelectedValue());
				}
			}
		});
		_nextSceneList.setMaximumSize(new Dimension(150, 0));
		_nextSceneList.setMinimumSize(new Dimension(150, 0));
		SceneListModel slm = new SceneListModel();
		DataManager.getInstance().addListener(slm);
		_nextSceneList.setModel(slm);
		_nextSceneList.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		panel.add(_nextSceneList);
		
		Component verticalGlue = Box.createVerticalGlue();
		panel.add(verticalGlue);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		_characterList = new JList();
		_characterList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() ==2){
					SwingUtilities.invokeLater(new Runnable(){
						@Override
						public void run() {
							JFrame fenetre = new JFrame();
							fenetre.setContentPane(new CharacterEditor((CCharacter) _characterList.getSelectedValue()));
							fenetre.setSize(600, 600);
						    fenetre.setVisible(true);
						}	
					});
				}
			}
		});
		_characterList.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(128, 128, 128)));
		_characterList.setBackground(new Color(255, 255, 255));
		_characterList.setFont(new Font("Segoe Script", Font.PLAIN, 14));
		_characterList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		_characterList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		_characterList.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		_characterList.setMaximumSize(new Dimension(1000, 200));
		_characterList.setMinimumSize(new Dimension(0, 100));
		panel_1.add(_characterList, BorderLayout.SOUTH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBackground(new Color(255, 248, 220));
		panel_1.add(panel_2, BorderLayout.CENTER);
		
		_titre = new JLabel("Titre");
		_titre.setFont(new Font("Segoe Script", Font.BOLD, 20));
		
		_description = new JLabel("Description");
		_description.setFont(new Font("Segoe Script", Font.PLAIN, 14));
		_description.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(128, 128, 128)));
		_description.setBackground(new Color(255, 255, 255));
		_description.setOpaque(true);
		
		_theme = new JLabel("Theme");
		_theme.setFont(new Font("Segoe Script", Font.PLAIN, 14));
		
		_ambiance = new JLabel("Ambiance");
		_ambiance.setFont(new Font("Segoe Script", Font.PLAIN, 14));
		
		_place = new JLabel("Lieu");
		_place.setFont(new Font("Segoe Script", Font.PLAIN, 14));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(_description, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(_theme)
							.addGap(20)
							.addComponent(_ambiance))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(_titre)
							.addPreferredGap(ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
							.addComponent(_place, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(22)
							.addComponent(_titre)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(_ambiance)
								.addComponent(_theme)))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(_place, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(_description, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);

	}
	
	protected void load(CScene scene){
		
		_characterList.setModel(new CharacterListModel(scene.participants));
		// _place.setText(DataManager.getInstance().getPlace(scene.place).toString());
		_gameTime.setText("");
		_titre.setText(scene.name);
		_theme.setText(scene.theme);
		_ambiance.setText(scene.ambiance);
		_description.setText(scene.description);
		for (int i = 0; i<_nextSceneList.getModel().getSize();i++){
			if (scene.nextScenes.contains((CScene)_nextSceneList.getModel().getElementAt(i)))
				_nextSceneList.setSelectedIndex(i);
		}
		
	}
}
