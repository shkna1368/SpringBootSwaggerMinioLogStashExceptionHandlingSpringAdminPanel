package com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "ARCHIVE")
@ApiModel(value="Archive",description = "All details about the archive. ")
public class Archive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ARCHIVE_ID", unique = true)
    private Long archiveId;



    @ApiModelProperty( value = "title")
    @NotNull
    @NotBlank
    @Column(name = "TITLE",unique = true)
    @NotEmpty(message = "title is required")
    private String title;

    @NotNull
    @NotBlank
    @Column(name = "DESCRYPTIONS",unique = true)
    @NotEmpty(message = "descryptins is required")
    private String descryptions;


    @NotNull
    @NotBlank
    @Column(name = "PDF_URL", length = 1500)
    private String pdfURL;

    @NotNull
    @NotBlank
    @Column(name = "AUDIO_URL", length = 1500)
    private String audioURL;



    @NotNull
    @NotBlank
    @Column(name = "IMAGE_URL", length = 1500)
    private String imageURL;


    @Column(name = "CREATED_AT",nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;


    @Column(name = "UPDATE_AT",nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;





    @PrePersist
    public void setCreationDate() {
        this.createdAt = new Date();

    }

    @PreUpdate
    public void setChangeDate() {
        this.updatedAt = new Date();
    }


    public Long getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Long archiveId) {
        this.archiveId = archiveId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public String getPdfURL() {
        return pdfURL;
    }

    public void setPdfURL(String pdfURL) {
        this.pdfURL = pdfURL;
    }

    public String getAudioURL() {
        return audioURL;
    }

    public void setAudioURL(String audioURL) {
        this.audioURL = audioURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDescryptions() {
        return descryptions;
    }

    public void setDescryptions(String descryptions) {
        this.descryptions = descryptions;
    }
}
