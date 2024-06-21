package com.datefilm.datefilm_server.repository.album;

import com.datefilm.datefilm_server.model.album.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Long>, AlbumRepositoryCustom {

}