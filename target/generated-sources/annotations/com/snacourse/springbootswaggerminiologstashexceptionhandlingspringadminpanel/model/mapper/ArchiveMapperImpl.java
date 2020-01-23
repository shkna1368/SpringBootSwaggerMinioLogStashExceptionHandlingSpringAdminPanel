package com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.model.mapper;

import com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.model.Archive;
import com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.model.ArchiveDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-17T02:39:38+0330",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
@Component
public class ArchiveMapperImpl implements ArchiveMapper {

    @Override
    public ArchiveDTO toArchiveDto(Archive archive) {
        if ( archive == null ) {
            return null;
        }

        ArchiveDTO archiveDTO = new ArchiveDTO();

        archiveDTO.setCreatedAt( archive.getCreatedAt() );
        archiveDTO.setDescryptions( archive.getDescryptions() );
        archiveDTO.setTitle( archive.getTitle() );
        archiveDTO.setArchiveId( archive.getArchiveId() );
        archiveDTO.setPdfURL( archive.getPdfURL() );
        archiveDTO.setAudioURL( archive.getAudioURL() );
        archiveDTO.setImageURL( archive.getImageURL() );

        return archiveDTO;
    }

    @Override
    public Archive toArchive(ArchiveDTO archiveDTO) {
        if ( archiveDTO == null ) {
            return null;
        }

        Archive archive = new Archive();

        archive.setDescryptions( archiveDTO.getDescryptions() );
        archive.setTitle( archiveDTO.getTitle() );
        archive.setPdfURL( archiveDTO.getPdfURL() );
        archive.setAudioURL( archiveDTO.getAudioURL() );
        archive.setImageURL( archiveDTO.getImageURL() );
        archive.setCreatedAt( archiveDTO.getCreatedAt() );

        return archive;
    }

    @Override
    public List<ArchiveDTO> toArchiveDtos(List<Archive> archives) {
        if ( archives == null ) {
            return null;
        }

        List<ArchiveDTO> list = new ArrayList<ArchiveDTO>( archives.size() );
        for ( Archive archive : archives ) {
            list.add( toArchiveDto( archive ) );
        }

        return list;
    }
}
