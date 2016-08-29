package com.ht.klinsurance.utils.email;

import com.ht.klinsurance.common.KlConsts;
import org.apache.commons.lang.StringUtils;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
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
    /**
     * 发送邮件
     * @param title 邮件主题
     * @param receiveEmail 收件人
     * @param copyEmail 抄送人，多个用,隔开 没有则传“”即可
     * @param emailContent 邮件内容 没有则传“”即可
     * @param path 附件路径（全路径）没有则传“”即可
     * @throws Exception
     */
    public static int sendMail(String title,String receiveEmail,String copyEmail,String emailContent,String path) {
        //发送邮件的协议
        try {
            Properties properties = new Properties();
            properties.setProperty("mail.smtp.auth","true");//设置验证机制
            properties.setProperty("mail.transport.protocol", "smtp");//发送邮件协议
            properties.setProperty("mail.smtp.host", KlConsts.EMAIL_SMTP);//设置邮箱服务器地址
            //properties.setProperty("mail.smtp.host", "smtp.exmail.qq.com");//设置邮箱服务器地址
            properties.setProperty("mail.smtp.port", "25");
            Session session = Session.getInstance(properties,new MyAuthenticator());
            session.setDebug(true);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress( KlConsts.EMAIL_SEND_EMAIL));
            message.setSubject(title);
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(receiveEmail));//接收人
            if(StringUtils.isNotBlank(copyEmail)){
                String[] emails = copyEmail.split(",");
                InternetAddress[] internetAddressCC = new InternetAddress[emails.length];
                for(int i=0;i<emails.length;i++){
                    internetAddressCC[i]=new InternetAddress(emails[i]);
                }
                message.setRecipients(Message.RecipientType.CC, internetAddressCC);
            }
        /*message.setRecipients(RecipientType.CC,InternetAddress.parse("1348800595@qq.com"));//抄送人
        message.setRecipients(RecipientType.BCC,InternetAddress.parse("1348800595@qq.com"));//密送人*/
            MimeMultipart mimeMuti = new MimeMultipart("mixed");

            if(StringUtils.isNotBlank(path)){//存在附件
                MimeBodyPart bodyPartAttch = createAttachMent(path);//附件
                mimeMuti.addBodyPart(bodyPartAttch);
            }
            //MimeBodyPart bodyPartContentAndPic = createContentAndPic("I just want to Fuck", "d:\\图片1.jpg");//文本内容
            //mimeMuti.addBodyPart(bodyPartContentAndPic);
            if(StringUtils.isNotBlank(emailContent)){//存在内容
                // 创建一个部件
                MimeBodyPart content = new MimeBodyPart();
                // 给部件指定内容
                content.setContent(emailContent, "text/html;charset=utf-8");
                // 部件添加到集合中
                mimeMuti.addBodyPart(content);
            }


            message.setContent(mimeMuti);
            message.saveChanges();
            //message.setContent("Michael", "text/html;charset=gbk");
            Transport.send(message);
            return 1;
        }catch (Exception e)
        {
            e.printStackTrace();
            return -6;
        }
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
