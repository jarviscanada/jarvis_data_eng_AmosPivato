package ca.jrvs.apps.trading.model.domain;

public class Account implements Entity<Integer>{

    private Double amount;

    private Integer id;

    private Integer trader_id;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTrader_id() {
        return trader_id;
    }

    public void setTrader_id(Integer trader_id) {
        this.trader_id = trader_id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "amount=" + amount +
                ", id=" + id +
                ", trader_id=" + trader_id +
                '}';
    }
}
