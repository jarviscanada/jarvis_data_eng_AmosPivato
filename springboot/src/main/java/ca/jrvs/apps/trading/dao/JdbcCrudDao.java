package ca.jrvs.apps.trading.dao;

import ca.jrvs.apps.trading.model.domain.Entity;
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
        if (existsBydId(entity.getId())){
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

    @Override
    public boolean existsById(Integer id){

    }

    @Override
    public List<T> findAll(){

    }

    public List<T> findAllById(Iterable<Integer> ids){

    }

    @Override
    public void deleteById(Integer id){

    }

    @Override
    public long count(){

    }

    @Override
    public void deleteAll(){

    }
}
