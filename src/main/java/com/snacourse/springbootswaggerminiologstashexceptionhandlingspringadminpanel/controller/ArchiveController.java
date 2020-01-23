package com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.controller;

import com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.model.Archive;
import com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.model.ArchiveDTO;
import com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.model.mapper.ArchiveMapper;
import com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.service.ArchiveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

@RestController
@Api(value="Archive Management System", description="Operations pertaining to archive in Archive Management System")

@RequestMapping(value = "/api/archive")

public class ArchiveController {




    @Autowired
    ArchiveService archiveService;


    @Autowired
    ArchiveMapper archiveMapper;


    @ApiOperation(value = "Add or insert archive")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Added successfully"),
            @ApiResponse(code = 401, message = "You are not authorized"),
            @ApiResponse(code = 409, message = "It is duplicate"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Server error")
    })


    @PostMapping(value = "")
    public ResponseEntity<Void> addArchive( @Valid ArchiveDTO archiveDTO,
                                             @RequestPart(value = "pdf", required = true) MultipartFile pdfFile,
                                             @RequestPart(value = "image", required = true) MultipartFile imageFile,
                                             @RequestPart(value = "audio", required = false) MultipartFile audioFile
                                            ) {



Archive archive=archiveMapper.toArchive(archiveDTO);
archiveService.addArchive(archive,imageFile,pdfFile,audioFile);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @ApiOperation(value = "View a list of available employees", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping(value = "")
    public ResponseEntity<List<ArchiveDTO>> getList() {

List<Archive>archives=archiveService.getArchives();
        List<ArchiveDTO> archiveDTOS=archiveMapper.toArchiveDtos(archives);
        return ResponseEntity.ok(archiveDTOS);

    }
}
