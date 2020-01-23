package com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.repository;



import com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.model.Archive;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArchiveRepository extends PagingAndSortingRepository<Archive, Long> {

    Optional<Archive> findByArchiveId(Long id);


    Optional<Archive> findByTitleAndArchiveIdNot(String title, Long id);

    Optional<Archive> findByTitle(String title);






}
