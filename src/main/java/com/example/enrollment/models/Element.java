package com.example.enrollment.models;

import lombok.*;

import javax.persistence.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@Table(name = "elements")
public class Element {

    protected Element() {}
    @Id @Column(name="id")
    private String id;
    @Column(name="parentid")
    private String parentId;
    @Column(name="url")
    private String url;
    @Column(name="size")
    private Integer size;
    @Column(name="type")
    @Enumerated(EnumType.STRING)
    private SystemItemType type;
    @Column(name = "date")
    private String date;

    public Element(String id, String parentId, String url, Integer size, SystemItemType type) {
        this.id = id;
        this.parentId = parentId;
        this.url = url;
        this.size = size;
        if (type.equals("FILE"))
            this.type = SystemItemType.FILE;
        else
            this.type = SystemItemType.FOLDER;
    }

    /*
    public void saveElement(String baseUrl) throws IOException {
        ReadableByteChannel readableByteChannel = Channels.newChannel(new URL(baseUrl + "/" + url).openStream());
        FileOutputStream fileOutputStream = new FileOutputStream(url);
        FileChannel fileChannel = fileOutputStream.getChannel();
        fileOutputStream.getChannel()
                .transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
    }
*/
}
