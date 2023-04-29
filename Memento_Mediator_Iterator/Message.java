package Memento_Mediator_Iterator;

import java.util.ArrayList;
import java.sql.Timestamp;

public class Message{

    private User sender;
    private ArrayList<User> recipients;
    private Timestamp timestamp;
    private String messageContent;

    public Message(User sender, ArrayList<User> recipients, Timestamp timestamp, String messageContent){
        this.sender = sender;
        this.recipients = recipients;
        this.timestamp = timestamp;
        this.messageContent = messageContent;
    }

    public User getSender(){
        return sender;
    }

    public void setSender(User sender){
        this.sender = sender;
    }

    public ArrayList<User> getRecipients(){
        return recipients;
    }

    public void setRecipients(ArrayList<User> recipients){
        this.recipients = recipients;
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

    public String toString(){
        String recipientNames = "";
        for(User recipient: recipients){
            recipientNames += recipient.getUserName();
        }
        return "Message from " + sender.getUserName() 
            + " at " + this.timestamp 
            + " to " + recipientNames 
            + " saying: " + this.messageContent;
    }
    
}