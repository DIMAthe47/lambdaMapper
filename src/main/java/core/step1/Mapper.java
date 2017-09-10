package core.step1;


public interface Mapper<S, T> {

    void map(S source, T target);

    default T map(S source, Class<T> targetClass) {
        T target = null;
        try {
            target = targetClass.newInstance();
            this.map(source, target);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return target;
    }

//    public <T1> void checkTypeSupplier(Supplier<T1> source) {
//    }

//    public <T2> void checkTypeConsumer(Consumer<T2> consumer) {
//    }

}
