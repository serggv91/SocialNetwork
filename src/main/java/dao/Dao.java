package dao;

public interface Dao<E, K>  {
    E getEntityById(K id);
    E update(E entity);
    boolean delete(K id);
    boolean create(E entity);
}
