import java.util.*;

public class Startup {
    private String startupId;
    private String name;
    private double valuation;
    private Map<String, Investment> investments = new HashMap<>();

    public Startup(String startupId, String name, double valuation) {
        this.startupId = startupId;
        this.name = name;
        this.valuation = valuation;
    }

    public String getStartupId() {
        return startupId;
    }

    public String getName() {
        return name;
    }

    public double getValuation() {
        return valuation;
    }

    public void addInvestment(Investment investment) {
        investments.put(investment.getInvestorId(), investment);
    }

    public Collection<Investment> getInvestments() {
        return investments.values();
    }
}
