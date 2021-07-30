package com.api.server.repository;

import com.api.server.entity.Music;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<Music, Integer> {

    public boolean existsByEmail(String email);

    public Music findByEmail(String email);

    @Query("select count(m) from Music m where m.type = :type")
    public Integer countType(String type);
}
