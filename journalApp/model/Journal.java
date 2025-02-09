// package com.example.journalapp.model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import java.time.LocalDate;

// @Entity
// public class Journal {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String title;
//     private String content;
//     private LocalDate createdDate;

//     public Journal() {}

//     public Journal(String title, String content, LocalDate createdDate) {
//         this.title = title;
//         this.content = content;
//         this.createdDate = createdDate;
//     }

//     // Getters and Setters
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getTitle() {
//         return title;
//     }

//     public void setTitle(String title) {
//         this.title = title;
//     }

//     public String getContent() {
//         return content;
//     }

//     public void setContent(String content) {
//         this.content = content;
//     }

//     public LocalDate getCreatedDate() {
//         return createdDate;
//     }

//     public void setCreatedDate(LocalDate createdDate) {
//         this.createdDate = createdDate;
//     }
// }
