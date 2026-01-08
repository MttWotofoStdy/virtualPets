package com.example.perestoronin.springbook.simple_spring_boot_mvc.dao.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "pet_journal_entry")
public class PetJournalEntry{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @Enumerated(EnumType.STRING)
      private JournalEntryId journalEntryId; // ← это ключ для Map

    private boolean readed;
    @Version
    private int version;

    public Integer getId() {
        return id;
    }

    public Pet getPet() {
        return pet;
    }

    public JournalEntryId getJournalEntryId() {
        return journalEntryId;
    }

    public boolean isReaded() {
        return readed;
    }

    public int getVersion() {
        return version;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setJournalEntryId(JournalEntryId journalEntryId) {
        this.journalEntryId = journalEntryId;
    }

    public void setReaded(boolean readed) {
        this.readed = readed;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}