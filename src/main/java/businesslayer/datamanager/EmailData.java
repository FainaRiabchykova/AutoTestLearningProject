package businesslayer.datamanager;

public class EmailData {

  private String to;
  private String cc;
  private String bcc;
  private String subject;

  public EmailData(String to, String cc, String bcc, String subject) {
      this.to = to;
      this.cc = cc;
      this.bcc = bcc;
      this.subject = subject;
  }

  public String getTo() {
      return to;
  }

  public void setTo(String to) {
      this.to = to;
  }

  public String getCc() {
      return cc;
  }

  public void setCc(String cc) {
      this.cc = cc;
  }

  public String getBcc() {
      return bcc;
  }

  public void setBcc(String bcc) {
      this.bcc = bcc;
  }

  public String getSubject() { return subject; }

  public void setSubject(String subject) {
      this.subject = subject;
  }
}
