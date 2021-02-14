package org.example.entity;

import lombok.Data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Data
public class ContactBuffers {
    int lengs = 1025;
    ByteBuffer byteBuffer = ByteBuffer.allocate(100);
    FileChannel fileChannel;


    public void writeContact(String contact) throws IOException {
        byteBuffer.clear();
        byteBuffer.put(contact.getBytes());
        byteBuffer.flip();
        FileOutputStream fileOutputStream = new FileOutputStream("Phone book.txt", true);
        fileChannel = fileOutputStream.getChannel();
        for (int i = 1; i < lengs; i++) {
            fileChannel.write(byteBuffer);
        }
        byteBuffer.clear();
    }


    private List<String> getArraycontact(Consumer<String> consumer) throws IOException {

        List<String> list = new ArrayList<>();

        try (ByteChannel channel = Files.newByteChannel(Path.of("Phone book.txt"), StandardOpenOption.READ)) {
            String stringBuffer = "";
            while (channel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                stringBuffer += new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit());
                String[] parts = stringBuffer.split("\n");

                for (int i = 0; i < parts.length - 1; i++) {
                    list.add(parts[i]);
                    consumer.accept(parts[i]);
                }
                stringBuffer = parts[parts.length - 1];
                byteBuffer.clear();
                consumer.accept(stringBuffer);
            }
        }
        return list;
    }
}
