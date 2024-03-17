package com.company;

public class Main {

    public static void main(String[] args) {
	    // Паттерн (Композит энтити) который объединяет разный код и его реализацию,
        // а через отдельный класс вызывается в коде

        CompositeEntity compositeEntity = new CompositeEntity();
        for (String s: compositeEntity.getData()){
            System.out.println(s);
        }

    }
}

// то есть у нас есть 2 класса (допустим это несколько сервисов в сети)
class DependentObject1{
    String getData(){
        return "one";
    }
}

class DependentObject2{
    String getData(){
        return "two";
    }
}

// мы их объеденяем вместе (что-бы не дергать их по отдельности)
class CoarseGainedObject{
    DependentObject1 d1 = new DependentObject1();
    DependentObject2 d2 = new DependentObject2();
    public String[] getData(){
        return new String[] {d1.getData(), d2.getData()};
    }
}

// но работаем с ним через третий, так прошлые 2, можно убрать на строну сервера
class CompositeEntity{
    CoarseGainedObject coarseGainedObject = new CoarseGainedObject();

    public String[] getData(){
        return coarseGainedObject.getData();
    }
}