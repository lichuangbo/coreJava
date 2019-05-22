/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月16日
 */
package QQ;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * QQ登录窗口，连接数据库进行验证
 * @author 李创博
 * @version: 1.2
 * @date 2019/5/22
 */
public class QQLogin extends JFrame implements ActionListener {
	JTextField tfUser=new JTextField();
	JPasswordField tfPass=new JPasswordField();
	/**
	 * 用JFrame制作登录窗口
	 */
	public QQLogin() {
		this.setSize(240, 145);
		//设置窗口大小不可变
		setResizable(false);
		//上层面板(用户名, 密码)
		JLabel lbUser=new JLabel("用户名");
		JLabel lbPass=new JLabel("密码");		
		JPanel plUp=new JPanel();
		plUp.setLayout(new GridLayout(2,2));
		plUp.add(lbUser);
		plUp.add(tfUser);
		plUp.add(lbPass);
		plUp.add(tfPass);
		//下层面板(注册、登录、取消按钮)
		JButton btLogin=new JButton("登录");
		JButton btRegin=new JButton("注册");
		JButton btCancel=new JButton("取消");
		JPanel plDown=new JPanel();
		plDown.setLayout(new FlowLayout());
		plDown.add(btLogin);
		plDown.add(btRegin);
		plDown.add(btCancel);
		//添加到主面板中
		this.add(plUp,BorderLayout.NORTH);
		this.add(plDown,BorderLayout.CENTER);
		//添加事件监听
		btLogin.addActionListener(this);
		btRegin.addActionListener(this);
		btCancel.addActionListener(this);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String user = tfUser.getText().trim();
		String pass = String.valueOf(tfPass.getPassword()).trim();
		
		NetUtil nu = null;
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1", 8001);
			nu = new NetUtil(socket);
		} catch (IOException e1) {
			e1.printStackTrace();
		}						
		
		//将类型、用户名和密码发送服务器，服务器端进行验证并返回结果，之后客户端根据结果显示
		if(e.getActionCommand().equals("登录")) {
			nu.post("登录," + user + "," + pass);				
			if (nu.get().equals("ok")) {
				QQMain qm = new QQMain();
				qm.setSocket(socket);
				qm.setVisible(true);
				this.setVisible(false);
			}else {
				JOptionPane.showMessageDialog(this, "您输入的用户名或密码有误！");
			}
		} else if (e.getActionCommand().equals("注册")) {
			nu.post("注册," + user + "," + pass);
			String result = nu.get();
			if (result.equals("error")) {
				JOptionPane.showMessageDialog(this, "您输入的用户名已存在！");
			} else {
				JOptionPane.showMessageDialog(this, "注册成功");
			}
		} else {
			tfUser.setText("");
			tfPass.setText("");
		}
	}
	public static void main(String[] args) {
		QQLogin ql=new QQLogin();
	}
}
