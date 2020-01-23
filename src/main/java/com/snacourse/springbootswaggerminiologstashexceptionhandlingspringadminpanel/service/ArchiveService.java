package com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.service;


import com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.model.Archive;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * Archive is the service interace  we'll be using to archive logics.
 *
 * @author Shabab koohi
 */

public interface ArchiveService {


    Archive addArchive( Archive reportLayout, MultipartFile imageFile,MultipartFile pdfFile,MultipartFile audioFile);



    Archive getArchive(Long archiveId);


    List<Archive> getArchives();




}
