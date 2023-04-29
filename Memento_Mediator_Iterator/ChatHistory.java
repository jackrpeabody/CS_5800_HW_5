package Memento_Mediator_Iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class ChatHistory implements IterableByUser{

    private ArrayList<Message> history;

    public ChatHistory(){
        this.history = new ArrayList<Message>();
    }

    public void addMessageToHistory(Message message){
        history.add(message);
    }

    public void removeLastSentMessageFromHistory(User user){
        Message lastSentMessage;
        for(int i = this.history.size() - 1; i >= 0; i--){
            lastSentMessage = this.history.get(i);
            if(lastSentMessage.getSender() == user){
                this.history.remove(lastSentMessage);
            }
            for(User recipient: lastSentMessage.getRecipients()){
                ArrayList<Message> recipientHistory = recipient.getChatHistory().getHistory();
                Message lastReceivedMessage;
                for(int j = recipientHistory.size() - 1; j >= 0; j--){
                    lastReceivedMessage = recipientHistory.get(j);
                    if(lastReceivedMessage.getSender() == user){
                        recipientHistory.remove(lastReceivedMessage);
                    }
                }
            }
        }
    }

    public Message getLastMessageSent(User user){
        Message lastMessage;
        for(int i = this.history.size() - 1; i >= 0; i--){
            lastMessage = this.history.get(i);
            if(lastMessage.getSender() == user){
                return lastMessage;
            }
        }
        return null;
    }

    public ArrayList<Message> getHistory(){
        return this.history;
    }

    @Override
    public Iterator iterator(User userToSearchWith){
        return new SearchMessagesByUser(userToSearchWith);
    }
    
}
