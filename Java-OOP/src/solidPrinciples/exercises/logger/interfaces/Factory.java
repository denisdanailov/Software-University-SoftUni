package solidPrinciples.exercises.logger.interfaces;

public interface Factory<T> {
    T produce(String input);
}
