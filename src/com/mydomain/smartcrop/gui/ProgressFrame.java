package com.mydomain.smartcrop.gui;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


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
public class ProgressFrame extends javax.swing.JFrame {
	private static final long serialVersionUID = 4991128892922615493L;
	private JProgressBar progressBar;
	private AbstractAction exitAbstractAction;
	private JButton exitButton;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ProgressFrame inst = new ProgressFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ProgressFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				progressBar = new JProgressBar();
				progressBar.setStringPainted(true);
			}
			{
				exitButton = new JButton();
				exitButton.setText("Fine");
				exitButton.setAction(getExitAbstractAction());
				exitButton.setEnabled(false);
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(33)
				.addComponent(exitButton, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(25, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(progressBar, GroupLayout.Alignment.LEADING, 0, 360, Short.MAX_VALUE)
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGap(144)
				        .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 143, Short.MAX_VALUE)))
				.addContainerGap());
			pack();
			this.setSize(400, 145);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private AbstractAction getExitAbstractAction() {
		if(exitAbstractAction == null) {
			exitAbstractAction = new AbstractAction("Fine", null) {
				private static final long serialVersionUID = 5701047746861212794L;
				
				public void actionPerformed(ActionEvent evt) {
					System.exit(0);
				}
			};
		}
		return exitAbstractAction;
	}

	/**
	 * @return the progressBar
	 */
	public JProgressBar getProgressBar() {
		return progressBar;
	}

	/**
	 * @return the exitButton
	 */
	public JButton getExitButton() {
		return exitButton;
	}

}
