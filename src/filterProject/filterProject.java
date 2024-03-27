package filterProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.LineBorder;

public class filterProject extends JFrame{
	
	panel p;
	
	public static void main(String[] args) {
		try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch (Exception e) {}
		new filterProject();
	}
	filterProject() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);
		p = new panel();
		add(p);
		pack();
		setLocationRelativeTo(null);
		setTitle("List Filtter");
		setResizable(false);
		setVisible(true);
		
	}
}
class panel extends JPanel implements ActionListener{
	
	panel p;
	JTextArea taEnter;
	JTextArea taResult;
	JButton btn;
	JScrollPane jsEnter;
	JScrollPane jsResult;
	JComboBox<String> cb;
	String [] list = {"Email" , "Phone Number" , "ID"};
	panel () {
		p = this.p;
		setBackground(Color.black);
		setPreferredSize(new Dimension(600,780));
		setLayout(null);
		
		taEnter = new JTextArea();
		taResult = new JTextArea();
		taEnter.setMargin(new Insets(5, 5, 5, 5));
		taResult.setMargin(new Insets(5, 5, 5, 5));
		btn = new JButton("Filtter");
		cb = new JComboBox<>(list);
		
		Font f = new Font("" , Font.BOLD , 16 ); 
		taEnter.setFont(f);
		taResult.setFont(f);
		btn.setFont(f);
		cb.setFont(new Font("" , Font.BOLD , 20 ));
		btn.setBackground(Color.white);
		
		jsEnter = new JScrollPane(taEnter , JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED , JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsResult = new JScrollPane(taResult , JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED , JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		jsEnter.setBounds(10,10 , 280, 700);
		jsResult.setBounds(310,10 , 280, 700);
		btn.setBounds(440, 720, 150, 50);
		cb.setBounds(10, 720, 420, 50);
		cb.setBackground(Color.white);
		
		jsEnter.setBorder(new LineBorder(Color.gray , 1));
		jsResult.setBorder(new LineBorder(Color.gray , 1));
		btn.setBorder(null);
		
		taResult.setEditable(false);
		
		add(jsEnter);
		add(jsResult);
		add(btn);
		add(cb);
		
		btn.addActionListener(this);
		
		taEnter.addMouseListener(new MouseListener() {
			
			@Override public void mouseReleased(MouseEvent arg0) {}		
			@Override public void mouseClicked(MouseEvent arg0) {}		
			@Override public void mouseExited(MouseEvent arg0) {}
			@Override public void mouseEntered(MouseEvent arg0) {}	
			@Override
			public void mousePressed(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e)) {
					JMenuItem cut = new JMenuItem("cut       ");
					cut.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							taEnter.cut();
							
						}
					});
					JMenuItem copy = new JMenuItem("copy");
					copy.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							taEnter.copy();
							
						}
					});
					JMenuItem past = new JMenuItem("past");
					past.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							taEnter.paste();
							
						}
					});
					JPopupMenu menu = new JPopupMenu();
					menu.add(cut);
					menu.add(copy);
					menu.add(past);
					
					menu.show(taEnter,e.getX(),e.getY());
				}
				
			}
		});
		taResult.addMouseListener(new MouseListener() {
			
			@Override public void mouseReleased(MouseEvent arg0) {}		
			@Override public void mouseClicked(MouseEvent arg0) {}		
			@Override public void mouseExited(MouseEvent arg0) {}
			@Override public void mouseEntered(MouseEvent arg0) {}	
			@Override
			public void mousePressed(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e)) {
					JMenuItem selectAll = new JMenuItem("select All       ");
					selectAll.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							taResult.selectAll();
							
						}
					});
					JMenuItem copy = new JMenuItem("copy");
					copy.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							taResult.copy();
							
						}
					});
					JPopupMenu menu = new JPopupMenu();
					menu.add(selectAll);
					menu.add(copy);
					
					menu.show(taResult,e.getX(),e.getY());
				}
				
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(cb.getSelectedItem().toString().equals("Email"))
			taResult.setText(Tools.emailFiltter(taEnter.getText()));
		if(cb.getSelectedItem().toString().equals("Phone Number"))
			taResult.setText(Tools.PhoneNumberFiltter(taEnter.getText()));
		if(cb.getSelectedItem().toString().equals("ID"))
			taResult.setText(Tools.idFiltter(taEnter.getText()));
	}
}
