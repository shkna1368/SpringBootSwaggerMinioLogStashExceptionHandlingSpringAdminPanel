package com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.model.mapper;


import com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.model.Archive;
import com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.model.ArchiveDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring"
)
public interface ArchiveMapper {


    @Mapping(source = "archiveId", target = "archiveId")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "descryptions", target = "descryptions")
    @Mapping(source = "createdAt", target = "createdAt")
    ArchiveDTO toArchiveDto(Archive archive);




    @Mapping(source = "archiveId", target = "archiveId",ignore = true)
    @Mapping(source = "title", target = "title")
    @Mapping(source = "descryptions", target = "descryptions")
    Archive toArchive(ArchiveDTO archiveDTO);

    List<ArchiveDTO> toArchiveDtos(List<Archive> archives);





}
