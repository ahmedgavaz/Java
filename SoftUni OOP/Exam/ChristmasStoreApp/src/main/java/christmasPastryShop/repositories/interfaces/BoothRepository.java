package christmasPastryShop.repositories.interfaces;

public interface BoothRepository<T> extends Repository<T> {
    double getIncome();

    void setIncome(double income);

    T getByNumber(int number);

}
