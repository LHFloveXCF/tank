/**
 * tank
 */
public class Singleton {
    public static Singleton getInstance() {
        return InnerSingleton.INSTANCE;
    }

    private static class InnerSingleton {
        private static final Singleton INSTANCE = new Singleton();
    }

    /**
     * 私有构造器，外部无法创建对象
     */
    private Singleton () {}
}
