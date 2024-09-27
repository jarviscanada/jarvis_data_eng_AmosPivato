package ca.jrvs.apps.trading.service;

import ca.jrvs.apps.trading.dao.AccountDao;
import ca.jrvs.apps.trading.dao.PositionDao;
import ca.jrvs.apps.trading.dao.QuoteDao;
import ca.jrvs.apps.trading.dao.TraderDao;
import ca.jrvs.apps.trading.model.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DashboardService {

    private TraderDao traderDao;
    private PositionDao positionDao;
    private AccountDao accountDao;
    private QuoteDao quoteDao;

    @Autowired
    public DashboardService(TraderDao traderDao, PositionDao positionDao, AccountDao accountDao, QuoteDao quoteDao){
        this.traderDao = traderDao;
        this.positionDao = positionDao;
        this.accountDao = accountDao;
        this.quoteDao = quoteDao;
    }

    public List<Trader> getTraders(){
        return traderDao.findAll();
    }

    /**
     * create and return a traderaccountview by trader id
     * - get trader account by id
     * - get trader info by id
     * - create and return a traderAccountView
     * @param traderId
     * @returntraderaccountview
     * @throws IllegalArgumentException if trader id is null or not found
     */
    public TraderAccountView getTraderAccount(Integer traderId){
        if (!accountDao.existsById(traderId) || traderId == null){
            throw new IllegalArgumentException("trader id is not found");
        }
        Account account = findAccountByTraderId(traderId);
        Trader trader = traderDao.findById(traderId).get();
        return new TraderAccountView(trader, account);
    }

    /**
     * create and return portfolioview by traderid
     * - get account by traderid
     * - get positions by account id
     * - create and return a portfolioview
     * @param traderId
     * @return postfolioview
     * @throws IllegalArgumentException if trader is null or not found
     */
    public PortfolioView getProfileViewByTraderId(Integer traderId){
        if (!accountDao.existsById(traderId) || traderId == null){
            throw new IllegalArgumentException("trader id is not found");
        }
        //Account account = findAccountByTraderId(traderId);
        Position position = positionDao.findById(traderId).get();
        SecurityRow row = new SecurityRow();
        row.setPosition(position);
        row.setTicker(position.getTicker());
        row.setQuote(quoteDao.findById(position.getTicker()).get());
        PortfolioView view = new PortfolioView();
        SecurityRow[] rows = {row};
        view.setSecurityRows(rows);
        return view;
    }

    /**
     * helper method
     * @param traderId
     * @return account
     * @throws IllegalArgumentException traderIs is not found
     */
    private Account findAccountByTraderId(Integer traderId){
        if (!accountDao.existsById(traderId) || traderId == null){
            throw new IllegalArgumentException("trader id is not found");
        }
        return accountDao.findById(traderId).get();
    }
}
