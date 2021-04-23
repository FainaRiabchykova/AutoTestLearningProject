package businesslayer.datamanager;

public class EmailProvider {

    public static EmailData getEmailData() {
        return new EmailData(
                "qualitydandelion+to@gmail.com",
                "qualitydandelion+cc@gmail.com",
                "qualitydandelion+bcc@gmail.com",
                "Email subject");
    }
}


