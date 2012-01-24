package vo.campaignmanager.windows.editor;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.border.LineBorder;

import vo.campaignmanager.DataManager;
import vo.campaignmanager.core.CPlace;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlaceEditor extends JPanel {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JTextField _nameField;
	private JTextPane _descriptionPane;
	private JTextField _emplacementField;
	private int			_placeID;
	
	public PlaceEditor() {
		
		_placeID = -1;
		setLayout(new BorderLayout(0, 0));
		
		JList list = new JList();
		add(list, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		panel.add(rigidArea_2);
		
		Box horizontalBox = Box.createHorizontalBox();
		panel.add(horizontalBox);
		
		JLabel lblNewLabel = new JLabel("Nom : ");
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		horizontalBox.add(lblNewLabel);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox.add(rigidArea);
		
		_nameField = new JTextField();
		_nameField.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		_nameField.setMaximumSize(new Dimension(300, 40));
		horizontalBox.add(_nameField);
		_nameField.setColumns(10);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		panel.add(rigidArea_1);
		
		Box horizontalBox_4 = Box.createHorizontalBox();
		panel.add(horizontalBox_4);
		
		JLabel lblEmplacement = new JLabel("Emplacement : ");
		lblEmplacement.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		horizontalBox_4.add(lblEmplacement);
		
		Component rigidArea_9 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_9);
		
		_emplacementField = new JTextField();
		_emplacementField.setMaximumSize(new Dimension(300, 40));
		_emplacementField.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		_emplacementField.setColumns(10);
		horizontalBox_4.add(_emplacementField);
		
		Component rigidArea_10 = Box.createRigidArea(new Dimension(20, 20));
		panel.add(rigidArea_10);
		
		JSeparator separator = new JSeparator();
		panel.add(separator);
		JLabel lblNewLabel_1 = new JLabel("Description : ");
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		panel.add(lblNewLabel_1);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		panel.add(horizontalBox_1);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_3);
		
		_descriptionPane = new JTextPane();
		_descriptionPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		_descriptionPane.setFont(new Font("Segoe Print", Font.PLAIN, 11));
		horizontalBox_1.add(_descriptionPane);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_4);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		panel.add(rigidArea_5);
		
		JSeparator separator_1 = new JSeparator();
		panel.add(separator_1);
		
		Component rigidArea_8 = Box.createRigidArea(new Dimension(20, 20));
		panel.add(rigidArea_8);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		panel.add(horizontalBox_3);
		
		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3.add(rigidArea_6);
		
		JButton _editButton = new JButton("Editer");
		_editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setEditable(true);
			}
		});
		horizontalBox_3.add(_editButton);
		
		JButton _saveButton = new JButton("Sauvegarder");
		_saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				save();
				setEditable(false);
			}
		});
		horizontalBox_3.add(_saveButton);
		
		JButton _closeButton = new JButton("Fermer");
		_closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		horizontalBox_3.add(_closeButton);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox_3.add(horizontalGlue);
		
		Component rigidArea_7 = Box.createRigidArea(new Dimension(20, 20));
		panel.add(rigidArea_7);
	}

	public PlaceEditor(CPlace obj) {
		
		this();
		
		_nameField.setText(obj.name);
		_descriptionPane.setText(obj.description);
		_emplacementField.setText(obj.emplacement);
		_placeID = obj.id;
		
		setEditable(false);
		
		
	}

	protected void save() {
		
		CPlace current = new CPlace();
		current.name = _nameField.getText();
		current.description = _descriptionPane.getText();
		current.emplacement = _emplacementField.getText();
		current.id = _placeID;
		
		_placeID = DataManager.getInstance().addPlace(current);
		
	}


	protected void setEditable(boolean b) {
		
		_nameField.setEditable(b);
		_descriptionPane.setEditable(b);
		_emplacementField.setEditable(b);

	}
	
	protected void close() {
		
		getParent().remove(this);
		
	}


}

