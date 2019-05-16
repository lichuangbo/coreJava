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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.JdbcRowSet;
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
 * @version: 1.0
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
		if(e.getActionCommand().equals("登录")) {
			if (JDBCutil.isSearched(user, pass)) {
				System.out.println("登录成功！");
			} else {
				JOptionPane.showMessageDialog(this, "您输入的用户名或密码有误！");
			}
		} else if (e.getActionCommand().equals("注册")) {
			//注册前先查看用户名是否存在，是弹窗告知，否则进行注册
			if (JDBCutil.isSearched(user)) {
				JOptionPane.showMessageDialog(this, "您输入的用户名已存在！");
			} else {
				if (JDBCutil.isInsert(user, pass)) {
					JOptionPane.showMessageDialog(this, "注册成功");
				}
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
