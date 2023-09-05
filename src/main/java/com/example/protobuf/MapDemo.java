package com.example.protobuf;


import com.proto.model.Car;
import com.proto.model.Dealer;

public class MapDemo {
    public static void main(String[] args){
        Car car1 = Car.newBuilder()
                .setMake("China")
                .setModel("new")
                .setYear(2023)
                .setBodyStyleValue(0)
                .build();
        Car car2 = Car.newBuilder()
                .setMake("VN")
                .setModel("old")
                .setYear(2022)
                .build();

        Dealer dealer = Dealer.newBuilder()
                .putModel(1, car1)
                .putModel(2, car2)
                .build();

        System.out.println(dealer.getModelOrThrow(1).getBodyStyle());
    }
}
