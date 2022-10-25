package com.example.soundlifeapi.repository;

import com.example.soundlifeapi.entity.AlbumEntity;
import com.example.soundlifeapi.entity.AuthorEntity;
import com.example.soundlifeapi.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {
    @Query("select p from AuthorEntity  p where p.name like %:name%")
    AuthorEntity findByName(String name);

    @Query("select p from AuthorEntity  p where p.name like %:name%")
    List<AuthorEntity> findListAuthorByName(@PathVariable("name") String name);

    @Query("select p from AuthorEntity  p where p.name like %:name% and p.deleted = false ")
    List<AuthorEntity> findByNameClient(@PathVariable("name") String name);
    @Query("select p from AlbumEntity  p where p.deleted=false ")
    List<AuthorEntity> listAllAlbumClient();
}
