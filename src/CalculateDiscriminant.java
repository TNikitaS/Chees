@FunctionalInterface
public interface CalculateDiscriminant<T extends Double> {
    double calculateDiscriminant(T a, T b, T c);
}
