package api;
import java.util.Optional;
public interface Searchable<T, ID> { Optional<T> findById(ID id); }
