package practice.program.java.designpattern.observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Subscriber<T> {
//    int a = 0;
    default void display(){
        System.out.println("gfdsa");
    }
    default void onChange(T data){}
}

interface Observable<T> {
    void setResponse(T response);

    void addObserver(Subscriber<T> subscriber);

    void removeObserver(Subscriber<T> subscriber);
}

class SampleData {
    private String id;
    private String name;
    private int age;
    private int[] arr;

    public SampleData(String id, String name, int age, int[] arr) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.arr = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            this.arr[i] = arr[i];
        }
    }

    public int[] getArr() {
        return arr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SampleData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class NewsObservable<T> implements Observable<T> {
    private final List<Subscriber<T>> subscribersList;
    private T response;

    public NewsObservable() {
        subscribersList = new ArrayList<>();
    }

    @Override
    public void setResponse(T response) {
        this.response = response;
        notifyChange();
    }

    @Override
    public void addObserver(Subscriber<T> subscriber) {
        if (!subscribersList.contains(subscriber))
            subscribersList.add(subscriber);
    }

    @Override
    public void removeObserver(Subscriber<T> subscriber) {
        subscribersList.remove(subscriber);
    }

    private void notifyChange() {
        for (Subscriber<T> subscriber : subscribersList) {
            subscriber.onChange(response);
        }
    }
}

class NewsSubscriber implements Subscriber<SampleData> {
    private final String name;

    public NewsSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void onChange(SampleData data) {
        System.out.println(name + " : " + data.toString());
    }
}

public class ObserverPatternPractice {
    public static void main(String[] args) {

        Observable<SampleData> observable = new NewsObservable<>();
        Subscriber<SampleData> subscriber1 = new NewsSubscriber("First");
        Subscriber<SampleData> subscriber2 = new NewsSubscriber("Second");
        Subscriber<SampleData> subscriber3 = new NewsSubscriber("Third");
        observable.addObserver(subscriber1);
        observable.addObserver(subscriber2);
        observable.setResponse(new SampleData("1", "sandeep", 32, new int[] { 1, 2}));
        observable.addObserver(subscriber3);
        observable.setResponse(new SampleData("2", "sandy", 30, new int[] { 1, 2}));
        observable.removeObserver(subscriber2);
        observable.setResponse(new SampleData("3", "baghira", 8, new int[] { 1, 2}));

        int[] arr = new int[]{4, 3, 2};

        SampleData data = new SampleData("a","abc",9, arr);
        System.out.println(Arrays.toString(data.getArr()));
        arr[2] = 8;
        System.out.println(Arrays.toString(data.getArr()));
    }
}
