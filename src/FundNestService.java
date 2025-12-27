import java.util.*;

public class FundNestService {

    private Map<String, Entrepreneur> entrepreneurs = new HashMap<>();
    private Map<String, Investor> investors = new HashMap<>();
    private Map<String, Startup> startups = new HashMap<>();

    // Register Users
    public void registerEntrepreneur(String id, String name) {
        entrepreneurs.put(id, new Entrepreneur(id, name));
    }

    public void registerInvestor(String id, String name, double balance) {
        investors.put(id, new Investor(id, name, balance));
    }

    // Add Startup
    public void addStartup(String startupId, String name, double valuation) {
        startups.put(startupId, new Startup(startupId, name, valuation));
    }

    // Invest
    public void invest(String investorId, String startupId, double amount) {
        Investor investor = investors.get(investorId);
        Startup startup = startups.get(startupId);

        if (investor == null || startup == null) {
            throw new IllegalArgumentException("Invalid Investor or Startup");
        }

        investor.deductAmount(amount);

        double equity = (amount / startup.getValuation()) * 100;
        Investment investment = new Investment(investorId, amount, equity);

        startup.addInvestment(investment);
        System.out.println("Investment Successful! Equity Acquired: " + equity + "%");
    }

    // Profit Distribution
    public void distributeProfits(String startupId, double totalProfit) {
        Startup startup = startups.get(startupId);

        System.out.println("\n--- Profit Distribution ---");
        for (Investment inv : startup.getInvestments()) {
            double profitShare = (inv.getEquityPercentage() / 100) * totalProfit;
            System.out.println("Investor " + inv.getInvestorId() +
                    " receives profit: ₹" + profitShare);
        }
    }

    // Display Startups
    public void listStartups() {
        System.out.println("\nAvailable Startups:");
        for (Startup s : startups.values()) {
            System.out.println(s.getStartupId() + " - " + s.getName() +
                    " (Valuation: ₹" + s.getValuation() + ")");
        }
    }
}
