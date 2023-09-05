package com.example.protobuf;

import com.proto.model.Address;
import com.proto.model.Car;
import com.proto.model.Person;

import java.util.ArrayList;
import java.util.List;

public class CompositonDemo {
    public static  void main(String[] args){

        Address address = Address.newBuilder()
                .setCity("HCM")
                .setPostbox(123)
                .setStreet("Nam KI")
                .build();

        Car car1 = Car.newBuilder()
                .setMake("China")
                .setModel("new")
                .setYear(2023)
                .build();
        Car car2 = Car.newBuilder()
                .setMake("China")
                .setModel("new")
                .setYear(2023)
                .build();

        List<Car> lst = new ArrayList<Car>();
        lst.add(car1);
        lst.add(car2);

        Person person = Person.newBuilder()
                .setName("linh")
                .setAge(23)
                .setAddress(address)
                .addAllCar(lst)
                .build();

        System.out.println(person);
    }
}
