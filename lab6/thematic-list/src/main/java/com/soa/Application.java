package com.soa;

import java.util.Scanner;

public class Application {

    private Scanner scanner = new Scanner(System.in);

    void run() {
        System.out.println("Enter your id:");
        String id = scanner.nextLine();
        Subscriber subscriber = new Subscriber(id);

        System.out.println("Available commands:\n" +
                "1. Subscribe to topic.\n" +
                "2. Send public message.\n" +
                "3. Send private message.\n" +
                "4. Logout.\n" +
                "5. Quit.");

        while (!Thread.interrupted()) {
            System.out.println("Enter command [1-5]:");
            String commandId = scanner.nextLine();
            switch (commandId) {
                case "1": {
                    System.out.println("Enter topic name: ");
                    String topicName = scanner.nextLine();
                    subscriber.subscribeToTopic(topicName);
                    break;
                }
                case "2": {
                    System.out.println("Enter topic name: ");
                    String topicName = scanner.nextLine();
                    System.out.println("Enter message: ");
                    String message = scanner.nextLine();
                    subscriber.sendPublicMessage(topicName, message);
                    break;
                }
                case "3": {
                    System.out.println("Enter user id: ");
                    String userId = scanner.nextLine();
                    System.out.println("Enter message: ");
                    String message = scanner.nextLine();
                    subscriber.sendPrivateMessage(userId, message);
                    break;
                }
                case "4":
                    subscriber = null;
                    run();
                    return;
                case "5":
                    return;
            }
        }
    }

    public static void main(String[] args) {
        new Application().run();
    }
}
