package ca.jrvs.apps.trading.model.domain;

import io.swagger.models.auth.In;

public class Position implements Entity<Integer> {

    private Integer accountId;

    private String ticker;

    private Long position;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Position{" +
                "accountId=" + accountId +
                ", ticker='" + ticker + '\'' +
                ", position=" + position +
                '}';
    }

    @Override
    public Integer getId() {
        return accountId;
    }

    @Override
    public void setId(Integer integer) {
        this.accountId = integer;
    }
}
