import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        FundNestService service = new FundNestService();
        Scanner sc = new Scanner(System.in);

        // Sample Data
        service.registerEntrepreneur("E1", "Ravi");
        service.registerInvestor("I1", "Anil", 100000);
        service.addStartup("S1", "AgroTech", 500000);

        while (true) {
            System.out.println("\n--- FundNest Menu ---");
            System.out.println("1. View Startups");
            System.out.println("2. Invest");
            System.out.println("3. Distribute Profits");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        service.listStartups();
                        break;

                    case 2:
                        System.out.print("Investor ID: ");
                        String invId = sc.next();
                        System.out.print("Startup ID: ");
                        String stId = sc.next();
                        System.out.print("Investment Amount: ");
                        double amt = sc.nextDouble();
                        service.invest(invId, stId, amt);
                        break;

                    case 3:
                        System.out.print("Startup ID: ");
                        String sid = sc.next();
                        System.out.print("Total Profit: ");
                        double profit = sc.nextDouble();
                        service.distributeProfits(sid, profit);
                        break;

                    case 4:
                        System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
