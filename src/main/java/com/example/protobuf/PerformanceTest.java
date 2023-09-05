package com.example.protobuf;

import com.exmaple.json.JPerson;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proto.model.Person;

public class PerformanceTest {
    public static void main(String[] args) {

        //json
        JPerson person = new JPerson();
        person.setAge(12);
        person.setName("tri");

        ObjectMapper mapper = new ObjectMapper();


        // json
        Runnable json = () -> {
            try {
                byte[] bytes = mapper.writeValueAsBytes(person);
                JPerson person1 = mapper.readValue(bytes, JPerson.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Person linh = Person.newBuilder()
                .setAge(14)
                .setName("nam")
                .build();

        // proto
        Runnable proto = () -> {
            try {
                byte[] bytes = linh.toByteArray();
                Person linh1 = Person.parseFrom(bytes);
            } catch (Exception e) {

            }
        };

        runPerformanceTest(json, "JSON");
        runPerformanceTest(proto, "PROTO");
    }



    public static void runPerformanceTest(Runnable runnable, String method) {
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            runnable.run();
        }

        long time2 = System.currentTimeMillis();
        System.out.println(
                method + ":" + (time2 - time1) + "ms"
        );
    }
}
