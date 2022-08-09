package daos;

import java.util.List;

public interface genericDao<T> {
    public T findById(int id);
    public List findAll();
    public Boolean update(T dto);
    public Boolean create(T dto);
    public Boolean delete(int id);
}
