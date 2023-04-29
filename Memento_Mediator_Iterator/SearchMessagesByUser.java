package Memento_Mediator_Iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class SearchMessagesByUser implements Iterator{

    private User userToSearchBy;
    private ArrayList<Message> chatHistory;
    private int indexInChatHistory;
    private int chatHistorySize;

    public SearchMessagesByUser(User userToSearchBy){
        this.userToSearchBy = userToSearchBy;
        this.chatHistory = userToSearchBy.getChatHistory().getHistory();
        this.indexInChatHistory = 0;
        this.chatHistorySize = chatHistory.size();
        System.out.println("Searching for messages with " + userToSearchBy.getUserName() + ".\n");
    }

    @Override
    public boolean hasNext(){
        Message message = null;
        while(this.indexInChatHistory < this.chatHistorySize){
            message = this.chatHistory.get(this.indexInChatHistory);
            if(message.getSender() == userToSearchBy || message.getRecipients().contains(userToSearchBy)){
                return true;
            }
            else{
                this.indexInChatHistory++;
            }
        }
        return false;
    }
    
    @Override
    public Message next(){
        if(hasNext()){
            return this.chatHistory.get(this.indexInChatHistory++);
        }
        return null;
    }

    @Override
    public void remove(){
        Iterator.super.remove();
    }

}
