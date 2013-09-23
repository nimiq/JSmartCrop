package com.mydomain.smartcrop.gui;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.Enumeration;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import com.mydomain.smartcrop.procedure.AbstractProcedure;
import com.mydomain.smartcrop.procedure.AccurateProcedure;
import com.mydomain.smartcrop.procedure.QuickProcedure;
import com.mydomain.smartcrop.procedure.RegularProcedure;


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
public class MainFrame extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5318578046646401676L;
	private JPanel procedurePanel;
	private JButton exitButton;
	private AbstractAction nextAbstractAction;
	private AbstractAction exitAbstractAction;
	private JButton nextButton;
	private AbstractAction accurateProcedureSelectedAbstractAction;
	private JRadioButton quickProcedureRadioButton;
	private ButtonGroup procedureButtonGroup;
	private JTextPane jTextPane1;
	private AbstractAction abstractAction1;
	private AbstractAction regularProcedureSelectedAbstractAction;
	private AbstractAction quickProcedureSelectedAbstractAction;
	private JLabel procedureInfoLabel;
	private JTextPane procedureDescriptionTextPane;
	private JRadioButton accurateRadioButton;
	private JRadioButton regularRadioButton;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame inst = new MainFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MainFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				procedurePanel = new JPanel();
				GroupLayout procedurePanelLayout = new GroupLayout((JComponent)procedurePanel);
				procedurePanel.setLayout(procedurePanelLayout);
				procedurePanel.setBorder(BorderFactory.createTitledBorder("Procedura"));
				{
					quickProcedureRadioButton = new JRadioButton();
					quickProcedureRadioButton.setText("Veloce");
					quickProcedureRadioButton.setSelected(true);
					quickProcedureRadioButton.setAction(getQuickProcedureSelectedAbstractAction());
					getProcedureButtonGroup().add(quickProcedureRadioButton);
				}
				{
					regularRadioButton = new JRadioButton();
					regularRadioButton.setText("Normale");
					regularRadioButton.setAction(getRegularProcedureSelectedAbstractAction());
					getProcedureButtonGroup().add(regularRadioButton);
				}
				{
					accurateRadioButton = new JRadioButton();
					accurateRadioButton.setText("Accurata");
					accurateRadioButton.setAction(getAccurateProcedureSelectedAbstractAction());
					getProcedureButtonGroup().add(accurateRadioButton);
				}
					procedurePanelLayout.setHorizontalGroup(procedurePanelLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(procedurePanelLayout.createParallelGroup()
					    .addGroup(GroupLayout.Alignment.LEADING, procedurePanelLayout.createSequentialGroup()
					        .addGroup(procedurePanelLayout.createParallelGroup()
					            .addComponent(quickProcedureRadioButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					            .addGroup(GroupLayout.Alignment.LEADING, procedurePanelLayout.createSequentialGroup()
					                .addComponent(getProcedureInfoLabel(), GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					                .addGap(31)))
					        .addGap(47)
					        .addComponent(regularRadioButton, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					        .addGap(25)
					        .addComponent(accurateRadioButton, 0, 92, Short.MAX_VALUE))
					    .addGroup(GroupLayout.Alignment.LEADING, procedurePanelLayout.createSequentialGroup()
					        .addComponent(getProcedureDescriptionTextPane(), 0, 313, Short.MAX_VALUE)
					        .addGap(12))
					    .addGroup(GroupLayout.Alignment.LEADING, procedurePanelLayout.createSequentialGroup()
					        .addComponent(getJTextPane1(), 0, 313, Short.MAX_VALUE)
					        .addGap(0, 12, GroupLayout.PREFERRED_SIZE))));
					procedurePanelLayout.setVerticalGroup(procedurePanelLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(getJTextPane1(), 0, 42, Short.MAX_VALUE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(procedurePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(quickProcedureRadioButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(regularRadioButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(accurateRadioButton, GroupLayout.Alignment.BASELINE, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(16)
					.addComponent(getProcedureInfoLabel(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(getProcedureDescriptionTextPane(), 0, 44, Short.MAX_VALUE)
					.addContainerGap());
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(procedurePanel, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getNextButton(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getExitButton(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap());
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(procedurePanel, GroupLayout.Alignment.LEADING, 0, 347, Short.MAX_VALUE)
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGap(0, 158, Short.MAX_VALUE)
				        .addComponent(getExitButton(), GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, 1, GroupLayout.PREFERRED_SIZE)
				        .addComponent(getNextButton(), GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap());
			thisLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {getExitButton(), getNextButton()});
			pack();
			this.setSize(387, 291);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private ButtonGroup getProcedureButtonGroup() {
		if(procedureButtonGroup == null) {
			procedureButtonGroup = new ButtonGroup();
		}
		return procedureButtonGroup;
	}

	private JTextPane getProcedureDescriptionTextPane() {
		if(procedureDescriptionTextPane == null) {
			procedureDescriptionTextPane = new JTextPane();
			procedureDescriptionTextPane.setText("Procedura 1.5x più rapida che ottiene buoni risultati con immagini e bordi ben definiti");
			procedureDescriptionTextPane.setEditable(false);
			procedureDescriptionTextPane.setBackground(new java.awt.Color(212,208,200));
			procedureDescriptionTextPane.setOpaque(false);
		}
		return procedureDescriptionTextPane;
	}
	
	private JTextPane getJTextPane1() {
		if(jTextPane1 == null) {
			jTextPane1 = new JTextPane();
			jTextPane1.setText("Seleziona la procedura desiderata per l'ottimizzazione e il ritaglio dei bordi neri:");
			jTextPane1.setEditable(false);
			jTextPane1.setEnabled(true);
			jTextPane1.setBackground(new java.awt.Color(212,208,200));
			jTextPane1.setOpaque(false);
		}
		return jTextPane1;
	}
	
	private JLabel getProcedureInfoLabel() {
		if(procedureInfoLabel == null) {
			procedureInfoLabel = new JLabel();
			procedureInfoLabel.setText("Info:");
		}
		return procedureInfoLabel;
	}

	private AbstractAction getQuickProcedureSelectedAbstractAction() {
		if(quickProcedureSelectedAbstractAction == null) {
			quickProcedureSelectedAbstractAction = new AbstractAction("Veloce", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = -6708136424561193527L;

				public void actionPerformed(ActionEvent evt) {
					getProcedureDescriptionTextPane().setText("Procedura 1.5x più rapida che ottiene buoni risultati con immagini e bordi ben definiti");
				}
			};
		}
		return quickProcedureSelectedAbstractAction;
	}
	
	private AbstractAction getRegularProcedureSelectedAbstractAction() {
		if(regularProcedureSelectedAbstractAction == null) {
			regularProcedureSelectedAbstractAction = new AbstractAction("Normale", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 3650752537773317150L;

				public void actionPerformed(ActionEvent evt) {
					getProcedureDescriptionTextPane().setText("Procedura classica che garantisce buoni risultati");
				}
			};
		}
		return regularProcedureSelectedAbstractAction;
	}
	
	private AbstractAction getAccurateProcedureSelectedAbstractAction() {
		if(accurateProcedureSelectedAbstractAction == null) {
			accurateProcedureSelectedAbstractAction = new AbstractAction("Accurata", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 5073237378898521151L;

				public void actionPerformed(ActionEvent evt) {
					getProcedureDescriptionTextPane().setText("Procedura 1.5x più lenta che garantisce ottimi risultati con qualunque immagine e bordo");
				}
			};
		}
		return accurateProcedureSelectedAbstractAction;
	}
	
	private JButton getNextButton() {
		if(nextButton == null) {
			nextButton = new JButton();
			nextButton.setText("Avanti >");
			nextButton.setAction(getNextAbstractAction());
		}
		return nextButton;
	}
	
	private JButton getExitButton() {
		if(exitButton == null) {
			exitButton = new JButton();
			exitButton.setText("Esci");
			exitButton.setAction(getExitAbstractAction());
		}
		return exitButton;
	}
	
	private AbstractAction getExitAbstractAction() {
		if(exitAbstractAction == null) {
			exitAbstractAction = new AbstractAction("Esci", null) {
				private static final long serialVersionUID = 5073237378898521151L;

				public void actionPerformed(ActionEvent evt) {
					System.exit(0);
				}
			};
		}
		return exitAbstractAction;
	}
	
	private AbstractAction getNextAbstractAction() {
		if(nextAbstractAction == null) {
			nextAbstractAction = new AbstractAction("Avanti >", null) {
				private static final long serialVersionUID = 7778725459789210281L;

				public void actionPerformed(ActionEvent evt) {
					String selected = "";
			        for (Enumeration<AbstractButton> buttons = getProcedureButtonGroup().getElements(); buttons.hasMoreElements();) {
			            AbstractButton button = buttons.nextElement();
			            if (button.isSelected())
			                selected = button.getText();
			        }
			        AbstractProcedure procedure;
			        if (selected.equalsIgnoreCase("rapida"))
			        	procedure = new QuickProcedure();
			        else if (selected.equalsIgnoreCase("accurata"))
			        	procedure = new AccurateProcedure();
			        else
			        	procedure = new RegularProcedure();
			        
					OptionFrame inst = new OptionFrame(procedure);
					inst.setLocationRelativeTo(null);
					inst.setVisible(true);
					dispose();
				}
			};
		}
		return nextAbstractAction;
	}

}
