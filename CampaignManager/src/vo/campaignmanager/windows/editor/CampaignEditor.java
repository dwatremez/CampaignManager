package vo.campaignmanager.windows.editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

import vo.campaignmanager.DataManager;
import vo.campaignmanager.core.Campaign;

public class CampaignEditor extends JPanel {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JTextField _nameField;
	private JTextPane _descriptionPane;
	private JTextField _startTimeField;
	private int			_campaignID;
	private JTextField _actuelTimeField;
	
	public CampaignEditor() {
		
		_campaignID = -1;
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
		
		JLabel lblEmplacement = new JLabel("Commencement :");
		lblEmplacement.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		horizontalBox_4.add(lblEmplacement);
		
		Component rigidArea_9 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_9);
		
		_startTimeField = new JTextField();
		_startTimeField.setMaximumSize(new Dimension(300, 40));
		_startTimeField.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		_startTimeField.setColumns(10);
		horizontalBox_4.add(_startTimeField);
		
		Component rigidArea_10 = Box.createRigidArea(new Dimension(20, 20));
		panel.add(rigidArea_10);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		panel.add(horizontalBox_2);
		
		JLabel lblTempsActuel = new JLabel("Temps actuel :");
		lblTempsActuel.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		horizontalBox_2.add(lblTempsActuel);
		
		Component rigidArea_11 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_11);
		
		_actuelTimeField = new JTextField();
		_actuelTimeField.setMaximumSize(new Dimension(300, 40));
		_actuelTimeField.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		_actuelTimeField.setColumns(10);
		horizontalBox_2.add(_actuelTimeField);
		
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
		
		_startTimeField.setText(new Date(System.currentTimeMillis()).toString());
		
	}

	public CampaignEditor(Campaign obj) {
		
		this();
		
		_nameField.setText(obj.getName());
		_descriptionPane.setText(obj.getDescription());
		_startTimeField.setText(obj.getStartDate().toString());
		_campaignID = obj.getId();
		
		setEditable(false);
		
		
	}

	protected void save() {
		
		Campaign current = new Campaign();
		current.setName(_nameField.getText());
		current.setDescription(_descriptionPane.getText());
		current.setStartDate(new Date(System.currentTimeMillis()) /* DateFormat.getTimeInstance().parse(_startTimeField.getText())*/);
		current.setId(_campaignID);
		
		DataManager.getInstance().setCampaign(current);
		
	}


	protected void setEditable(boolean b) {
		
		_nameField.setEditable(b);
		_descriptionPane.setEditable(b);
		_startTimeField.setEditable(b);

	}
	
	protected void close() {
		
		getParent().remove(this);
		
	}


}

