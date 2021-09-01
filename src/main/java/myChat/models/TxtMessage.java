package myChat.models;


import myChat.exception.UnAcceptableFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TxtMessage {

    private String from;
    private String to;
    private String text;
    private final Logger logger = LoggerFactory.getLogger(TxtMessage.class);

    public TxtMessage(String from, String to, String text) {
        this.from = from;
        this.to = to;
        this.text = text;
    }

    public TxtMessage() {    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static TxtMessage getReceivedMessageFormat(String message) {

        try {
            String []parts = message.split("-");
            if(parts.length == 3) {

                /**  from , To , textMessage  **/
                return new TxtMessage(parts[0], parts[1], parts[2]);
            }
            else throw  new UnAcceptableFormat();

        } catch (NullPointerException | UnAcceptableFormat np)
        {
            np.printStackTrace();
        }
        return null;
    }

    public  String getSendMessageFormat() {
        return this.from+"-"+this.to+"-"+this.text;
    }


}
