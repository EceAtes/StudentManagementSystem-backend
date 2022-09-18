package com.testProject.ws.courses;

import lombok.Data;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Data
@Entity
@Table(name="courses")
public class Course {
    @Id
    @GeneratedValue
    private long Id;

    private String name;
    private String type;
    private String code;
    private int time;
    private String room;
    private String lecturer;

    @ElementCollection
    private List<String> assistant;

    @Override
    public String toString() {
        return "Course{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", code='" + code + '\'' +
                ", time=" + time +
                ", room='" + room + '\'' +
                ", lecturer='" + lecturer + '\'' +
                ", assistant=" + assistant +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public List<String> getAssistant() {
        return assistant;
    }

    public void setAssistant(List<String> assistant) {
        this.assistant = assistant;
    }
}
