package ca.jrvs.apps.trading.dao;

import ca.jrvs.apps.trading.model.domain.Entity;
import ca.jrvs.apps.trading.model.domain.Quote;
import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class JdbcCrudDao<T extends Entity<Integer>> implements CrudRepository<T, Integer> {

    private static final Logger logger = LoggerFactory.getLogger(JdbcCrudDao.class);

    abstract public JdbcTemplate getJdbcTemplate();

    abstract public SimpleJdbcInsert getSimpleJdbcInsert();

    abstract public String getTableName();

    abstract public String getIdColumnName();

    abstract Class<T> getEntityClass();

    /**
     * save an entity and update autogenerated inter id
     * @param entity to be saved
     * @return save entity
     * @param <S>
     */
    @Override
    public <S extends T> S save(S entity){
        if (existsById(entity.getId())){
            if (updateOne(entity) != 1){
                throw  new DataRetrievalFailureException("unable to update quote");
            }
        }else {
            addOne(entity);
        }
        return entity;
    }

    /**
     * helper method that saves one quote
     * @param entity
     * @param <S>
     */
    public <S extends T> void addOne(S entity){
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(entity);
        Number newId = getSimpleJdbcInsert().executeAndReturnKey(parameterSource);
        entity.setId(newId.intValue());
    }

    /**
     * helper method that updates one quote
     * @param entity
     * @return
     */
    abstract public  int updateOne(T entity);

    /**
     * finds trader by id
     * @param id trader id
     * @return trader object of id
     */
    @Override
    public Optional<T> findById(Integer id){
        Optional<T> entity = Optional.empty();
        String selectSql = "SELECT * FROM " + getTableName() + " WHERE " + getIdColumnName() + " =?";
        try{
            entity = Optional.ofNullable((T) getJdbcTemplate().queryForObject(selectSql, BeanPropertyRowMapper.newInstance(getEntityClass()), id));
        } catch (IncorrectResultSizeDataAccessException e){
            logger.debug("Can't find id");
        }
        return entity;
    }

    /**
     * checks if trader exists
     * @param id of trader
     * @return boolean of trader existance
     */
    @Override
    public boolean existsById(Integer id){
        boolean exists = false;
        String selectSql = "SELECT EXISTS(SELECT 1 FROM " + getTableName() + " WHERE " + getIdColumnName() + " =?)";
        try {
            exists = getJdbcTemplate().queryForObject(selectSql, boolean.class, id);
        } catch (Exception e){
            logger.debug("could not execute query", e);
        }
        return exists;
    }

    /**
     * finds all traders in the db
     * @return a list of all traders
     */
    @Override
    public List<T> findAll(){
        List<T> founds;
        String selectSql = "SELECT * FROM " + getTableName();
        try {
            founds = getJdbcTemplate().query(selectSql, BeanPropertyRowMapper.newInstance(getEntityClass()));
        }
        catch (Exception e){
            throw new DataRetrievalFailureException("failed to access data", e);
        }
        return founds;
    }

    /**
     * finds all traders from list of ids
     * @param ids of traders to find
     * @return list of traders found
     */
    public List<T> findAllById(Iterable<Integer> ids){
        List<T> founds = new ArrayList<>();
        ids.forEach(id -> founds.add(findById(id).get()));
        return founds;
    }

    /**
     * delete trader from db by id
     * @param id of trader
     */
    @Override
    public void deleteById(Integer id){
        String deleteSql = "DELETE FROM " + getTableName() + " WHERE " + getIdColumnName() + " =?";
        try {
            getJdbcTemplate().update(deleteSql);
        } catch (Exception e){
            logger.debug("unable to update entry", e);
        }
    }

    /**
     * counts all traders in db
     * @return count of all traders
     */
    @Override
    public long count(){
        Long count = 0l;
        String selectSql = "SELECT COUNT(*) FROM " + getTableName();
        try {
            count = getJdbcTemplate().queryForObject(selectSql, Long.class);
        } catch (Exception e){
            logger.debug("Unable to process query", e);
        }
        return count;
    }

    /**
     * deletes all traders from db
     */
    @Override
    public void deleteAll(){
        String deleteSql = "DELETE FROM " + getTableName();
        try {
            getJdbcTemplate().update(deleteSql);
        } catch (Exception e){
            logger.debug("unable to delete", e);
        }
    }
}
