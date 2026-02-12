package fr.esgi.log;

public interface ILog {

    boolean isSuccess();

    boolean isError();

    default boolean isWarning() {
        return false;
    }
}
