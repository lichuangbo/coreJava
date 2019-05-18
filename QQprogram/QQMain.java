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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author 李创博
 * @version: 1.0
 */
public class QQMain  extends JFrame implements ActionListener{
	JTextField tfmess=new JTextField();	
	JTextArea taContent=new JTextArea();
	JComboBox cmbUser=new JComboBox();
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
		this.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void main(String[] args) {
		QQMain qm = new QQMain();
	}
}
