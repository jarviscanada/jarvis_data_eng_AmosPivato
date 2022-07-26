package ca.jrvs.apps.trading.model.domain;

import java.util.Date;

public class TraderAccountView implements Entity<Integer>{

    private Double amount;

    private Integer id;

    private Integer trader_id;

    private String first_name;

    private String last_name;

    private Date dob;

    private String country;

    private String email;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public TraderAccountView(Trader trader, Account account) {
        this.id = account.getId();
        this.trader_id = trader.getId();
        this.amount = account.getAmount();
        this.dob = trader.getDob();
        this.country = trader.getCountry();
        this.email = trader.getEmail();
        this.first_name = trader.getFirst_name();
        this.last_name = trader.getLast_name();
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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "TraderAccountView{" +
                "amount=" + amount +
                ", id=" + id +
                ", trader_id=" + trader_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", dob=" + dob +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
