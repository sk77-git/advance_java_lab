package lab3.ques5;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


interface RemoteService extends Remote {
    String sayHello() throws RemoteException;
}

//5.	Write a program to implement client-server application using RMI.
class RMIClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            RemoteService remoteService = (RemoteService) registry.lookup("RemoteService");

            String message = remoteService.sayHello();
            System.out.println("Server says: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class RemoteServiceImpl extends UnicastRemoteObject implements RemoteService {
    protected RemoteServiceImpl() throws RemoteException {
        super();
    }

    public String sayHello() throws RemoteException {
        return "Hello from server!";
    }
}

class RMIServer {
    public static void main(String[] args) {
        try {
            RemoteService remoteService = new RemoteServiceImpl();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("RemoteService", remoteService);

            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}






