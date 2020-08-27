/*
 * This is a program that takes and reads a file in txt format. Then it analyzes
 * its source and destination ip addresses displays the size of packets send between 
 * them on the graph.
 * 
 * Artem Novitckii
 * anov099
 * 207428057
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JFileChooser;
import javax.swing.*;

import java.io.File;

public class A2 extends JFrame{
    private	JPanel radioButtonPanel;
    private ButtonGroup radioButtons;
	private JRadioButton radioButtonSrcHost;
	private JRadioButton radioButtonDestHost;
	private DrawGraph plot;
	private JComboBox<String> mycomboBox;
    private ArrayList<Packet> return_list;
    private ArrayList<String> srcArray;
    private ArrayList<String> destArray;
    private DefaultComboBoxModel srcModel, destModel;

    
    /*
     * This is a constructor of the A2 frame where all methods are called
     * to put all pieces together.
     */
	public A2(){
		super("Network Packet Transmission Visualizer");
		setLayout(null);
		setSize(1000,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font font = new Font("Sans-serif", Font.PLAIN, 15);
		setUpMenu();
		setUpRadioButtons();
		setUpGraphPanel();
		setUpComboBox();
		setVisible(true);
	}
	

	/*
	 * This methods sets up the JMenu and adds it to the frame.
	 */
	public void setUpMenu(){
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		Font font = new Font("Sans-serif", Font.PLAIN, 15);
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F'); //shortcut to open Menu
		fileMenu.setFont(font); //setting font for Menu Heading
		menuBar.add(fileMenu);
		JMenuItem fileMenuOpen = new JMenuItem("Open Trace File"); //Drop-down menu option
		fileMenuOpen.setFont(font);
		fileMenuOpen.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						JFileChooser fileChooser = new JFileChooser(".");
						int retval = fileChooser.showOpenDialog(A2.this);
						if (retval == JFileChooser.APPROVE_OPTION) {
							File f = fileChooser.getSelectedFile();
							AnalyseFile data = new AnalyseFile();
							return_list = data.createValidPacketList(f);
							srcArray = Host.getUniqueSortedSourceHosts(return_list);
							destArray = Host.getUniqueSortedDestHosts(return_list);
							srcModel = new DefaultComboBoxModel(srcArray.toArray());
							destModel = new DefaultComboBoxModel(destArray.toArray());
							radioButtonSrcHost.setSelected(true);
							mycomboBox.setModel(srcModel);
							mycomboBox.setVisible(true);							
						}
					}
				}
					
		
				);
		fileMenu.add(fileMenuOpen);
		JMenuItem fileMenuQuit = new JMenuItem("Quit"); //Drop-down menu option
		fileMenuQuit.setFont(font);
		fileMenu.add(fileMenuQuit);
		fileMenuQuit.addActionListener(
				new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				}
				);
	}
	
	/*
	 * This methods sets up JRadioBUttons and adds them to the frame.
	 */
	private void setUpRadioButtons(){
		Font font = new Font("Sans-serif", Font.PLAIN, 15);
		
		//Initializing the JPanel which holds radio button group
		radioButtonPanel = new JPanel();
		radioButtonPanel.setSize(200,100);
		
		//Initializing layout to left align radio buttons 
		radioButtonPanel.setLayout(new GridBagLayout());
    	GridBagConstraints c = new GridBagConstraints();
    	c.gridx = 0;
    	c.gridy = GridBagConstraints.RELATIVE;
    	c.anchor = GridBagConstraints.WEST;
		
		//adding radio buttons to button group
		radioButtons = new ButtonGroup();
		radioButtonSrcHost = new JRadioButton("Source hosts");
		radioButtonSrcHost.setSelected(true);
		radioButtonSrcHost.setFont(font);
		radioButtons.add(radioButtonSrcHost);
		radioButtonPanel.add(radioButtonSrcHost, c);
		radioButtonSrcHost.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						try {
							if ((radioButtonSrcHost.isSelected()) & (srcModel.getSize() != 0)){
								mycomboBox.setModel(srcModel);
							}
						}
						catch (NullPointerException ex) {
							System.out.println("File has to be selected first");
						}
					}
				}
        );
		
		radioButtonDestHost = new JRadioButton("Destination hosts");
		radioButtonDestHost.setFont(font);
		radioButtons.add(radioButtonDestHost);
		radioButtonPanel.add(radioButtonDestHost, c);
		radioButtonDestHost.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						try{
							if ((radioButtonDestHost.isSelected()) & (destModel.getSize() != 0)){
								mycomboBox.setModel(destModel);
							}
						}
						catch (NullPointerException ie) {
							System.out.println("File has to be selected first");
						}
					}
				}
        );
		getContentPane().add(radioButtonPanel);
	}

	/*
	 * This methods sets up initial JComboBox with no elements in it and adds it to the frame.
	 * It is invisible initially.
	 */
	private void setUpComboBox(){
		Font font = new Font("Sans-serif", Font.PLAIN, 15);
		mycomboBox = new JComboBox<String>();
		mycomboBox.setLocation(270,25);
		mycomboBox.setSize(300,25);
		mycomboBox.setVisible(false);
		mycomboBox.setFont(font);
		add(mycomboBox);
	}
	
	/*
	 * This methods sets up Graph Panel by calling a DrawGraph class and adds it to the frame.
	 */
	private void setUpGraphPanel(){
		plot = new DrawGraph();
		plot.setSize(1000,325);
		plot.setLocation(0,100);
		plot.setBackground(Color.BLACK);
		add(plot);
	}
	
	
	
	
	
	
	
	
	
}