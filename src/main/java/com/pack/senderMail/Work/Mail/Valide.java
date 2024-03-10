package com.pack.senderMail.Work.Mail;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Valide {
    public boolean isValidEmail(String email)  throws Exception,AddressException{
        boolean isValid = false;
        InternetAddress internetAddress = new InternetAddress(email);
        internetAddress.validate();
        isValid = true;
        return isValid;
    }
}
