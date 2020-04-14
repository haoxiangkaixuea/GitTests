package cn.edu.scujcc.dab;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import cn.edu.scujcc.model.Channel;
import cn.edu.scujcc.model.Conment;
@SuppressWarnings("unused")
@Repository
public interface ChannelRepositry extends MongoRepository<Channel,String> {
    //找出评论时间在指定日期之后的评论
	public List<Channel> findByConmentDtAfter(LocalDateTime thedt);
	List <Channel> findByTitle(String s);
	List <Channel> findByQuality(String q);
 

}
