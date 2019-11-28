package db;

import java.util.Optional;

public interface CRUDRepository<T> {
        void save(T t);

        void update(T t);

        T find(String t);

        void delete(T t);
}
