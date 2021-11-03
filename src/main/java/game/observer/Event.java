package game.observer;

/**
 * tank
 */
public abstract class Event<T> {
    /** 事件源对象 */
    T t;

    /**
     * 获取事件源对象
     * @return
     */
    abstract T getSource();
}
