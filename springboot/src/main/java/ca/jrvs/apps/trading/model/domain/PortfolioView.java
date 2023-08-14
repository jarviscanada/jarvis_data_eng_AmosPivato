package ca.jrvs.apps.trading.model.domain;

public class PortfolioView {

    private SecurityRow[] securityRows;

    public SecurityRow[] getSecurityRows() {
        return securityRows;
    }

    public void setSecurityRows(SecurityRow[] securityRows) {
        this.securityRows = securityRows;
    }

    @Override
    public String toString() {
        return "PortfolioView{" +
                "securityRows=" + securityRows +
                '}';
    }
}
