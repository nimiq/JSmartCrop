package com.mydomain.smartcrop.gui;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import com.mydomain.smartcrop.procedure.AbstractProcedure;
import com.mydomain.smartcrop.procedure.Configuration;
import com.mydomain.smartcrop.utils.IOImage;

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
public class OptionFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = 7200972555022037952L;
	private AbstractAction abstractAction1;
	private JTextPane threshIdWhiteTextPane;
	private JPanel postProcPanel;
	private JTextField threshVerWhiteTextField;
	private JTextField threshIdWhiteTextField;
	private JLabel deskewPostLabel;
	private JLabel deskewThreshPreLabel;
	private JPanel preProcPanel;
	private JCheckBox investCheckBox;
	private AbstractAction nextAbstractAction;
	private AbstractAction outFolderAbstractAction;
	private AbstractAction inFolderAbstractAction;
	private JTextField outPathTextField;
	private JTextField inPathTextField;
	private JButton outFolderButton;
	private JButton inFolderButton;
	private JPanel foldersPanel;
	private JButton nextButton;
	private JCheckBox deskewPreCheckBox;
	private JTextField threshDeskPreTextField;
	private JLabel deskewPreLabel;
	private JTextField satPostTextField;
	private JTextField threshDeskPostTextField;
	private JCheckBox stretchPostCheckBox;
	private JCheckBox grayPostCheckBox;
	private JCheckBox deskewPostCheckBox;
	private JLabel satThreshPostLabel;
	private JLabel stretchPostLabel;
	private JLabel grayPostLabel;
	private JLabel deskewThreshPostLabel;
	private JTextField threshTextField;
	private JTextPane threshVerWhiteTextPane;
	private JLabel stdScoreThresholdLabel;
	private JPanel stdScorePanel;
	private AbstractProcedure procedure;
	private Configuration conf;
	private File folderOut;
	private File folderIn;

	public OptionFrame(AbstractProcedure procedure) {
		super();
		this.procedure = procedure;
		initGUI();
		Font f = stdScoreThresholdLabel.getFont();
		stdScoreThresholdLabel.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD));
		f = deskewPostLabel.getFont();
		deskewPostLabel.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD));
		f = deskewThreshPostLabel.getFont();
		deskewThreshPostLabel.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD));
		f = grayPostLabel.getFont();
		grayPostLabel.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD));
		f = stretchPostLabel.getFont();
		stretchPostLabel.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD));
		f = satThreshPostLabel.getFont();
		satThreshPostLabel.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD));
		f = deskewPreLabel.getFont();
		deskewPreLabel.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD));
		f = deskewThreshPreLabel.getFont();
		deskewThreshPreLabel.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD));		
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(getPostProcPanel(), GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
				        .addGap(22)
				        .addComponent(getPreProcPanel(), GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(getFoldersPanel(), GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addComponent(getStdScorePanel(), GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)))
				.addGap(0, 17, Short.MAX_VALUE)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getNextButton(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getInvestCheckBox(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
				.addContainerGap());
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(getFoldersPanel(), GroupLayout.Alignment.LEADING, 0, 209, Short.MAX_VALUE)
				    .addGroup(thisLayout.createSequentialGroup()
				        .addGap(0, 0, Short.MAX_VALUE)
				        .addComponent(getStdScorePanel(), GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(getInvestCheckBox(), GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 33, Short.MAX_VALUE)))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(getPostProcPanel(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getPreProcPanel(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGap(103)
				        .addComponent(getNextButton(), GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap());
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			this.setSize(452, 342);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private AbstractAction getAbstractAction1() {
		if(abstractAction1 == null) {
			abstractAction1 = new AbstractAction("abstractAction1", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 5288600729493157660L;

				public void actionPerformed(ActionEvent evt) {
				}
			};
		}
		return abstractAction1;
	}
	
	private JPanel getStdScorePanel() {
		if(stdScorePanel == null) {
			stdScorePanel = new JPanel();
			GridBagLayout stdScorePanelLayout = new GridBagLayout();
			stdScorePanel.setLayout(stdScorePanelLayout);
			stdScorePanel.setBorder(BorderFactory.createTitledBorder("Std Score"));
			stdScorePanel.add(getThreshTextField(), new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			stdScorePanel.add(getJTextField1(), new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			stdScorePanel.add(getJTextField1x(), new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			stdScorePanel.add(getJTextPane1(), new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			stdScorePanel.add(getThreshIdWhiteTextPane(), new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			stdScorePanel.add(getStdScoreThresholdLabel(), new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			stdScorePanelLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.1};
			stdScorePanelLayout.rowHeights = new int[] {35, 35, 35, 7};
			stdScorePanelLayout.columnWeights = new double[] {0.0, 0.0, 0.1, 0.0};
			stdScorePanelLayout.columnWidths = new int[] {10, 129, 7, 10};
		}
		return stdScorePanel;
	}
	
	private JLabel getStdScoreThresholdLabel() {
		if(stdScoreThresholdLabel == null) {
			stdScoreThresholdLabel = new JLabel();
			stdScoreThresholdLabel.setText("Soglia test statistico");
		}
		return stdScoreThresholdLabel;
	}
	
	private JTextPane getThreshIdWhiteTextPane() {
		if(threshIdWhiteTextPane == null) {
			threshIdWhiteTextPane = new JTextPane();
			threshIdWhiteTextPane.setText("Soglia indentificazione\r\nextra bordo bianco");
			threshIdWhiteTextPane.setEditable(false);
			threshIdWhiteTextPane.setOpaque(false);
			threshIdWhiteTextPane.setAlignmentX(0.0f);
			threshIdWhiteTextPane.setAlignmentY(0.0f);
			threshIdWhiteTextPane.setMargin(new java.awt.Insets(0, 0, 0, 0));
		}
		return threshIdWhiteTextPane;
	}
	
	private JTextPane getJTextPane1() {
		if(threshVerWhiteTextPane == null) {
			threshVerWhiteTextPane = new JTextPane();
			threshVerWhiteTextPane.setText("Soglia verifica\r\nextra bordo bianco");
			threshVerWhiteTextPane.setEditable(false);
			threshVerWhiteTextPane.setMargin(new java.awt.Insets(0, 0, 0, 0));
			threshVerWhiteTextPane.setOpaque(false);
			threshVerWhiteTextPane.setAlignmentX(0.0f);
			threshVerWhiteTextPane.setAlignmentY(0.0f);
		}
		return threshVerWhiteTextPane;
	}
	
	private JTextField getThreshTextField() {
		if(threshTextField == null) {
			threshTextField = new JTextField();
			threshTextField.setText("-1.5");
		}
		return threshTextField;
	}
	
	private JTextField getJTextField1() {
		if(threshIdWhiteTextField == null) {
			threshIdWhiteTextField = new JTextField();
			threshIdWhiteTextField.setText("60");
		}
		return threshIdWhiteTextField;
	}
	
	private JTextField getJTextField1x() {
		if(threshVerWhiteTextField == null) {
			threshVerWhiteTextField = new JTextField();
			threshVerWhiteTextField.setText("7");
		}
		return threshVerWhiteTextField;
	}
	
	private JPanel getPostProcPanel() {
		if(postProcPanel == null) {
			postProcPanel = new JPanel();
			GridBagLayout postProcPanelLayout = new GridBagLayout();
			postProcPanel.setLayout(postProcPanelLayout);
			postProcPanel.setBorder(BorderFactory.createTitledBorder("Post-processing"));
			postProcPanel.add(getSatPostTextField(), new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			postProcPanel.add(getDeskewPostCheckBox(), new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			postProcPanel.add(getGrayPostCheckBox(), new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			postProcPanel.add(getStretchPostCheckBox(), new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			postProcPanel.add(getThreshDeskPostTextField(), new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			postProcPanel.add(getDeskewThreshPostLabel(), new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			postProcPanel.add(getDeskewPostLabel(), new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			postProcPanel.add(getGrayPostLabel(), new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			postProcPanel.add(getStretchPostLabel(), new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			postProcPanel.add(getSatThreshPostLabel(), new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			postProcPanelLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.1};
			postProcPanelLayout.rowHeights = new int[] {23, 23, 23, 23, 23, 7};
			postProcPanelLayout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.1};
			postProcPanelLayout.columnWidths = new int[] {10, 132, 33, 7};
		}
		return postProcPanel;
	}
	
	private JLabel getDeskewPostLabel() {
		if(deskewPostLabel == null) {
			deskewPostLabel = new JLabel();
			deskewPostLabel.setText("Raddrizza");
		}
		return deskewPostLabel;
	}
	
	private JLabel getDeskewThreshPostLabel() {
		if(deskewThreshPostLabel == null) {
			deskewThreshPostLabel = new JLabel();
			deskewThreshPostLabel.setText("Grad min raddrizza");
		}
		return deskewThreshPostLabel;
	}
	
	private JLabel getGrayPostLabel() {
		if(grayPostLabel == null) {
			grayPostLabel = new JLabel();
			grayPostLabel.setText("Scala di grigi");
		}
		return grayPostLabel;
	}
	
	private JLabel getStretchPostLabel() {
		if(stretchPostLabel == null) {
			stretchPostLabel = new JLabel();
			stretchPostLabel.setText("Incrementa contrasto");
		}
		return stretchPostLabel;
	}
	
	private JLabel getSatThreshPostLabel() {
		if(satThreshPostLabel == null) {
			satThreshPostLabel = new JLabel();
			satThreshPostLabel.setText("% saturazione");
		}
		return satThreshPostLabel;
	}
	
	private JCheckBox getDeskewPostCheckBox() {
		if(deskewPostCheckBox == null) {
			deskewPostCheckBox = new JCheckBox();
		}
		return deskewPostCheckBox;
	}
	
	private JCheckBox getGrayPostCheckBox() {
		if(grayPostCheckBox == null) {
			grayPostCheckBox = new JCheckBox();
			grayPostCheckBox.setSelected(true);
		}
		return grayPostCheckBox;
	}
	
	private JCheckBox getStretchPostCheckBox() {
		if(stretchPostCheckBox == null) {
			stretchPostCheckBox = new JCheckBox();
			stretchPostCheckBox.setSelected(true);
		}
		return stretchPostCheckBox;
	}
	
	private JTextField getThreshDeskPostTextField() {
		if(threshDeskPostTextField == null) {
			threshDeskPostTextField = new JTextField();
			threshDeskPostTextField.setText("0.5");
		}
		return threshDeskPostTextField;
	}
	
	private JTextField getSatPostTextField() {
		if(satPostTextField == null) {
			satPostTextField = new JTextField();
			satPostTextField.setText("5");
		}
		return satPostTextField;
	}
	
	private JPanel getPreProcPanel() {
		if(preProcPanel == null) {
			preProcPanel = new JPanel();
			GridBagLayout preProcPanelLayout = new GridBagLayout();
			preProcPanel.setLayout(preProcPanelLayout);
			preProcPanel.setBorder(BorderFactory.createTitledBorder("Pre-processing"));
			preProcPanel.add(getJLabel2(), new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			preProcPanel.add(getJLabel3(), new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			preProcPanel.add(getJCheckBox1(), new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			preProcPanel.add(getJTextField1xx(), new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			preProcPanelLayout.rowWeights = new double[] {0.0, 0.0, 0.1};
			preProcPanelLayout.rowHeights = new int[] {23, 25, 20};
			preProcPanelLayout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.0};
			preProcPanelLayout.columnWidths = new int[] {10, 132, 47, 12};
		}
		return preProcPanel;
	}
	
	private JLabel getJLabel2() {
		if(deskewPreLabel == null) {
			deskewPreLabel = new JLabel();
			deskewPreLabel.setText("Raddrizza");
		}
		return deskewPreLabel;
	}
	
	private JLabel getJLabel3() {
		if(deskewThreshPreLabel == null) {
			deskewThreshPreLabel = new JLabel();
			deskewThreshPreLabel.setText("Grad min raddrizza");
		}
		return deskewThreshPreLabel;
	}
	
	private JCheckBox getJCheckBox1() {
		if(deskewPreCheckBox == null) {
			deskewPreCheckBox = new JCheckBox();
		}
		return deskewPreCheckBox;
	}
	
	private JTextField getJTextField1xx() {
		if(threshDeskPreTextField == null) {
			threshDeskPreTextField = new JTextField();
			threshDeskPreTextField.setText("0.5");
			threshDeskPreTextField.setSize(50, 23);
			threshDeskPreTextField.setToolTipText("xfgvd");
		}
		return threshDeskPreTextField;
	}
	
	private JButton getNextButton() {
		if(nextButton == null) {
			nextButton = new JButton();
			nextButton.setText("Avanti >");
			nextButton.setSize(89, 23);
			nextButton.setAction(getNextAbstractAction());
		}
		return nextButton;
	}
	
	private JPanel getFoldersPanel() {
		if(foldersPanel == null) {
			foldersPanel = new JPanel();
			GridBagLayout foldersPanelLayout = new GridBagLayout();
			foldersPanel.setBorder(BorderFactory.createTitledBorder("Cartelle"));
			foldersPanelLayout.rowWeights = new double[] {0.1, 0.1, 0.0};
			foldersPanelLayout.rowHeights = new int[] {7, 7, 7};
			foldersPanelLayout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.0};
			foldersPanelLayout.columnWidths = new int[] {7, 74, 110, 9};
			foldersPanel.setLayout(foldersPanelLayout);
			foldersPanel.add(getInFolderButton(), new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			foldersPanel.add(getOutFolderButton(), new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			foldersPanel.add(getInPathTextField(), new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			foldersPanel.add(getOutPathTextField(), new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		}
		return foldersPanel;
	}
	
	private JButton getInFolderButton() {
		if(inFolderButton == null) {
			inFolderButton = new JButton();
			inFolderButton.setText("Sfoglia");
			inFolderButton.setFont(new java.awt.Font("Segoe UI",0,10));
			inFolderButton.setAction(getInFolderAbstractAction());
		}
		return inFolderButton;
	}
	
	private JButton getOutFolderButton() {
		if(outFolderButton == null) {
			outFolderButton = new JButton();
			outFolderButton.setText("Sfoglia");
			outFolderButton.setFont(new java.awt.Font("Segoe UI",0,10));
			outFolderButton.setAction(getOutFolderAbstractAction());
		}
		return outFolderButton;
	}
	
	private JTextField getInPathTextField() {
		if(inPathTextField == null) {
			inPathTextField = new JTextField();
			inPathTextField.setText("input folder...");
			inPathTextField.setEditable(false);
		}
		return inPathTextField;
	}
	
	private JTextField getOutPathTextField() {
		if(outPathTextField == null) {
			outPathTextField = new JTextField();
			outPathTextField.setText("output folder...");
			outPathTextField.setEditable(false);
		}
		return outPathTextField;
	}
	
	private AbstractAction getInFolderAbstractAction() {
		if(inFolderAbstractAction == null) {
			inFolderAbstractAction = new AbstractAction("Sfoglia", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = -4489291593048573153L;

				public void actionPerformed(ActionEvent evt) {
					JFileChooser chooser = new JFileChooser();
					chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					chooser.setAcceptAllFileFilterUsed(false);

					if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
						folderIn = chooser.getSelectedFile();
						inPathTextField.setText(folderIn.getName());
					}					
				}
			};
		}
		return inFolderAbstractAction;
	}
	
	private AbstractAction getOutFolderAbstractAction() {
		if(outFolderAbstractAction == null) {
			outFolderAbstractAction = new AbstractAction("Sfoglia", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = -3512151869799062120L;

				public void actionPerformed(ActionEvent evt) {
					JFileChooser chooser = new JFileChooser();
					chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					chooser.setAcceptAllFileFilterUsed(false);

					if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
						folderOut = chooser.getSelectedFile();
						outPathTextField.setText(folderOut.getName());
					}						
				}
			};
		}
		return outFolderAbstractAction;
	}
	
	private AbstractAction getNextAbstractAction() {
		if(nextAbstractAction == null) {
			nextAbstractAction = new AbstractAction("Avanti >", null) {
				public void actionPerformed(ActionEvent evt) {
					
			        String inFolder = folderIn.getPath() + System.getProperty("file.separator");
			        String outFolder = folderOut.getPath() + System.getProperty("file.separator");
			        
					conf = new Configuration();
					readConfiguration(conf);
					procedure.setConfiguration(conf);
			        
					if (investCheckBox.isSelected()) {
						String[] ar = createFileNamesArray(inFolder);
						InvestigationFrame inst = new InvestigationFrame(ar, inFolder, conf, procedure);
						inst.setLocationRelativeTo(null);
						inst.setVisible(true);
						dispose();
					} else {
						ProgressFrame inst = new ProgressFrame();
						inst.setLocationRelativeTo(null);
						inst.setVisible(true);
						dispose();
				        (new Thread(new ScanManager(inFolder, outFolder, conf, procedure, inst))).start();
					}
					
				}
			};
		}
		return nextAbstractAction;
	}
	
	private void readConfiguration(Configuration conf) {
		
		try {
		conf.setThresholdStdDev(Float.valueOf(threshTextField.getText()));
		conf.setWhiteExtraBorderIdentificationPolicy(Integer.valueOf(threshIdWhiteTextField.getText()));
		conf.setWhiteExtraBorderVerificationPolicy(Integer.valueOf(threshVerWhiteTextField.getText()));
		conf.setDeskewDuringPostProcessing(deskewPostCheckBox.isSelected());
		conf.setDeskewThresholdPost(Float.valueOf(threshDeskPostTextField.getText()));
		conf.setGrayscaleDuringPostProcessing(grayPostCheckBox.isSelected());
		conf.setStretchHistogramDuringPostProcessing(stretchPostCheckBox.isSelected());
		conf.setStretchHistogramThresholdDuringPostProcessing(Integer.valueOf(satPostTextField.getText()));
		conf.setDeskewDuringPreProcessing(deskewPreCheckBox.isSelected());
		conf.setDeskewThresholdPre(Float.valueOf(threshDeskPreTextField.getText()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Correggere i parametri di configurazione", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private JCheckBox getInvestCheckBox() {
		if(investCheckBox == null) {
			investCheckBox = new JCheckBox();
			investCheckBox.setText("Procedura investigativa");
		}
		return investCheckBox;
	}
	
	private String[] createFileNamesArray(String inFolder) {
		List<String> s = new ArrayList<String>();
		
        File folder = new File(inFolder);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
	            BufferedImage image = IOImage.getImage(file.getPath());
	            // Checking if the file is an image
	            try {
	            	image.getWidth();
	            	s.add(file.getName().toString());
	            } catch (Exception e) {
	                continue;
	            }
            }
        }
        String[] as = new String[listOfFiles.length];
		return s.toArray(as);
	}

}
