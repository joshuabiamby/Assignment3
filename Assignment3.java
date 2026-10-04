import java.util.*;

public class Assignment3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Content> contents = new ArrayList<>();

        while (true) {
            System.out.println("[Content Manager]");
            System.out.println("1. Add written content");
            System.out.println("2. Add image content");
            System.out.println("3. Add audio content");
            System.out.println("4. Add video content");
            System.out.println("5. List all content");
            System.out.println("0. Quit");
            System.out.print("Enter option: ");

            int option = Integer.parseInt(scanner.nextLine());

            if (option == 0) {
                System.out.println("Shutting off...");
                break;
            }

            switch (option) {
                case 1: // WrittenContent
                    System.out.print("Enter content's name: ");
                    String wName = scanner.nextLine();
                    System.out.print("Enter content's description: ");
                    String wDesc = scanner.nextLine();
                    System.out.print("Where is the content stored? ");
                    String wLoc = scanner.nextLine();
                    System.out.print("Enter author's name: ");
                    String wAuth = scanner.nextLine();
                    System.out.print("Enter number of words: ");
                    int wWords = Integer.parseInt(scanner.nextLine());

                    contents.add(new WrittenContent(wName, wDesc, wLoc, wAuth, wWords));
                    System.out.println("Content added.");
                    break;

                case 2: // ImageContent
                    System.out.print("Enter content's name: ");
                    String iName = scanner.nextLine();
                    System.out.print("Enter content's description: ");
                    String iDesc = scanner.nextLine();
                    System.out.print("Where is the content stored? ");
                    String iLoc = scanner.nextLine();
                    System.out.print("Enter author's name: ");
                    String iAuth = scanner.nextLine();
                    System.out.print("Enter image's width: ");
                    int iWidth = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter image's height: ");
                    int iHeight = Integer.parseInt(scanner.nextLine());

                    contents.add(new ImageContent(iName, iDesc, iLoc, iAuth, new int[]{iWidth, iHeight}));
                    System.out.println("Content added.");
                    break;

                case 3: // AudioContent
                    System.out.print("Enter content's name: ");
                    String aName = scanner.nextLine();
                    System.out.print("Enter content's description: ");
                    String aDesc = scanner.nextLine();
                    System.out.print("Where is the content stored? ");
                    String aLoc = scanner.nextLine();
                    System.out.print("Enter duration, in milliseconds: ");
                    int aDur = Integer.parseInt(scanner.nextLine());

                    ArrayList<String> participants = new ArrayList<>();
                    System.out.println("Enter the name of every participant, or blank to finish.");
                    while (true) {
                        System.out.print("Enter participant: ");
                        String pName = scanner.nextLine();
                        if (pName.isEmpty()) break;
                        participants.add(pName);
                    }

                    contents.add(new AudioContent(aName, aDesc, aLoc, aDur, participants));
                    System.out.println("Content added.");
                    break;

                case 4: // VideoContent
                    System.out.print("Enter content's name: ");
                    String vName = scanner.nextLine();
                    System.out.print("Enter content's description: ");
                    String vDesc = scanner.nextLine();
                    System.out.print("Where is the content stored? ");
                    String vLoc = scanner.nextLine();
                    System.out.print("Enter duration, in milliseconds: ");
                    int vDur = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter resolution: ");
                    int vRes = Integer.parseInt(scanner.nextLine());

                    contents.add(new VideoContent(vName, vDesc, vLoc, vDur, vRes));
                    System.out.println("Content added.");
                    break;

                case 5: // List all content
                    if (contents.isEmpty()) {
                        System.out.println("List of contents is empty.");
                    } else {
                        System.out.println("List of contents:");
                        for (int i = 0; i < contents.size(); i++) {
                            System.out.println(contents.get(i).toString());
                            if (i < contents.size() - 1) {
                                System.out.println(); // Line break between items
                            }
                        }
                    }
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
