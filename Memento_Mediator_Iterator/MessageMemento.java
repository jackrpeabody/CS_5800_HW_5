package Memento_Mediator_Iterator;

import java.sql.Timestamp;

public class MessageMemento{

    private Timestamp timestamp;
    private String messageContent;

    public MessageMemento(Timestamp timestamp, String messageContent){
        this.timestamp = timestamp;
        this.messageContent = messageContent;
    }

    public Timestamp getTimestamp(){
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp){
        this.timestamp = timestamp;
    }

    public String getMessageContent(){
        return messageContent;
    }

    public void setMessageContent(String messageContent){
        this.messageContent = messageContent;
    }

    public void setState(Timestamp timestamp, String messageContent){
        this.timestamp = timestamp;
        this.messageContent = messageContent;
    }

    public String getState(){
        return this.timestamp + "       " + this.messageContent;
    }
    
}
