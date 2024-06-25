package com.datefilm.datefilm_server.repository.reply;

import com.datefilm.datefilm_server.model.reply.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long>, ReplyRepositoryCustom {
}
