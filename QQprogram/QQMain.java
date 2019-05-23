/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月18日
 */
package QQ;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * QQ主界面
 * @author 李创博
 * @version: 1.1
 */
public class QQMain  extends JFrame implements ActionListener, WindowListener, Runnable{
	JTextField tfmess=new JTextField();	
	JTextArea taContent=new JTextArea();
	JComboBox cmbUser=new JComboBox();
	
	//从QQLogin中将socket对象传递过来
	private Socket s;
	public void setSocket(Socket s) {
		this.s = s;
		/*
		 * 使用QQMain创建对象时，调用构造方法，随即启动接收线程，而此时setSocket还没有开始工作
		 * 为避免异常，在setSocket末尾启动
		 */
		Thread t = new Thread(this);
		t.start();
	}
	
	public QQMain() {
		this.setSize(300, 400);
		setResizable(false);
		taContent.setEditable(false);
		//小面板
		JButton btSend=new JButton("发送");
		JPanel plSmall=new JPanel();
		plSmall.setLayout(new GridLayout(1, 2));
		plSmall.add(cmbUser);
		plSmall.add(btSend);
		//大面板
		JScrollPane sp=new JScrollPane(taContent);
		JPanel plBig=new JPanel();
		plBig.setLayout(new GridLayout(2, 1));
		plBig.add(tfmess);
		plBig.add(plSmall);
		//添加总面板
		this.add(plBig,BorderLayout.NORTH);
		this.add(sp,BorderLayout.CENTER);
		//添加时间监听
		btSend.addActionListener(this);
		this.addWindowListener(this);
		this.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("发送")) {
			String mess = tfmess.getText();
			taContent.append(mess + "\n");
			try {
				String filePath = "C:\\EclipseWorkspace\\CoreJava\\src\\QQ"; 
				File chatFile = new File(filePath + "\\chatFile.txt");
				FileWriter fw = new FileWriter(chatFile, true);//追加模式
				PrintWriter pw = new PrintWriter(fw);				
				pw.println(mess);
				pw.close();
				
				NetUtil nu = new NetUtil(s);
				nu.post(mess);
			} catch(IOException e1) {
				System.out.println(e1);
			}
			tfmess.setText("");
		}
	}
	
	public static void main(String[] args) {
		QQMain qm = new QQMain();
	}
	
	/**
	 * 由于客户端接收是阻塞式操作(要么接收要么发送)，必须使用线程使他同步进行
	 */
	@Override
	public void run() {
		NetUtil nu = new NetUtil(s);
		while(true) {
			String reply = nu.get();
			String type = reply.split("%")[0];
			String mess = reply.split("%")[1];
			if (type.equals("add")) {
				cmbUser.addItem(mess);
			}
			if (type.equals("exit")) {
				cmbUser.removeItem(mess);
			}
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	/**
	 * 窗口关闭即用户下线，向服务器发送{exit}
	 * @param e
	 * @return: void
	 */
	@Override
	public void windowClosing(WindowEvent e) {
		NetUtil nu = new NetUtil(s); 
		nu.post("{exit}");
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}
}
