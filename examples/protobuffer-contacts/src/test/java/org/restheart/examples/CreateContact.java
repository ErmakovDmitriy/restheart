package org.restheart.examples;

import java.io.IOException;
import com.google.protobuf.InvalidProtocolBufferException;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class CreateContact {
    public static void main(String[] args) throws Exception  {
        if (args.length < 3) {
            System.out.print("""
                Needs 3 arguments: <name> <email> <phone>
                             """);
            System.exit(-1);
        }

        createContact(args[0], args[1], args[2]);
    }

    public static void createContact(String name, String email, String phone) throws UnirestException, InvalidProtocolBufferException, IOException  {
        var body = ContactPostRequest.newBuilder()
            .setName(name)
            .setEmail(email)
            .setPhone(phone)
            .build();

        var resp = Unirest.post("http://localhost:8080/proto")
                .header("Content-Type", "application/protobuf")
                .body(body.toByteArray())
                .asBinary();

        System.out.println("response status: " + resp.getStatus());

        try {
            var reply = ContactPostReply.parseFrom(resp.getBody().readAllBytes());
            System.out.println("id of new contact: " + reply.getId());
        } catch(InvalidProtocolBufferException e) {
            System.out.println("error parsing response: " + e.getMessage());
        }
    }
}
