package vo.campaignmanager.windows.editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import vo.campaignmanager.core.CCharacter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CharacterEditor extends JPanel {
	
	public CharacterEditor() {
		
		setLayout(new BorderLayout(0, 0));
		
		JList list = new JList();
		add(list, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		panel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				
				if (ke.isControlDown()){
					if (ke.getKeyChar() == "s".charAt(0)){
						save();
						setEditable(false);
					}
				}
			}
		});
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
		
		JSeparator separator = new JSeparator();
		panel.add(separator);
		JLabel lblNewLabel_1 = new JLabel("Description");
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
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		panel.add(horizontalBox_2);
		
		JLabel lblNewLabel_2 = new JLabel("Exp\u00E9rience : ");
		lblNewLabel_2.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		horizontalBox_2.add(lblNewLabel_2);
		
		_currentExpField = new JTextField();
		_currentExpField.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		_currentExpField.setMaximumSize(new Dimension(150, 20));
		horizontalBox_2.add(_currentExpField);
		_currentExpField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel(" / ");
		horizontalBox_2.add(lblNewLabel_3);
		
		_totalExpField = new JTextField();
		_totalExpField.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		_totalExpField.setMaximumSize(new Dimension(150, 20));
		horizontalBox_2.add(_totalExpField);
		_totalExpField.setColumns(10);
		
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

	public CharacterEditor(CCharacter obj) {
		this();
		
		_nameField.setText(obj.name);
		_descriptionPane.setText(obj.description);
		_currentExpField.setText(String.valueOf(obj.currentXP));
		_totalExpField.setText(String.valueOf(obj.totalXP));
		_characterID = obj.id;
		
		setEditable(false);
		
		
	}

	protected void save() {
		
		CCharacter current = new CCharacter();
		current.name = _nameField.getText();
		current.description = _descriptionPane.getText();
		current.currentXP = Integer.parseInt( "0"+_currentExpField.getText());
		current.totalXP = Integer.parseInt("0"+_totalExpField.getText());
		current.id = _characterID;
		
		_characterID = DataManager.getInstance().addCharacter(current);
		
	}


	protected void setEditable(boolean b) {
		
		_nameField.setEditable(b);
		_currentExpField.setEditable(b);
		_totalExpField.setEditable(b);
		_descriptionPane.setEditable(b);
		
	}

	protected void close() {
		
		getParent().remove(this);
		
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField _nameField;
	private JTextField _currentExpField;
	private JTextField _totalExpField;
	private JTextPane _descriptionPane;

	private int			_characterID = -1;
	
}
