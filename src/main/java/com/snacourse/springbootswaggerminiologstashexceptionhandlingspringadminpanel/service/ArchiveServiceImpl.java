package com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.service;


import com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.exception.ConflictException;
import com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.exception.NotFoundException;
import com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.exception.SqlException;
import com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.helper.MinioFileManager;
import com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.model.Archive;
import com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.repository.ArchiveRepository;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ArchiveServiceImpl implements ArchiveService {

    ArchiveRepository archiveRepository;
    MinioFileManager minioFileManager;

    private final String MINIO_ENDPOINT ="http://127.0.0.1:9000";
    private final String ACCESSKEY="minioadmin";
    private final String SECRETKEY="minioadmin";

    private Logger logger = LoggerFactory.getLogger(ArchiveServiceImpl.class);

    @Autowired
    public ArchiveServiceImpl(ArchiveRepository archiveRepository,MinioFileManager minioFileManager) {

        this. minioFileManager=minioFileManager;

        this.archiveRepository = archiveRepository;


    }


    @Override
    public Archive addArchive( Archive archive, MultipartFile imageFile,MultipartFile pdfFile,MultipartFile audioFile) {
    try {
logger.info("ArchiveServiceImpl.addArchive","title="+archive.getTitle());
     String imageURL = minioFileManager.addFileToMinio(imageFile, "pic", MINIO_ENDPOINT,
                ACCESSKEY, SECRETKEY, "uploading_image_file_error", ContentType.IMAGE_JPEG.toString());


         String pdfURL = minioFileManager.addFileToMinio(pdfFile, "pdf", MINIO_ENDPOINT,
                ACCESSKEY, SECRETKEY, "uploading_pdf_file_error", "pdf");


         String audioURL = minioFileManager.addFileToMinio(audioFile, "audio", MINIO_ENDPOINT,
                ACCESSKEY, SECRETKEY, "uploading_audio_file_error", "mp3");
        archive.setAudioURL(audioURL);
        archive.setPdfURL(pdfURL);
        archive.setImageURL(imageURL);

    }
catch (Exception e){
        logger.error("ArchiveServiceImpladdArchive","file not found");
    System.out.println(e.toString());
}


        archive.setTitle(System.currentTimeMillis()+"");
        Archive savedArchive=null;

        try {
            savedArchive=archiveRepository.save(archive);

    }
    catch (DataIntegrityViolationException e) {
        logger.error("ArchiveServiceImpladdArchive","DataIntegrityViolationException"+e.toString());

        throw new ConflictException("error_conflict_data");
    } catch (Exception e) {
        logger.error("ArchiveServiceImpladdArchive","Exception"+e.toString());

        throw new SqlException("error_while_save");
    }

        return  savedArchive;
    }

    @Override
    public Archive getArchive(Long archiveId) {

        Optional<Archive> archiveOptional=archiveRepository.findByArchiveId(archiveId);
        if (!archiveOptional.isPresent()){
            logger.warn("ArchiveServiceImpladdArchive.getArchive","not found with id="+archiveId);

            throw new NotFoundException("archive with id" +archiveId+" not foynd");
        }
        return archiveOptional.get();
    }

    @Override
    public List<Archive> getArchives() {
        logger.info("ArchiveServiceImpl.getArchives");

        List<Archive> archives= (List<Archive>) archiveRepository.findAll();
     return archives;
    }
}
