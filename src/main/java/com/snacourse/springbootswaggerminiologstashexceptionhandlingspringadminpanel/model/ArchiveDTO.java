package com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;


@ApiModel(value="ArchiveDTO",description = "All details about the archiveDTO. ")
public class ArchiveDTO {

    @ApiModelProperty(required = false, hidden = true)

    private Long archiveId;

    @ApiModelProperty(required = true)
    private String title;

      @ApiModelProperty(required = true)
    private String descryptions;



    @ApiModelProperty(required = false, hidden = true)
    private String pdfURL;

    @ApiModelProperty(required = false, hidden = true)
    private String audioURL;

    @ApiModelProperty(required = false, hidden = true)
    private String imageURL;

    @ApiModelProperty(required = false, hidden = true)
    private Date createdAt;

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

    public String getDescryptions() {
        return descryptions;
    }

    public void setDescryptions(String descryptions) {
        this.descryptions = descryptions;
    }
}
