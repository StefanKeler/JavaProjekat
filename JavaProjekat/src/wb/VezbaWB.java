package wb;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VezbaWB extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VezbaWB frame = new VezbaWB();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VezbaWB() {
		setTitle("Naslov");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblPodnaslov = new JLabel("Podnaslov");
		lblPodnaslov.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblPodnaslov, BorderLayout.NORTH);
		
		JPanel pnlCentar = new JPanel();
		contentPane.add(pnlCentar, BorderLayout.CENTER);
		GridBagLayout gbl_pnlCentar = new GridBagLayout();
		gbl_pnlCentar.columnWidths = new int[]{0, 0};
		gbl_pnlCentar.rowHeights = new int[]{0, 0};
		gbl_pnlCentar.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pnlCentar.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		pnlCentar.setLayout(gbl_pnlCentar);
		
		JButton btnKlik = new JButton("Klik");
		btnKlik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Kliknuto je na dugme!", "Poruka", JOptionPane.ERROR_MESSAGE);
			}
		});
		GridBagConstraints gbc_btnKlik = new GridBagConstraints();
		gbc_btnKlik.gridx = 0;
		gbc_btnKlik.gridy = 0;
		pnlCentar.add(btnKlik, gbc_btnKlik);
	}

}
