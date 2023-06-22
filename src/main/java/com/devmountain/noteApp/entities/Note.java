package com.devmountain.noteApp.entities;

import com.devmountain.noteApp.dtos.NoteDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Notes")
@Data //Lombok dependency
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    //create two private member variables called “id” of type “Long” and “body” of type “String” and give each member the corresponding annotations
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String body;

    @ManyToOne
    @JsonBackReference
    private User user;

    public Note(NoteDto noteDto){
        if (noteDto.getBody() != null) {
            this.body = noteDto.getBody();
        }

    }

}
