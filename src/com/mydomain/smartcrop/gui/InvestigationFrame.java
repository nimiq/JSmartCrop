package com.mydomain.smartcrop.gui;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.WindowConstants;

import com.mydomain.smartcrop.procedure.AbstractProcedure;
import com.mydomain.smartcrop.procedure.Configuration;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class InvestigationFrame extends javax.swing.JFrame {
	private JList invList;
	private JButton viewButton;
	private AbstractAction viewAbstractAction;
	private String[] fileNames;
	private JScrollPane jScrollPane1;
	private String inFolder;
	private Configuration conf;
	private AbstractProcedure procedure;

	/**
	* Auto-generated main method to display this JFrame
	*/
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				InvestigationFrame inst = new InvestigationFrame(null);
//				inst.setLocationRelativeTo(null);
//				inst.setVisible(true);
//			}
//		});
//	}
	
	public InvestigationFrame(String[] fileNames, String inFolder, Configuration conf, AbstractProcedure procedure) {
		super();
		this.fileNames = fileNames;
		this.inFolder = inFolder;
		this.conf = conf;
		this.procedure = procedure;
		initGUI();
		
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				viewButton = new JButton();
				viewButton.setText("Vedi >");
				viewButton.setAction(getViewAbstractAction());
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(getJScrollPane1(), GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
				.addGap(20)
				.addComponent(viewButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(73, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(thisLayout.createSequentialGroup()
				        .addComponent(getJScrollPane1(), GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGap(129)
				        .addComponent(viewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(24, Short.MAX_VALUE));
			pack();
			this.setSize(272, 333);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private AbstractAction getViewAbstractAction() {
		if(viewAbstractAction == null) {
			viewAbstractAction = new AbstractAction("Vedi >", null) {
				public void actionPerformed(ActionEvent evt) {
					//BufferedImage img = IOImage.getImage(inFolder + invList.getSelectedValue().toString());
					//new ImagePlus("", img).show();
					//ScanManager(File file, Configuration conf, AbstractProcedure procedure, boolean investigate)
    				ChartFrame inst = new ChartFrame();
					File file = new File(inFolder + invList.getSelectedValue().toString());
					(new Thread(new ScanManager(file, conf, procedure, true, inst))).start();
					inst.setLocationRelativeTo(null);
					inst.setVisible(true);
				}
				
			};
		}
		return viewAbstractAction;
	}
	
	private JScrollPane getJScrollPane1() {
		if(jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			{
				ListModel invListModel = 
						new DefaultComboBoxModel(fileNames);
				invList = new JList();
				jScrollPane1.setViewportView(invList);
				invList.setModel(invListModel);
			}
		}
		return jScrollPane1;
	}

}
