package wb;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometrija.Oblik;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DijalogZaUnos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfX;
	private JTextField tfY;
	private JTextField tfDuzinaStranice;
	private JTextField tfBojaKonture;
	private JTextField tfBojaUnutrasnjosti;
	JLabel lblPoruka;
	JTextField uzeoFokus = null;
	boolean pritisnutoOk = false;
	String poruka = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogZaUnos dialog = new DijalogZaUnos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */



	public DijalogZaUnos() {
		setTitle("Unos Kvadrata");
		setModal(true);

		setBounds(100, 100, 450, 225);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblX = new JLabel("x:");
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.anchor = GridBagConstraints.EAST;
			gbc_lblX.gridx = 0;
			gbc_lblX.gridy = 0;
			contentPanel.add(lblX, gbc_lblX);
		}
		{
			tfX = new JTextField();

			GridBagConstraints gbc_tfX = new GridBagConstraints();
			gbc_tfX.insets = new Insets(0, 0, 5, 0);
			gbc_tfX.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfX.gridx = 1;
			gbc_tfX.gridy = 0;
			contentPanel.add(tfX, gbc_tfX);
			tfX.setColumns(10);
		}
		{
			JLabel lblY = new JLabel("y:");
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.anchor = GridBagConstraints.EAST;
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.gridx = 0;
			gbc_lblY.gridy = 1;
			contentPanel.add(lblY, gbc_lblY);
		}
		{
			tfY = new JTextField();
			GridBagConstraints gbc_tfY = new GridBagConstraints();
			gbc_tfY.insets = new Insets(0, 0, 5, 0);
			gbc_tfY.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfY.gridx = 1;
			gbc_tfY.gridy = 1;
			contentPanel.add(tfY, gbc_tfY);
			tfY.setColumns(10);
		}
		{
			JLabel lblDuzinaStranice = new JLabel("Duzina stranice:");
			GridBagConstraints gbc_lblDuzinaStranice = new GridBagConstraints();
			gbc_lblDuzinaStranice.anchor = GridBagConstraints.EAST;
			gbc_lblDuzinaStranice.insets = new Insets(0, 0, 5, 5);
			gbc_lblDuzinaStranice.gridx = 0;
			gbc_lblDuzinaStranice.gridy = 2;
			contentPanel.add(lblDuzinaStranice, gbc_lblDuzinaStranice);
		}
		{
			tfDuzinaStranice = new JTextField();
			GridBagConstraints gbc_tfDuzinaStranice = new GridBagConstraints();
			gbc_tfDuzinaStranice.insets = new Insets(0, 0, 5, 0);
			gbc_tfDuzinaStranice.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfDuzinaStranice.gridx = 1;
			gbc_tfDuzinaStranice.gridy = 2;
			contentPanel.add(tfDuzinaStranice, gbc_tfDuzinaStranice);
			tfDuzinaStranice.setColumns(10);
		}
		{
			JLabel lblBojaKonture = new JLabel("Boja konture:");
			GridBagConstraints gbc_lblBojaKonture = new GridBagConstraints();
			gbc_lblBojaKonture.anchor = GridBagConstraints.EAST;
			gbc_lblBojaKonture.insets = new Insets(0, 0, 5, 5);
			gbc_lblBojaKonture.gridx = 0;
			gbc_lblBojaKonture.gridy = 3;
			contentPanel.add(lblBojaKonture, gbc_lblBojaKonture);
		}
		{
			tfBojaKonture = new JTextField();
			GridBagConstraints gbc_tfBojaKonture = new GridBagConstraints();
			gbc_tfBojaKonture.insets = new Insets(0, 0, 5, 0);
			gbc_tfBojaKonture.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfBojaKonture.gridx = 1;
			gbc_tfBojaKonture.gridy = 3;
			contentPanel.add(tfBojaKonture, gbc_tfBojaKonture);
			tfBojaKonture.setColumns(10);
		}
		{
			JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutra\u0161njosti:");
			GridBagConstraints gbc_lblBojaUnutrasnjosti = new GridBagConstraints();
			gbc_lblBojaUnutrasnjosti.anchor = GridBagConstraints.EAST;
			gbc_lblBojaUnutrasnjosti.insets = new Insets(0, 0, 5, 5);
			gbc_lblBojaUnutrasnjosti.gridx = 0;
			gbc_lblBojaUnutrasnjosti.gridy = 4;
			contentPanel.add(lblBojaUnutrasnjosti, gbc_lblBojaUnutrasnjosti);
		}
		{
			tfBojaUnutrasnjosti = new JTextField();
			GridBagConstraints gbc_tfBojaUnutrasnjosti = new GridBagConstraints();
			gbc_tfBojaUnutrasnjosti.insets = new Insets(0, 0, 5, 0);
			gbc_tfBojaUnutrasnjosti.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfBojaUnutrasnjosti.gridx = 1;
			gbc_tfBojaUnutrasnjosti.gridy = 4;
			contentPanel.add(tfBojaUnutrasnjosti, gbc_tfBojaUnutrasnjosti);
			tfBojaUnutrasnjosti.setColumns(10);
		}
		{
			lblPoruka = new JLabel("New label");
			GridBagConstraints gbc_lblPoruka = new GridBagConstraints();
			gbc_lblPoruka.gridwidth = 2;
			gbc_lblPoruka.insets = new Insets(0, 0, 0, 5);
			gbc_lblPoruka.gridx = 0;
			gbc_lblPoruka.gridy = 5;
			contentPanel.add(lblPoruka, gbc_lblPoruka);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			GridBagLayout gbl_buttonPane = new GridBagLayout();
			gbl_buttonPane.columnWidths = new int[]{382, 0};
			gbl_buttonPane.rowHeights = new int[]{23, 0};
			gbl_buttonPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_buttonPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			buttonPane.setLayout(gbl_buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						try{

							Integer.parseInt(tfX.getText());

							Integer.parseInt(tfY.getText());

							Integer.parseInt(tfDuzinaStranice.getText());

							pritisnutoOk = true;

							hide();
							setVisible(false);

						}catch (Exception ex) {

							lblPoruka.setText("Greska u unosu");

						}



					}
				});
				okButton.setActionCommand("OK");
				GridBagConstraints gbc_okButton = new GridBagConstraints();
				gbc_okButton.fill = GridBagConstraints.BOTH;
				gbc_okButton.gridx = 0;
				gbc_okButton.gridy = 0;
				buttonPane.add(okButton, gbc_okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}

		uzeoFokus = tfX;
		System.out.println(uzeoFokus);

		tfX.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent arg0) {
				if(uzeoFokus == tfX){
					try{

						int br = Integer.parseInt(tfX.getText());
						Oblik.proveriBroj(br);
						poruka = "";
						System.out.println("x valja");
						uzeoFokus = null;

					}catch (Exception ex) {
						System.out.println("x ne valja");
						uzeoFokus = tfX;
						poruka = "X mora biti broj > 0";

					}

				}

			}

			public void focusGained(FocusEvent e) {
				if(uzeoFokus != null){
					uzeoFokus.requestFocus();
					uzeoFokus.selectAll();
				}else{
					uzeoFokus = tfX;
				}
				lblPoruka.setText(poruka);
			}
		});

		tfY.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent arg0) {
				if(uzeoFokus == tfY){
					try{

						int br = Integer.parseInt(tfY.getText());
						Oblik.proveriBroj(br);
						poruka = "";
						System.out.println("y valja");
						uzeoFokus = null;


					}catch (Exception ex) {

						uzeoFokus = tfY;
						poruka = "Y mora biti broj > 0";
						System.out.println("y ne valja");
					}

				}

			}

			public void focusGained(FocusEvent e) {
				if(uzeoFokus != null){
					uzeoFokus.requestFocus();
					uzeoFokus.selectAll();
				}else{
					uzeoFokus = tfY;
				}
				lblPoruka.setText(poruka);
			}
		});

		tfDuzinaStranice.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent arg0) {
				if(uzeoFokus == tfDuzinaStranice){
					try{

						int br = Integer.parseInt(tfDuzinaStranice.getText());
						Oblik.proveriBroj(br);

						poruka = "";
						System.out.println("DuzinaStranice valja");
						uzeoFokus = null;


					}catch (Exception ex) {

						uzeoFokus = tfDuzinaStranice;
						poruka = "DuzinaStranice mora biti broj > 0";
						System.out.println("tfDuzinaStranice ne valja");
					}

				}

			}

			public void focusGained(FocusEvent e) {
				if(uzeoFokus != null){
					uzeoFokus.requestFocus();
					uzeoFokus.selectAll();

				}else{
					uzeoFokus = tfDuzinaStranice;
				}
				lblPoruka.setText(poruka);
			}
		});

		tfBojaKonture.addFocusListener(new FocusAdapter() {

			public void focusGained(FocusEvent e) {
				if(uzeoFokus != null){
					uzeoFokus.requestFocus();
					uzeoFokus.selectAll();

				}
				lblPoruka.setText(poruka);
			}
		});

		tfBojaUnutrasnjosti.addFocusListener(new FocusAdapter() {

			public void focusGained(FocusEvent e) {
				if(uzeoFokus != null){
					uzeoFokus.requestFocus();
					uzeoFokus.selectAll();

				}
				lblPoruka.setText(poruka);
			}
		});
	}

	public Boolean isPritisnutoOk(){
		return pritisnutoOk;
	}

	public String getText(){
	
		String bojaKonture = tfBojaKonture.getText();
		if(bojaKonture.equals("")){
			
			bojaKonture = " ";
		}
		String bojaUnutrasnjosti = tfBojaUnutrasnjosti.getText();
		if(bojaUnutrasnjosti.equals("")){
			
			bojaUnutrasnjosti = " ";
		}
		return tfX.getText() + ", " + tfY.getText() + ", " +tfDuzinaStranice.getText() + ", " + bojaKonture + ", " + bojaUnutrasnjosti;
	}

}
