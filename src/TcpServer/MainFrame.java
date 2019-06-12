package TcpServer;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class MainFrame extends Frame implements ActionListener {
	Panel p, p1, p2, p3, p4, p_send;
	Button bSend, bCancel;
	Label lUserName;
	TextField tUserName;

	public MainFrame(String s) {
		super(s);
		mainFrame();
	}

	public void mainFrame() {
		this.setLayout(new BorderLayout());
		p = new Panel();
		p_send = new Panel();
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		p4 = new Panel();
		bSend = new Button("发送");
		bSend.addActionListener(this);
		bCancel = new Button("取消");
		bCancel.addActionListener(this);
		lUserName = new Label("请输入要跟客户端说的话");
	
		tUserName = new TextField(30);
		tUserName.addActionListener(this);
		p1.add(lUserName);
		p2.add(tUserName);
		p3.add(bSend);
		p4.add(bCancel);
		p_send.add(p1);
		p_send.add(p2);
		p_send.add(p3);
		p_send.add(p4);
		p.add(p_send);
		this.add(p, "Center");
		this.setBounds(200,100, 600, 400);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				System.exit(0);
			}
		});
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new MainFrame("服务器发客户端页面");

	}

	public void actionPerformed(ActionEvent e) {
		Button btn = (Button) e.getSource();
		if (btn == bCancel) {
			setVisible(false);
			System.exit(0);
		}
		if (btn == bSend) {
			String username = tUserName.getText();
			 JOptionPane.showMessageDialog(null, "发送"+"\""+username+"\""+"成功");
		}

	}

}