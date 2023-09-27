package utils.event;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Classe inspiré des UnityEvents du logiciel éponyme
 * @param <T>
 */
public class CustomEvent<T> {
    private final List<Consumer<T>> listeners = new ArrayList<>();

    public CustomEvent<T> addListener(Consumer<T> listener){
        listeners.add(listener);
        return this;
    }

    public CustomEvent<T> removeListener(Consumer<T> listener){
        listeners.remove(listener);
        return this;
    }

    /**
     * Permet lancer toutes les méthodes de l'event avec l'argument voulut
     * @param arg
     */
    public void invoke(T arg){
        listeners.forEach(listeners -> listeners.accept(arg));
    }
}
