package vo.campaignmanager.windows.editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import vo.campaignmanager.DataManager;
import vo.campaignmanager.core.CCharacter;
import vo.campaignmanager.core.CScene;
import vo.campaignmanager.windows.models.CharacterListModel;
import vo.campaignmanager.windows.models.SceneListModel;

public class SceneEditor extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField _titleField;
	private JTextField _themeField;
	private JTextField _ambianceField;
	private JSplitPane _splitPane;
	private JTextField _startTimeField;
	private JTextField _endTimeField;
	private JTextField _igDurationField;
	private JTextField _irlDurationField;
	private JList _characterList;
	private JComboBox _placeComboBox;
	private JComboBox _stateComboBox;
	private JEditorPane _descriptionEditor;
	private JEditorPane _summaryEditor;
	private int _sceneID;
	private JList _nextSceneList;

	public SceneEditor(){
		
		_sceneID = -1;
		setMinimumSize(new Dimension(600, 400));
		
		setSize(new Dimension(800, 600));
		setLayout(new BorderLayout(0, 0));
		
		JPanel TitlePanel = new JPanel();
		TitlePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(TitlePanel, BorderLayout.NORTH);
		TitlePanel.setLayout(new BoxLayout(TitlePanel, BoxLayout.Y_AXIS));
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new EmptyBorder(5, 5, 5, 5));
		TitlePanel.add(horizontalBox);
		
		JLabel lblNewLabel = new JLabel("Titre :");
		lblNewLabel.setFont(new Font("Segoe Script", Font.PLAIN, 20));
		horizontalBox.add(lblNewLabel);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox.add(rigidArea);
		
		_titleField = new JTextField();
		_titleField.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		horizontalBox.add(_titleField);
		_titleField.setColumns(10);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);
		
		JSeparator separator = new JSeparator();
		TitlePanel.add(separator);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		TitlePanel.add(horizontalBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("Th\u00E8me :");
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		horizontalBox_1.add(lblNewLabel_1);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_1);
		
		_themeField = new JTextField();
		_themeField.setPreferredSize(new Dimension(150, 20));
		_themeField.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		horizontalBox_1.add(_themeField);
		_themeField.setColumns(10);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		horizontalBox_1.add(separator_1);
		
		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_6);
		
		JLabel lblNewLabel_2 = new JLabel("ambiance :");
		lblNewLabel_2.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		horizontalBox_1.add(lblNewLabel_2);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_3);
		
		_ambianceField = new JTextField();
		_ambianceField.setPreferredSize(new Dimension(150, 20));
		_ambianceField.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		horizontalBox_1.add(_ambianceField);
		_ambianceField.setColumns(10);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_4);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		horizontalBox_1.add(separator_2);
		
		Component rigidArea_7 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_7);
		
		JLabel lblNewLabel_3 = new JLabel("lieu :");
		lblNewLabel_3.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		horizontalBox_1.add(lblNewLabel_3);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_5);
		
		_placeComboBox = new JComboBox();
		_placeComboBox.setPreferredSize(new Dimension(150, 20));
		_placeComboBox.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		horizontalBox_1.add(_placeComboBox);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_1);
		
		JSeparator separator_3 = new JSeparator();
		TitlePanel.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		TitlePanel.add(separator_4);
		
		JPanel BottomPanel = new JPanel();
		add(BottomPanel);
		
		_splitPane = new JSplitPane();
		_splitPane.setContinuousLayout(true);
		_splitPane.setDividerSize(20);
		_splitPane.setOneTouchExpandable(true);
		_splitPane.setDividerLocation(this.getWidth()/2);
		add(_splitPane);
		
		JPanel panel = new JPanel();
		_splitPane.setLeftComponent(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel_4 = new JLabel("Personnages :");
		lblNewLabel_4.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		lblNewLabel_4.setBorder(new EmptyBorder(10, 0, 5, 0));
		lblNewLabel_4.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel_4.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel_4);
		
		CharacterListModel clm = new CharacterListModel();
		DataManager.getInstance().addListener(clm);
		_characterList = new JList(clm);
		_characterList.setLayoutOrientation(JList.VERTICAL_WRAP);

		_characterList.setBorder(new LineBorder(new Color(0, 0, 0)));
		_characterList.setMinimumSize(new Dimension(100, 70));
		_characterList.setMaximumSize(new Dimension(300, 300));
		_characterList.setPreferredSize(new Dimension(200, 100));
		panel.add(_characterList);
		
		Component rigidArea_11 = Box.createRigidArea(new Dimension(20, 20));
		panel.add(rigidArea_11);
		
		JSeparator separator_5 = new JSeparator();
		panel.add(separator_5);
		
		JLabel lblNewLabel_5 = new JLabel("Description :");
		lblNewLabel_5.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		lblNewLabel_5.setBorder(new EmptyBorder(10, 0, 5, 0));
		lblNewLabel_5.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel_5);
		
		Box horizontalBox_6 = Box.createHorizontalBox();
		panel.add(horizontalBox_6);
		
		Component rigidArea_9 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_6.add(rigidArea_9);
		
		_descriptionEditor = new JEditorPane();
		_descriptionEditor.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		horizontalBox_6.add(_descriptionEditor);
		_descriptionEditor.setPreferredSize(new Dimension(800, 300));
		
		Component rigidArea_10 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_6.add(rigidArea_10);
		
		Component verticalGlue = Box.createVerticalGlue();
		panel.add(verticalGlue);
		
		Component rigidArea_8 = Box.createRigidArea(new Dimension(20, 20));
		panel.add(rigidArea_8);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		panel.add(verticalGlue_1);
		
		JSeparator separator_11 = new JSeparator();
		panel.add(separator_11);
		
		JSeparator separator_10 = new JSeparator();
		panel.add(separator_10);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.add(horizontalBox_2);
		
		JButton _editButton = new JButton("Editer");
		_editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			setEditable(true);
			}
		});
		_editButton.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		horizontalBox_2.add(_editButton);
		
		JButton _saveButton = new JButton("Sauvegarder");
		_saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				save();
				setEditable(false);
			}
		});
		_saveButton.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		horizontalBox_2.add(_saveButton);
		
		JButton _closeButton = new JButton("Fermer");
		_closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		_closeButton.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		
		horizontalBox_2.add(_closeButton);
		
		Component horizontalGlue_5 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_5);
		
		JPanel panel_1 = new JPanel();
		_splitPane.setRightComponent(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel_6 = new JLabel("Prochaine(s) sc\u00E8ne(s) :");
		lblNewLabel_6.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_6.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		lblNewLabel_6.setBorder(new EmptyBorder(10, 0, 5, 0));
		panel_1.add(lblNewLabel_6);
		
		SceneListModel slm = new SceneListModel();
		DataManager.getInstance().addListener(slm);
		_nextSceneList = new JList(slm);
		_nextSceneList.setBorder(new LineBorder(new Color(0, 0, 0)));
		_nextSceneList.setMinimumSize(new Dimension(100, 70));
		_nextSceneList.setMaximumSize(new Dimension(300, 300));
		_nextSceneList.setPreferredSize(new Dimension(200, 100));
		panel_1.add(_nextSceneList);
		
		Component rigidArea_17 = Box.createRigidArea(new Dimension(20, 20));
		panel_1.add(rigidArea_17);
		
		JSeparator separator_6 = new JSeparator();
		panel_1.add(separator_6);
		
		JLabel lblNewLabel_7 = new JLabel("Compte-rendu :");
		lblNewLabel_7.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_7.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		lblNewLabel_7.setBorder(new EmptyBorder(10, 0, 5, 0));
		panel_1.add(lblNewLabel_7);
		
		_summaryEditor = new JEditorPane();
		_summaryEditor.setPreferredSize(new Dimension(800, 300));
		_summaryEditor.setMinimumSize(new Dimension(0, 0));
		panel_1.add(_summaryEditor);
		
		Component rigidArea_16 = Box.createRigidArea(new Dimension(20, 20));
		panel_1.add(rigidArea_16);
		
		JSeparator separator_7 = new JSeparator();
		panel_1.add(separator_7);
		
		JLabel lblNewLabel_8 = new JLabel("Temps de jeu :");
		lblNewLabel_8.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_8.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		lblNewLabel_8.setBorder(new EmptyBorder(10, 0, 5, 0));
		panel_1.add(lblNewLabel_8);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		horizontalBox_3.setBackground(new Color(255, 255, 255));
		horizontalBox_3.setOpaque(true);
		panel_1.add(horizontalBox_3);
		
		Component rigidArea_12 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3.add(rigidArea_12);
		
		JLabel lblNewLabel_9 = new JLabel("D\u00E9but sc\u00E8ne : ");
		lblNewLabel_9.setFont(new Font("Segoe Print", Font.PLAIN, 9));
		horizontalBox_3.add(lblNewLabel_9);
		
		_startTimeField = new JTextField();
		_startTimeField.setFont(new Font("Segoe Print", Font.PLAIN, 9));
		_startTimeField.setOpaque(false);
		horizontalBox_3.add(_startTimeField);
		_startTimeField.setColumns(10);
		
		Component rigidArea_13 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3.add(rigidArea_13);
		
		JSeparator separator_8 = new JSeparator();
		horizontalBox_3.add(separator_8);
		
		JLabel lblNewLabel_10 = new JLabel("Fin sc\u00E8ne : ");
		lblNewLabel_10.setFont(new Font("Segoe Print", Font.PLAIN, 9));
		horizontalBox_3.add(lblNewLabel_10);
		
		_endTimeField = new JTextField();
		_endTimeField.setFont(new Font("Segoe Print", Font.PLAIN, 9));
		_endTimeField.setOpaque(false);
		horizontalBox_3.add(_endTimeField);
		_endTimeField.setColumns(10);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox_3.add(horizontalGlue_2);
		
		Box horizontalBox_4 = Box.createHorizontalBox();
		horizontalBox_4.setBackground(new Color(255, 255, 255));
		horizontalBox_4.setOpaque(true);
		panel_1.add(horizontalBox_4);
		
		Component rigidArea_14 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_14);
		
		JLabel lblDureEnJeu = new JLabel("Dur\u00E9e en jeu : ");
		lblDureEnJeu.setFont(new Font("Segoe Print", Font.PLAIN, 9));
		horizontalBox_4.add(lblDureEnJeu);
		
		_igDurationField = new JTextField();
		_igDurationField.setFont(new Font("Segoe Print", Font.PLAIN, 9));
		_igDurationField.setColumns(10);
		horizontalBox_4.add(_igDurationField);
		
		JSeparator separator_9 = new JSeparator();
		horizontalBox_4.add(separator_9);
		
		Component rigidArea_15 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_15);
		
		JLabel lblDureRelle = new JLabel("Dur\u00E9e r\u00E9elle : ");
		lblDureRelle.setFont(new Font("Segoe Print", Font.PLAIN, 9));
		horizontalBox_4.add(lblDureRelle);
		
		_irlDurationField = new JTextField();
		_irlDurationField.setFont(new Font("Segoe Print", Font.PLAIN, 9));
		_irlDurationField.setColumns(10);
		horizontalBox_4.add(_irlDurationField);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox_4.add(horizontalGlue_3);
		
		Box horizontalBox_5 = Box.createHorizontalBox();
		horizontalBox_5.setOpaque(true);
		horizontalBox_5.setBackground(new Color(255, 255, 255));
		panel_1.add(horizontalBox_5);
		
		Component rigidArea_19 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_5.add(rigidArea_19);
		
		JLabel lblNewLabel_11 = new JLabel("Etat actuel : ");
		lblNewLabel_11.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		horizontalBox_5.add(lblNewLabel_11);
		
		Component rigidArea_18 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_5.add(rigidArea_18);
		
		_stateComboBox = new JComboBox();
		_stateComboBox.setActionCommand("_state");
		_stateComboBox.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		horizontalBox_5.add(_stateComboBox);
		
		Component horizontalGlue_4 = Box.createHorizontalGlue();
		horizontalBox_5.add(horizontalGlue_4);
		
	}
	
	public SceneEditor(CScene obj) {
		
		this();
		load(obj);
		setEditable(false);
		
		
	}

	protected void load(CScene scene){
		
		 _titleField.setText(scene.name);
		 _themeField.setText(scene.theme);
		 _ambianceField.setText(scene.ambiance);
		 _startTimeField.setText(scene.startTime.toString());
		 _endTimeField.setText(scene.endTime.toString());
		 _igDurationField.setText(scene.igDuration + "");
		 _irlDurationField.setText(scene.irlDuration + "");
		 _descriptionEditor.setText(scene.description);
		 _summaryEditor.setText(scene.summary);
		 _stateComboBox.setSelectedItem(scene.state);
		 _sceneID = scene.id;
		 
		//TODO Ceci est une rustine, à régler 12C4
		for (int i = 0; i<_nextSceneList.getModel().getSize();i++){
			if (scene.nextScenes.contains((CScene)_nextSceneList.getModel().getElementAt(i)))
				_nextSceneList.setSelectedIndex(i);
		}
		for (int i = 0; i<_characterList.getModel().getSize();i++){
			if (scene.participants.contains((CCharacter)_characterList.getModel().getElementAt(i)))
				_characterList.setSelectedIndex(i);
		}
		_characterList.setSelectedIndices(DataManager.getInstance().getCharacterIndices(scene.participants));
		_nextSceneList.setSelectedIndices(DataManager.getInstance().getSceneIndices(scene.nextScenes));
		
		
		
	}
	protected void save() {
		
		
		CScene current = new CScene();
		
		current.name = _titleField.getText();
		current.description = _descriptionEditor.getText();
		current.theme = _themeField.getText();
		current.ambiance = _ambianceField.getText();
		current.summary = _summaryEditor.getText();
		current.startTime = new Date(System.currentTimeMillis());
		current.endTime = new Date(System.currentTimeMillis());
		current.irlDuration = Integer.parseInt("0" + _irlDurationField.getText());
		current.igDuration = Integer.parseInt("0" + _irlDurationField.getText());
		current.state = 
		current.id = _sceneID;
		
		current.nextScenes.clear();
		for (int i : _nextSceneList.getSelectedIndices()){
			current.nextScenes.add(i);
		}
		
		current.participants.clear();
		for (int i : _characterList.getSelectedIndices()){
			current.participants.add(i);
		}
		
		_sceneID = DataManager.getInstance().addScene(current);
		
	}


	protected void setEditable(boolean b) {
		
		 _titleField.setEditable(b);
		 _themeField.setEditable(b);
		 _ambianceField.setEditable(b);
		 _startTimeField.setEditable(b);
		 _endTimeField.setEditable(b);
		 _igDurationField.setEditable(b);
		 _irlDurationField.setEditable(b);
		 _descriptionEditor.setEditable(b);
		 _summaryEditor.setEditable(b);
		 _characterList.setEnabled(b);
		 _nextSceneList.setEnabled(b);
		 _placeComboBox.setEnabled(b);
		 _stateComboBox.setEnabled(b);

	}
	
	protected void close() {
		
		getParent().remove(this);
		
	}
	
	
}


