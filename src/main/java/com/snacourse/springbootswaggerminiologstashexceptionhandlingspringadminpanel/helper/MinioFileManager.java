package com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.helper;

import com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.exception.MinioException;
import io.minio.MinioClient;
import io.minio.ServerSideEncryption;
import io.minio.errors.*;
import org.apache.http.entity.ContentType;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Component
public class MinioFileManager {

    public String addFileToMinio(MultipartFile file, String bucketName, String endPoint, String accessKey,
                                 String secretKey, String exceptionMessage, String contentType) {

        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        try {

            MinioClient minioClient = new MinioClient(endPoint, accessKey, secretKey);
            boolean isExist = minioClient.bucketExists(bucketName);
            if (isExist) {
            } else {
                minioClient.makeBucket(bucketName);
            }

            minioClient.putObject(bucketName, fileName,file.getInputStream(),file.getSize(),null ,null,contentType);

            //a day
            String fileUrl = minioClient.presignedGetObject(bucketName, fileName,60 * 60 * 24);


            return fileUrl;
        } catch (Exception e) {
            throw new MinioException(exceptionMessage);
        }

    }




}
