package Memento_Mediator_Iterator;

import java.util.Iterator;

public class User implements IterableByUser{

    private ChatServer mediator;
    private String userName;
    private ChatHistory chatHistory;
    private MessageMemento memento;
    private String lastMessageSent;
    
    public User(ChatServer mediator, String userName){
        this.mediator = mediator;
        this.userName = userName;
        this.chatHistory = new ChatHistory();
        this.memento = new MessageMemento(null, null);
        this.lastMessageSent = "";
    }

    public String getUserName(){
        return this.userName;
    }

    public ChatHistory getChatHistory(){
        return this.chatHistory;
    }

    public String getLastMessageSent(){
        return this.lastMessageSent;
    }

    public void sendMessage(Message message){
        // Sent messages are automatically saved to the chat history
        if(this.mediator.sendMessage(message)){
            this.chatHistory.addMessageToHistory(message);
            this.lastMessageSent = message.getTimestamp() + "       " + message.getMessageContent();
        }
    }

    public void receiveMessage(Message message){
        // Received messages are automatically saved to the chat history
        System.out.println(
                        this.userName + " receievd a message at "
                        + message.getTimestamp() + " from "
                        + message.getSender().getUserName() + " saying: "
                        + message.getMessageContent() + "\n"
                    );
        this.chatHistory.addMessageToHistory(message);
    }

    public void saveLastMessageSent(Message message){
        this.memento.setState(message.getTimestamp(), message.getMessageContent());
    }

    public void undoLastMessageSent(){
        this.lastMessageSent = this.memento.getState();
        this.chatHistory.removeLastSentMessageFromHistory(this);
    }

    public void blockUser(User blockedUser){
        System.out.println(this.userName + " blocked " + blockedUser.getUserName() + ".");
        this.mediator.blockUser(this, blockedUser);
    }

    public Iterator iterator(User userToSearchWith){
        return this.chatHistory.iterator(userToSearchWith);
    }

}
