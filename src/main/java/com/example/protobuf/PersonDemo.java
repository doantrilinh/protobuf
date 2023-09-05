package com.example.protobuf;

import com.proto.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PersonDemo {
   public static void main(String[] args) throws IOException {
//       Person linh =  Person.newBuilder()
//               .setAge(10)
//               .setName("linh")
//               .build();
       Path path = Paths.get("lin.ser");
//       Files.write(path, linh.toByteArray());

       byte[] bytes = Files.readAllBytes(path);
       Person newLinh = Person.parseFrom(bytes);



       System.out.println(newLinh);
   }
}
