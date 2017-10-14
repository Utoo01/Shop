package eddie.shop.utils;

import java.net.InetAddress;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

public class MailUtilsTest {
	
	public static void main(String[] args) throws Exception {
		//initMain("783719477@qq.com","123456789");

	}

	public static void initMain(String to,String code) throws Exception {

		Properties prop = new Properties();
		// 开启debug调试，以便在控制台查看
		//prop.setProperty("mail.debug", "true");
		// 设置邮件服务器主机名
		prop.setProperty("mail.host", "smtp.qq.com");
		// 发送服务器需要身份验证
		prop.setProperty("mail.smtp.auth", "true");
		// 发送邮件协议名称
		prop.setProperty("mail.transport.protocol", "smtp");

		// 开启SSL加密，否则会失败
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.socketFactory", sf);

		// 创建session
		Session session = Session.getInstance(prop);
		// 通过session得到transport对象
		Transport ts = session.getTransport();
		// 连接邮件服务器：邮箱类型，帐号，授权码代替密码（更安全）
		ts.connect("smtp.qq.com", "783719477", "ptmqcnceqowsbcdi");// 后面的字符是授权码
		// 创建邮件
		Message message = createSimpleMail(session,to, code);
		// 发送邮件
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();

	}

	/**
	 * @Method: createSimpleMail
	 * @Description: 创建一封只包含文本的邮件
	 */
	public static MimeMessage createSimpleMail(Session session,String to,String code)
			throws Exception {
		// 创建邮件对象
		MimeMessage message = new MimeMessage(session);
		// 指明邮件的发件人
		message.setFrom(new InternetAddress("783719477@qq.com"));
		// 指明邮件的收件人
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(
				to));
		// 邮件的标题
		message.setSubject("Eddie商城激活邮箱！");
		//获取本机的IP地址
		
		String localIp = InetAddress.getLocalHost().getHostAddress();
		// 邮件的文本内容
		message.setContent("<h1>Eddie商城官方激活邮件!点下面链接完成激活操作!</h1><h3><a href='http:" +
				"//"+localIp+":8080/shop/user_active.action?" +
				"code="+code+"'>http://"+localIp+":8080/shop/user_active.action?code="+code+"</a></h3>",
				"text/html;charset=UTF-8");
		// 返回创建好的邮件对象
		return message;
	}

}