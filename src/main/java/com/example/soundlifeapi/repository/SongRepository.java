package com.example.soundlifeapi.repository;

import com.example.soundlifeapi.entity.SingerEntity;
import com.example.soundlifeapi.entity.SongEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SongRepository extends JpaRepository<SongEntity, Integer> {
    @Query("select p from SongEntity  p where p.deleted = false ")
    List<SongEntity> listAllSongClient();

    @Query("select p from SongEntity  p where p.name like %:name% and p.deleted = false ")
    List<SongEntity> findByNameClient(@PathVariable("name") String name);


    @Query("select p from SongEntity  p where p.name like %:name%")
    SongEntity findSongByName(String name);

    @Query("select p from SongEntity  p where p.name like %:name%")
    List<SongEntity> findListSongByName(@PathVariable("name")String name);

    @Query("select p from SongEntity  p where p.album_id=:album_id")
    List<SongEntity> getAllByAlbumId(@PathVariable("album_id") int album_id);

    @Query("select p from SongEntity  p where p.singer_id =:singer_id")
    List<SongEntity> getAllBySingerId(@PathVariable("singer_id") int singer_id);

    @Query("select p from SongEntity  p where p.top_id =:top_id")
    List<SongEntity> getAllByTopId(@PathVariable("top_id") int top_id);

    @Query("select p from SongEntity  p where p.author_id=:author_id")
    List<SongEntity> getAllByAuthorId(@PathVariable("author_id") int author_id);

    @Query("select p from SongEntity  p where p.genre_id=:genre_id")
    List<SongEntity> getAllByGenreId(@PathVariable("genre_id") int genre_id);

}
