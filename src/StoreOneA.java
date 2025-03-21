public class StoreOneA extends StoreToRent {
    private static final double DISCOUNT_RATE = 0.1;
    private boolean specialCustomer;
    private double monthlyPayment;

    public StoreOneA(boolean loanRequired, double loanAmount, int loanPaymentTerm, boolean specialCustomer) {
        super(loanRequired, loanAmount, loanPaymentTerm);
        this.specialCustomer = specialCustomer;
    }

    public double calculateLoanFinancing() {
        monthlyPayment = super.calculateLoanFinancing();
        if (specialCustomer) {
            monthlyPayment -= (monthlyPayment * DISCOUNT_RATE);
        }
        return monthlyPayment;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        if (isLoanRequired()) {
            sb.append("LOAN DETAILS:\n");
            sb.append("Loan Amount: ").append(getLoanAmount()).append("\n");
            sb.append("Loan Payment Term: ").append(getLoanPaymentTerm()).append("\n");
            sb.append("Interest Rate: ").append(getInterestRate()).append("\n");
            sb.append("Special Customer: ").append(specialCustomer).append("\n");
            sb.append("Monthly Loan Payment: ").append(calculateLoanFinancing()).append("\n");
        }
        return sb.toString();
    }

    public void showStoreInfo() {
        System.out.println(toString());
    }
}