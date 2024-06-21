package com.datefilm.datefilm_server.repository.record;

import com.datefilm.datefilm_server.model.record.Record;
import com.datefilm.datefilm_server.model.reply.Reply;
import com.datefilm.datefilm_server.repository.reply.ReplyRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record,Long>, RecordRepositoryCustom {

}