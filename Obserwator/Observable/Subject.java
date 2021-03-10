package Obserwator.Observable;

import Obserwator.Observer.Observer;

public interface Subject {
    void register(Observer o);
    void unregister(Observer o);
    void notifyObserver();

}
