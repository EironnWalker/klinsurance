package com.ht.klinsurance.utils.email;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;
/**
 * 邮件发送
 * @author feicy
 * @date 2016/8/27
 */
public class EmailUtils {
    public static void sendMail() throws Exception{
        //发送邮件的协议
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth","true");//设置验证机制
        properties.setProperty("mail.transport.protocol", "smtp");//发送邮件协议
        //properties.setProperty("mail.smtp.host", "smtp.126.com");//设置邮箱服务器地址
        properties.setProperty("mail.smtp.host", "smtp.exmail.qq.com");//设置邮箱服务器地址
        properties.setProperty("mail.smtp.port", "25");
        Session session = Session.getInstance(properties,new MyAuthenticator());
        session.setDebug(true);
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("feichenyun@haitao-tech.com"));
        message.setSubject("一封复杂的邮件");
        message.setText("ceshicshiceshiceshidafkdhajfhj");
        message.setRecipients(RecipientType.TO,InternetAddress.parse("liuqi@haitao-tech.com"));//接收人
        /*message.setRecipients(RecipientType.CC,InternetAddress.parse("1348800595@qq.com"));//抄送人
        message.setRecipients(RecipientType.BCC,InternetAddress.parse("1348800595@qq.com"));//密送人*/
        MimeMultipart mimeMuti = new MimeMultipart("mixed");

        MimeBodyPart bodyPartAttch = createAttachMent("d:\\kameng_db.rar");//附件
        //MimeBodyPart bodyPartContentAndPic = createContentAndPic("I just want to Fuck", "d:\\图片1.jpg");//文本内容

        mimeMuti.addBodyPart(bodyPartAttch);
        //mimeMuti.addBodyPart(bodyPartContentAndPic);
        // 创建一个部件
        MimeBodyPart content = new MimeBodyPart();
        StringBuffer demo = new StringBuffer();
        demo.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">")
                .append("<html>")
                .append("<head>")
                .append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">")
                .append("<title>测试邮件</title>")
                .append("<style type=\"text/css\">")
                .append(".test{font-family:\"Microsoft Yahei\";font-size: 18px;color: red;}")
                .append("</style>")
                .append("</head>")
                .append("<body>")
                .append("<span class=\"test\">大家好，这里是测试Demo</span>")
                .append("</body>")
                .append("</html>");
        // 给部件指定内容
        content.setContent(demo.toString(), "text/html;charset=utf-8");
        // 部件添加到集合中
        mimeMuti.addBodyPart(content);

        message.setContent(mimeMuti);
        message.saveChanges();
        //message.setContent("Michael", "text/html;charset=gbk");
        Transport.send(message);
    }
    //创建附件
    public static MimeBodyPart createAttachMent(String path) throws MessagingException {
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        FileDataSource dataSource = new FileDataSource( new File(path));
        mimeBodyPart.setDataHandler(new DataHandler(dataSource));
        mimeBodyPart.setFileName(dataSource.getName());
        return mimeBodyPart;
    }
}
