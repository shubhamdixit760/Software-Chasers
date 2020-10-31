package sample;

import java.io.Serializable;

public class Message implements Serializable {
    private String message;
    private String from;
    //private String to;

    public Message(String message,String from)
    {
        this.message=message;
        this.from=from;
    }

    @Override
    public String toString()
    {
        return String.format("%s: %s",from,message);
    }
}
