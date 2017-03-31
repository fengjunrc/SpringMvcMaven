package com.test.mail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
* @ClassName: Sendmail
* @Description: Sendmail类继承Thread，因此Sendmail就是一个线程类，这个线程类用于给指定的用户发送Email
*/ 
public class Sendmail extends Thread {
        //用于给用户发送邮件的邮箱
    private String from = "@qq.com";
        //邮箱的用户名
    private String username = "@qq.com";
        //邮箱的密码
    private String password = "";//密码
        //发送邮件的服务器地址
    private String host = "smtp.qq.com";
    
    private Admin user;
    public Sendmail(Admin user){
        this.user = user;
    }
    
    /* 重写run方法的实现，在run方法中发送邮件给指定的用户
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {
        try{
            Properties prop = new Properties();
            prop.setProperty("mail.host", host);
            prop.setProperty("mail.transport.protocol", "smtp");
            prop.setProperty("mail.smtp.auth", "true");
            prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            prop.setProperty("mail.smtp.port","465");//qq邮箱端口号465或587
            prop.setProperty("mail.smtp.socketFactory.port","465");
            Session session = Session.getInstance(prop);
            session.setDebug(true);
            Transport ts = session.getTransport();
            ts.connect(host, username, password);
            Message message = createEmail(session,user);
            ts.sendMessage(message, message.getAllRecipients());
            ts.close();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
    * @Method: createEmail
    * @Description: 创建要发送的邮件
    * @param session
    * @param user
    * @return
    * @throws Exception
    */ 
    public Message createEmail(Session session,Admin user) throws Exception{
        
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
        message.setSubject("用户注册邮件");
        
        String info = "恭喜您注册成功，您的账户名：" + user.getAdmin_code() + ",您的密码：" + user.getPassword() + "，请妥善保管，如有问题请联系网站客服!!";
        message.setContent(info, "text/html;charset=UTF-8");
        message.saveChanges();
        return message;
    }
    
    
    public static void main(String[] args){
    	Admin user = new Admin();
    	user.setEmail("@qq.com");
    	user.setPassword("");//密码
    	//user.setAdmin_code("hbcnuvynohfybbhf");  
    	Sendmail send  =new Sendmail(user);
    	send.start();
    	
    }
}