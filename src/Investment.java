import java.time.LocalDate;

public class Investment {
    private String investorId;
    private double amount;
    private double equityPercentage;
    private LocalDate investmentDate;

    public Investment(String investorId, double amount, double equityPercentage) {
        this.investorId = investorId;
        this.amount = amount;
        this.equityPercentage = equityPercentage;
        this.investmentDate = LocalDate.now();
    }

    public String getInvestorId() {
        return investorId;
    }

    public double getAmount() {
        return amount;
    }

    public double getEquityPercentage() {
        return equityPercentage;
    }

    public LocalDate getInvestmentDate() {
        return investmentDate;
    }
}
