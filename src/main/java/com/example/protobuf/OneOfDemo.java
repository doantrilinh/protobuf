package com.example.protobuf;

import com.proto.model.Credentials;
import com.proto.model.EmailCredentials;
import com.proto.model.PhoneOTP;

public class OneOfDemo {
    public static void main(String[] args){
        EmailCredentials emailCredentials = EmailCredentials.newBuilder()
                .setEmail("doantrilinh@gmail.com")
                .setPassword("123456")
                .build();

        PhoneOTP phoneOTP = PhoneOTP.newBuilder()
                .setCode(123)
                .setNumber(0376052775)
                .build();

        Credentials credentials = Credentials.newBuilder()
                .setEmailMode(emailCredentials)
                .setPhoneMode(phoneOTP)
                .build();

        login(credentials);

    }
    public static void login(Credentials credentials){
        switch(credentials.getModeCase()){
            case EMAILMODE:
                System.out.println(credentials.getEmailMode());
                break;
            case PHONEMODE:
                System.out.println(credentials.getPhoneMode());
                break;
        }
    }
}
