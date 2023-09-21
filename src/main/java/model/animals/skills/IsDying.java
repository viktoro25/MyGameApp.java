package model.animals.skills;

public interface IsDying {

    /**
     * Метод здійснює модуляцію смерті тварини.
     */
    default void isDying() {
        if (isAlive()) {
            setAlive(false);
            onDeath();
        }
    }

    /**
     * Метод, який викликається під час смерті тварини (перед видаленням з ігрового світу).
     */
    void onDeath();

    /**
     * Перевіряє, чи жива тварина.
     *
     * @return true, якщо тварина жива, false - якщо ні.
     */
    boolean isAlive();

    /**
     * Встановлює статус життя тварини.
     *
     * @param alive true, якщо тварина жива, false - якщо ні.
     */
    void setAlive(boolean alive);

    void kill();
}
