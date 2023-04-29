package Memento_Mediator_Iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Timestamp;
import java.util.Iterator;

public class Driver {

    public static void main(String[] args){

        System.out.println("\n\nYour program should include a driver that demonstrates these features with 3 users.\n");
        ChatServer mediator = new ChatServer();
        User a = new User(mediator, "userA");
        User b = new User(mediator, "userB");
        User c = new User(mediator, "userC");
        mediator.registerUser(a);
        mediator.registerUser(b);
        mediator.registerUser(c);

        // 1
        System.out.println("\n\nUsers can send messages to one or more other users through the chat server.\n");
        Message aToB = new Message(
                                    a, 
                                    new ArrayList<User>(Arrays.asList(b)), 
                                    new Timestamp((long) 1682735043471.0), 
                                    "Hello userB it's userA!"
                                );
        a.sendMessage(aToB);
        a.saveLastMessageSent(aToB);
        
        Message bToAC = new Message(
                                    b, 
                                    new ArrayList<User>(Arrays.asList(a, c)), 
                                    new Timestamp((long) 1682735053471.0), 
                                    "Hello userA and userC it's userB!"
                                );
        b.sendMessage(bToAC);
        b.saveLastMessageSent(bToAC);

        Message cToA = new Message(
                                    c, 
                                    new ArrayList<User>(Arrays.asList(a)), 
                                    new Timestamp((long) 1682735063471.0), 
                                    "Hello userA it's userC!"
                                );
        c.sendMessage(cToA);
        c.saveLastMessageSent(cToA);

        Message aToC = new Message(
                                    a, 
                                    new ArrayList<User>(Arrays.asList(c)), 
                                    new Timestamp((long) 1682735073471.0), 
                                    "Good to hear from you userC!"
                                );
        a.sendMessage(aToC);

        System.out.println();

        // 2
        System.out.println("Users can undo the last message they sent using the Memento design pattern.\n");
        System.out.println(a.getLastMessageSent());
        a.undoLastMessageSent();
        System.out.println(a.getLastMessageSent());

        // 3
        System.out.println("\n\nUsers can block messages from specific users using the Mediator design pattern.\n");
        a.blockUser(c);
        c.sendMessage(cToA);

        // 4
        System.out.println("\n\nUsers can receive messages from other users and view the chat history for a specific user.\n");
        Iterator searchAHistoryForC = a.iterator(c);
        while(searchAHistoryForC.hasNext()){
            System.out.println(searchAHistoryForC.next());
        }
        
    }
    
}
