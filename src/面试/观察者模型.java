package 面试;

import java.util.ArrayList;


public class 观察者模型 {

}

interface IObserver {
    void upData();
}
interface IOwner {
    void addObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void notifyObserver();
}
class MyIObserver implements IObserver {

    @Override
    public void upData() {

    }
}
class MyIOwner implements IOwner {

    private ArrayList<IObserver> list;
    public MyIOwner() {
        list = new ArrayList<IObserver>();
    }

    @Override
    public void addObserver(IObserver observer) {
        list.add(observer);
    }
    @Override
    public void removeObserver(IObserver observer) {
        list.remove(observer);
    }
    @Override
    public void notifyObserver() {
        for (IObserver observer: list) {
            observer.upData();
        }
    }
}

