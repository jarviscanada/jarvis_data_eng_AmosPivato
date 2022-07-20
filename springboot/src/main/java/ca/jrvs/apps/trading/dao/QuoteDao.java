package ca.jrvs.apps.trading.dao;

import ca.jrvs.apps.trading.model.domain.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class QuoteDao implements CrudRepository<Quote, String> {

    private static final String TABLE_NAME  = "quote";
    private static final String ID_COLUMN_NAME = "ticker";

    private static final Logger logger = LoggerFactory.getLogger(QuoteDao.class);
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    public QuoteDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName(TABLE_NAME);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public SimpleJdbcInsert getSimpleJdbcInsert() {
        return simpleJdbcInsert;
    }

    public void setSimpleJdbcInsert(SimpleJdbcInsert simpleJdbcInsert) {
        this.simpleJdbcInsert = simpleJdbcInsert;
    }

    /**
     *
     * @param quote quote object to save
     * @return qupte object saved
     * @throws org.springframework.dao.DataAccessException for unexpected sql result or swl execution failure
     */
    @Override
    public Quote save(Quote quote) {
        if (existsById(quote.getTicker())){
            int updatedRowNo = updateOne(quote);
            if (updatedRowNo != 1){
                throw new DataRetrievalFailureException("unable to update quote");
            }
        }else {
            addOne(quote);
        }
        return quote;
    }

    /**
     * helper method for saving quotes
     * @param quote
     */
    private void addOne(Quote quote){
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(quote);
        int row = getSimpleJdbcInsert().execute(parameterSource);
        if (row != 1){
            throw new IncorrectResultSizeDataAccessException("Failed toinsert", 1, row);
        }
    }

    /**
     * helper method for save
     * @param quote
     * @return statement response
     */
    private int updateOne(Quote quote){
        String update_sql = "UPDATE "+ TABLE_NAME +" SET last_price=?, bid_price=?, "
            + "bid_size=?, ask_price=?, ask_size=? WHERE " + ID_COLUMN_NAME + "=?"+ ";";
        return getJdbcTemplate().update(update_sql, makeUpdateValues(quote));
    }

    /**
     * helper method tha tmakes sql update vales objects
     * @param quote to be updated
     * @return UPDATE_SQL values
     */
    private Object[] makeUpdateValues(Quote quote){
        Object[] values = {quote.getLastPrice(), quote.getBidPrice(), quote.getBidSize(), quote.getAskPrice(), quote.getAskSize(), quote.getTicker()};
        return values;
    }

    /**
     * saves all and insert quotes in iterable
     * @param iterable
     * @return list of quotes that were inserted
     * @param <S>
     */
    @Override
    public <S extends Quote> List<S> saveAll(Iterable<S> iterable) {
        List<S> quotes = new ArrayList<>();
        iterable.forEach(q -> quotes.add((S)save(q)));
        return quotes;
    }

    /**
     * find a qupte by ticker
     * @param ticker name
     * @return quote or Optional.empty if not found
     */
    @Override
    public Optional<Quote> findById(String ticker) {
        Optional<Quote> quote;
        Quote response;
        ticker = ticker.toUpperCase();
        String selectSql = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID_COLUMN_NAME + "="+ "'" + ticker + "';";
        if (existsById(ticker)){
            response = getJdbcTemplate().queryForObject(selectSql, BeanPropertyRowMapper.newInstance(Quote.class)); //if exception possible add try catch
        }
        else{
            response = null;
        }

        quote = Optional.ofNullable(response);
        if (quote.equals(Optional.empty())){
            logger.debug("cannot find trader id:" + ticker);
        }
        return quote;
    }

    /**
     * checks if quote with ticker exists
     * @param ticker name
     * @return boolean of if it exists or not
     */
    @Override
    public boolean existsById(String ticker) {
        Boolean exists;
        String selectSql = "SELECT EXISTS(SELECT 1 FROM " + TABLE_NAME + " WHERE " + ID_COLUMN_NAME + "=" + "'" + ticker + "');";
        exists = getJdbcTemplate().queryForObject(selectSql, boolean.class);
       return exists;
    }

    /**
     * return all quotes
     * @throws  DataRetrievalFailureException if failed to access
     * @return list of quotes
     */
    @Override
    public List<Quote> findAll() {
        String selectSql = "SELECT * From " + TABLE_NAME + ";";
        List<Quote> quotes;
        try {
            quotes = getJdbcTemplate().query(selectSql, BeanPropertyRowMapper.newInstance(Quote.class));
        }
        catch (Exception e){
            throw new DataRetrievalFailureException("failed to access data", e);

        }
        return quotes;
    }

    /**
     * count all entries in quote table
     * @return count of quotes
     */
    @Override
    public long count() {
        String selectSql = "SELECT COUNT(*) FROM " + TABLE_NAME + ";";
        Long count = getJdbcTemplate().queryForObject(selectSql, Long.class);
        return count;
    }

    /**
     * delete quote from table by ticker
     * @param ticker name
     */
    @Override
    public void deleteById(String ticker) {
        if (ticker == null){
            throw new IllegalArgumentException("id cannot be null");
        }
        String deleteSql = "DELETE FROM " + TABLE_NAME + " WHERE " + ID_COLUMN_NAME + "=" + "'" + ticker + "';";
        getJdbcTemplate().update(deleteSql);
    }

    /**
     * delete all entries in table
     */
    @Override
    public void deleteAll() {
        getJdbcTemplate().update("DELETE FROM " + TABLE_NAME+ ";");
    }

    @Override
    public Iterable<Quote> findAllById(Iterable<String> iterable) {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public void delete(Quote quote) {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public void deleteAll(Iterable<? extends Quote> iterable) {
        throw new UnsupportedOperationException("not implemented");
    }

}
