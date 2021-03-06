package com.dtt.lgsp.app;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Timer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.dtt.lgsp.app.LogViewer.Item;
import com.dtt.lgsp.app.business.DttConsumer;
import com.dtt.lgsp.app.config.PreferencesConfiguration;
import com.dtt.lgsp.app.core.LoaiHoSoEnum;
import com.dtt.lgsp.app.cron.DttCron;
import com.dtt.lgsp.app.cron.ImportCron;
import com.dtt.lgsp.app.cron.ImportFileProcess;
import com.dtt.lgsp.app.cron.KetQuaCron;
import com.dtt.lgsp.data.handler.ReadExcelData;
import com.dtt.lgsp.entities.ProfileEntity;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class SettingViewer extends JPanel {
	static final Logger logger = Logger.getLogger(RegisterViewer.class);
	JFileChooser chooser;
	String choosertitle;
	private JPanel parentPanel;
	JLabel lblPath;
	JCheckBox cbPath;
	private JTextPane txtpnThongBao;
	private JScrollPane scrollPane;
	boolean useFolder;
	private JTextField txtSecondRun;
	JComboBox cbBoxLoaiDuLieu;
	
	private JPanel panel1;
	private JPanel panel2;
	
	JFileChooser chooserFile;
	JLabel lblPath_1;
	
	static JTextArea txtLog2;
	static JScrollPane scrollPane_1;
	
	public JTextArea gettxtLog2() {
		txtLog2 = new JTextArea();
		txtLog2.setBorder(BorderFactory.createCompoundBorder(
				txtLog2.getBorder(), 
		        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		scrollPane_1 = new JScrollPane();
		return txtLog2;
	}

	public SettingViewer() {
		//createUI();
		//gettxtLog2();
	}

	public void createUI() {
		ProfileEntity profileEntity = PreferencesConfiguration.getConfig();
		setLayout(null);
		// khoi tao parentPanel
		parentPanel = new JPanel();
		parentPanel.setLocation(0, 0);
		parentPanel.setOpaque(false);
		parentPanel.setSize(770, 570);
		parentPanel.setLayout(null);
		
		panel1 = creatPanel1(profileEntity);
		
		panel2 = creatPanel2(profileEntity);	
		
		
		ImageIcon folderIcon = new ImageIcon(SettingViewer.class.getResource("/images/folder-icon.png"));
		ImageIcon importIcon = new ImageIcon(SettingViewer.class.getResource("/images/import-21-723160.png"));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("");
		tabbedPane.setBounds(0, 0, 770, 570);
		
		tabbedPane.addTab("C???u h??nh th?? m???c ?????ng b???", folderIcon, panel1,"C???u h??nh th?? m???c ?????ng b???");
		tabbedPane.addTab("Import file", importIcon, panel2,"XML");
		
		
		add(parentPanel);

		parentPanel.add(tabbedPane);
	}
	
	private JPanel creatPanel2(ProfileEntity profileEntity) {
		// khoi tao panel2 import file truc tiep
		panel2 = new JPanel();
		panel2.setLocation(0, 11);
		panel2.setOpaque(false);
		panel2.setSize(770, 570);
		panel2.setLayout(null);
		
		
		JLabel lblNewLabel_2 = new JLabel("Ch???n File ????? ?????ng b???");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 55, 153, 17);
		panel2.add(lblNewLabel_2);
		
		lblPath_1 = new JLabel("");
		lblPath_1.setForeground(new Color(0, 0, 128));
		lblPath_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPath_1.setBounds(313, 55, 426, 20);
		panel2.add(lblPath_1);
		
		JButton btnFile = new JButton("Ch???n file...");
		btnFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooserFile = new JFileChooser();
				chooserFile.setCurrentDirectory(new java.io.File("."));
				chooserFile.setDialogTitle(choosertitle);
				chooserFile.setFileSelectionMode(JFileChooser.FILES_ONLY);
				
				chooserFile.setAcceptAllFileFilterUsed(false);
				//
				if (chooserFile.showOpenDialog(panel2) == JFileChooser.APPROVE_OPTION) {
					logger.info("file ???? ch???n: " + chooserFile.getSelectedFile());
					lblPath_1.setText(chooserFile.getSelectedFile().toString());
					profileEntity.setUrlWs(chooserFile.getSelectedFile().toString());
					PreferencesConfiguration.buildConfig(profileEntity);
				}
			}
		});
		btnFile.setBounds(173, 54, 130, 23);
		panel2.add(btnFile);
		
		JButton btnDongBoFile = new JButton("?????ng b???");
		btnDongBoFile.addActionListener(new RunFileActionListener());
		btnDongBoFile.setBounds(173, 92, 130, 23);
		panel2.add(btnDongBoFile);
		
		txtLog2.setForeground(new Color(50, 205, 50));
		txtLog2.setEditable(false);
		txtLog2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtLog2.setBackground(Color.BLACK);
		txtLog2.setLineWrap(true);
		txtLog2.setWrapStyleWord(true);
		
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 140, 745, 314);
		scrollPane_1.add(txtLog2);
		scrollPane_1.setViewportView(txtLog2);
		
		panel2.add(scrollPane_1);
		
		return panel2;
	}
	
	 private JPanel creatPanel1(ProfileEntity profileEntity) {
			// khoi tao panel cau hinh thu muc
			panel1 = new JPanel();
			panel1.setLocation(0, 11);
			panel1.setOpaque(false);
			panel1.setSize(770, 570);
			panel1.setLayout(null);
			

			JLabel lblNewLabel_2 = new JLabel("Th?? m???c ngu???n");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_2.setForeground(new Color(0, 0, 0));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_2.setBounds(10, 22, 205, 17);
			panel1.add(lblNewLabel_2);

			cbPath = new JCheckBox("");
			cbPath.setHorizontalAlignment(SwingConstants.CENTER);
			cbPath.setForeground(Color.WHITE);
			cbPath.setBounds(230, 33, 21, 21);
			cbPath.setFont(new Font("Tahoma", Font.BOLD, 14));
			cbPath.setSelected(useFolder);
			panel1.add(cbPath);

			lblPath = new JLabel("");
			lblPath.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblPath.setForeground(new Color(0, 0, 128));
			lblPath.setBounds(390, 33, 365, 20);
			lblPath.setText(profileEntity.getFolder());
			panel1.add(lblPath);

			JButton btnFolderHSVV = new JButton("Ch???n th?? m???c...");
			btnFolderHSVV.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					chooser = new JFileChooser();
					chooser.setCurrentDirectory(new java.io.File("."));
					chooser.setDialogTitle(choosertitle);
					chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					//
					// disable the "All files" option.
					//
					chooser.setAcceptAllFileFilterUsed(false);
					//
					if (chooser.showOpenDialog(panel1) == JFileChooser.APPROVE_OPTION) {
						System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
						System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
//						pathFileHSVV = chooser.getSelectedFile().getAbsolutePath();

						lblPath.setText(chooser.getSelectedFile().getAbsolutePath());
					}
				}
			});
			btnFolderHSVV.setBounds(255, 33, 130, 23);
			panel1.add(btnFolderHSVV);

			JSeparator separator = new JSeparator();
			separator.setBackground(Color.BLACK);
			separator.setBounds(614, 43, 0, 2);
			panel1.add(separator);

			JButton btnNewButton = new JButton("Ki???m tra d???ch v???");
			btnNewButton.setBackground(Color.WHITE);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String strPingHost = "";
					try {
						strPingHost = DttConsumer.pingHost();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(txtSecondRun,
								"L???i k???t n???i, ki???m tra l???i ???????ng d???n d???ch v???: " + e2.getMessage(), "DRG",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					if (StringUtils.isNotEmpty(strPingHost)) {
						JOptionPane.showMessageDialog(txtSecondRun,
								"L???i k???t n???i, ki???m tra l???i ???????ng d???n d???ch v???: " + strPingHost, "DRG",
								JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(txtSecondRun, "K???t n???i d???ch v??? th??nh c??ng", "BYT_TTDL_4210 Client",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
			btnNewButton.setForeground(new Color(0, 0, 255));
			btnNewButton.setIcon(new ImageIcon(SettingViewer.class.getResource("/images/worldwide.png")));
			btnNewButton.setBounds(390, 103, 160, 30);
			panel1.add(btnNewButton);

			JLabel lblThiGianChy = new JLabel("Th\u1EDDi gian ch\u1EA1y (gi\u00E2y)");
			lblThiGianChy.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblThiGianChy.setForeground(new Color(0, 0, 0));
			lblThiGianChy.setHorizontalAlignment(SwingConstants.RIGHT);
			lblThiGianChy.setBounds(44, 109, 165, 17);
			panel1.add(lblThiGianChy);

			txtSecondRun = new JTextField();
			txtSecondRun.setBounds(228, 110, 157, 23);
			txtSecondRun.setText(profileEntity.getSecondRun() + "");
			panel1.add(txtSecondRun);
			txtSecondRun.setColumns(10);

			JButton btnUpdate = new JButton("L??u v?? g???i h??? s??");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int secondRun = Integer.valueOf(txtSecondRun.getText());
					if (secondRun < 60) {
						JOptionPane.showMessageDialog(txtSecondRun,
								"L??u th??ng tin kh??ng th??nh c??ng: Th???i gian ch???y ph???i l???n h??n 60 gi??y", "DRG",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					useFolder = cbPath.isSelected();

					// xoa cau hinh cu
//						PropertieConfiguration proConfig = PropertieConfiguration.getInstance();
//						String urlApi = proConfig.getProperty("ws.api");
					// luu thiet lap cau hinh moi
					ProfileEntity profileEntityold = PreferencesConfiguration.getConfig();
					Item loaiHoSoItem = (Item) cbBoxLoaiDuLieu.getSelectedItem();
					int loaiHoSo = loaiHoSoItem.getId();
					if(loaiHoSo == 0) {
						JOptionPane.showMessageDialog(cbBoxLoaiDuLieu,
								"L??u th??ng tin kh??ng th??nh c??ng: B???n ph???i ch???n lo???i d??? li???u", "DRG",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					profileEntityold.setLoaiHoSo(loaiHoSo);
					if (chooser != null) { 
						profileEntityold.setFolder(chooser.getSelectedFile().getAbsolutePath());
					}
					PreferencesConfiguration.buildConfig(profileEntityold);
					SystemTrayLgsp.timerPut.cancel();
					SystemTrayLgsp.timerGet.cancel();
					SystemTrayLgsp.timerCountDown.cancel();
					SystemTrayLgsp.timerPut.purge();
					SystemTrayLgsp.timerGet.purge();
					SystemTrayLgsp.timerCountDown.purge();

					SystemTrayLgsp.timerPut = new Timer();
					SystemTrayLgsp.timerGet = new Timer();
					SystemTrayLgsp.timerCountDown = new Timer();

					DttCron dttCron = new DttCron();
					dttCron.setProfileEntity(profileEntityold);
					KetQuaCron ketQuaCron = new KetQuaCron();
					ketQuaCron.setProfileEntity(profileEntityold);
					CountDown countDown = new CountDown();
					countDown.setCounter(Integer.valueOf(Integer.valueOf(txtSecondRun.getText())));
					SystemTrayLgsp.timerPut.scheduleAtFixedRate(dttCron, 0,
							Integer.valueOf(Integer.valueOf(txtSecondRun.getText()) * 1000));
					SystemTrayLgsp.timerGet.scheduleAtFixedRate(ketQuaCron, 0,
							Integer.valueOf(Integer.valueOf(txtSecondRun.getText()) * 1000));
					SystemTrayLgsp.timerCountDown.scheduleAtFixedRate(countDown, 0, Integer.valueOf(1 * 1000));

					JOptionPane.showMessageDialog(null, "L??u th??ng tin th??nh c??ng", "DRG", JOptionPane.INFORMATION_MESSAGE);
					
				}
			});

			btnUpdate.setBounds(228, 146, 157, 23);
			panel1.add(btnUpdate);

			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(186, 92, 400, 2);
			panel1.add(separator_1);

			
			txtpnThongBao = new JTextPane();
			// scrollPane.setViewportView(txtpnThongBao);
			txtpnThongBao.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtpnThongBao.setText(
					"=========== C??C B?????C TH???C HI???N ===========\r\nB?????c 1: C???u h??nh \"Th?? m???c ngu???n\",\"th???i gian ch???y\", v?? \"Ki???m tra d???ch v??? \" ????? ?????m b???o c???u h??nh ???? ????ng theo h?????ng d???n\r\nB?????c 2: Copy h??? s?? 4210 ?????nh d???ng .xml v??o th?? m???c ???? ???????c c???u h??nh \"Th?? m???c ngu???n\" kh??ng h???n ch??? s??? l?????ng file\r\nB?????c 3: Click v??o n??t \"L??u v?? g???i h??? s??\" ????? x??c nh???n vi???c g???i \r\nCh?? ??:\r\n- H??? th???ng s??? t??? ?????ng lo???i b??? th??ng tin b???nh nh??n tr?????c khi g???i h??? s?? l??n.\r\n- B???n ch??? c???n b???m 1 l???n h??? th???ng s??? t??? ?????ng chuy???n h??? s?? t???i th?? m???c c???u h??nh\r\nB?????c 4: Theo d??i k???t qu??? g???i l??n ( xem chi ti???t t???i m???c \"K???t qu??? g???i h??? s??\")\r\n\r\n=========== CH?? ?? ===========\r\n1. D??? li???u ??u ti??n theo th???i gian nh?? sau: D??? li???u 2019, 2020 cu???i c??ng l?? 2018.\r\n2. Gi???i h???n ????? l???n c???a 1 file: 1GB, v?????t qu?? kh??ng th???c hi???n ???????c\r\n3. S??? l?????ng file XML kh??ng gi???i h???n. C??c c?? s??? y t??? copy to??n b??? c??c file XML c???a m??nh v??o th?? m???c g???c. C??ng c??? s??? t??? ?????ng chuy???n d???n d??? li???u l??n m??y ch??? d??? li???u c???a B??? Y t???\r\n4. Do gi???i h???n ???????ng truy???n, ch??? cho ph??p 1 c?? s??? chuy???n t???i ??a 1 h??? s??/1 gi??y ho???c 2 gi??y. V?? th??? c?? s??? y t??? c???n b???t m??y t??nh li??n t???c cho ?????n khi chuy???n h???t d??? li???u l??n. Th???i gian c?? th??? m???t m???t ho???c nhi???u ng??y t??y thu???c v??o s??? l?????ng XML c???a c?? s???. Sau khi chuy???n xong d??? li???u (m???i file XML ???? ???????c chuy???n l??n m??y ch??? trung ????ng ho???c chuy???n v??o th?? m???c l???i do b??? l???i) th?? ph???n m???m s??? b??o ???? chuy???n h???t d??? li???u. L??c ???? m???i ???????c t???t m??y\r\n5. Trong khi ph???n m???m ch???y, c?? th??? m??y b??? treo ho???c ph???n m???m b??? treo (n???u ph???n m???m b??? treo th?? kh??ng th???y t??? l??? x??? l?? thay ?????i trong th???i gian d??i), ng?????i ph??? tr??ch vi???c chuy???n d??? li???u kh???i ?????ng l???i m??y (n???u treo m??y) ho???c kh???i ?????ng l???i ph???n m???m ??? b???m n??t tho??t v?? ch???y l???i ch????ng tr??nh.\r\n6. Do gi???i h???n n??ng l???c x??? l?? n??n k???t qu??? b??o c??o s??? ???????c th???c hi???n v??o ban ????m. V?? th??? c?? s??? kh??ng th??? xem ngay ???????c s??? l?????ng ???? ???????c ?????ng b??? v???i m??y ch??? - nh??ng xem ???????c s??? l?????ng file ???? ???????c g???i l??n ngay ??? m??y c??i ?????t ch????ng tr??nh chuy???n d??? li???u.\r\n7. N???u ph???n m???m ???? b??o ???? ?????ng b??? xong, v??o ki???m tra th?? m???c g???c m?? kh??ng c??n file n??o n???a, ti???p ?????n ki???m tra th?? m???c l???i m?? c??ng kh??ng c?? file n??o th?? c?? ngh??a l?? d??? li???u ???? ???????c chuy???n to??n v???n l??n m??y ch???. N???u c?? file trong th?? m???c l???i, ????? ngh??? copy l???i th?? m???c g???c v?? cho ph???n m???m ti???p t???c ch???y. N???u sau khi l??m l???n 2 nh?? tr??n m?? v???n c??n file trong th?? m???c l???i, ????? ngh??? l??n zalo nh??m n??y ????? ???????c h??? tr???.");

			scrollPane = new JScrollPane(txtpnThongBao);
			scrollPane.setBounds(10, 180, 745, 320);
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.add(txtpnThongBao);
			scrollPane.setViewportView(txtpnThongBao);
			panel1.add(scrollPane);

			JLabel lblNewLabel_2_1 = new JLabel("(Vi???t li???n, kh??ng d???u)");
			lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_2_1.setForeground(Color.RED);
			lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_2_1.setBounds(20, 37, 205, 17);
			panel1.add(lblNewLabel_2_1);
			
			cbBoxLoaiDuLieu = new JComboBox();
			cbBoxLoaiDuLieu.addItem(new Item(0, "--Ch???n lo???i d??? li???u--"));
			cbBoxLoaiDuLieu.addItem(new Item(Integer.valueOf(LoaiHoSoEnum.QD4210.getValue()), LoaiHoSoEnum.QD4210.getKey()));
			cbBoxLoaiDuLieu.addItem(new Item(Integer.valueOf(LoaiHoSoEnum.QD3360.getValue()), LoaiHoSoEnum.QD3360.getKey()));
			cbBoxLoaiDuLieu.setSelectedIndex(profileEntity.getLoaiHoSo());
			cbBoxLoaiDuLieu.setBounds(230, 61, 155, 20);
			
			cbBoxLoaiDuLieu.addActionListener (new ActionListener () {
			    public void actionPerformed(ActionEvent e) {
			    	Item loaiHoSoItem = (Item) cbBoxLoaiDuLieu.getSelectedItem();
					int loaiHoSo = loaiHoSoItem.getId();
					cbBoxLoaiDuLieu.setSelectedIndex(loaiHoSo);
			    }
			});
			
			panel1.add(cbBoxLoaiDuLieu);
			
			JLabel lblNewLabel_2_2 = new JLabel("Lo???i d??? li???u: ");
			lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_2_2.setForeground(Color.BLACK);
			lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_2_2.setBounds(10, 64, 205, 17);
			panel1.add(lblNewLabel_2_2);
			
        return panel1;
    }
	 
	 class RunFileActionListener implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	        	ImportCron cron = new ImportCron();
	        	SystemTrayLgsp.timerPut.scheduleAtFixedRate(cron, 0,
						Integer.valueOf(365 * 24 * 60 * 60 * 1000));
				lblPath_1.setText("");
				DttCron.chayScheduleMoi = false;
	        }
	    }
}
