package cn.edu.scujcc.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.scujcc.dab.ChannelRepositry; 
import cn.edu.scujcc.model.Channel;
//提供业务逻辑层
@SuppressWarnings("unused") 
@Service
public class ChannelService {
	@Autowired
	private ChannelRepositry repo;

public List<Channel> getAllChannel() {
	 return repo.findAll();
}

public Channel getChannel(String channelId) {
	Optional<Channel> result=repo.findById(channelId) ;
		   if (result.isPresent()) {
			   return result.get();
		   }else {
			   return null;
}
	   }
	   

public boolean deleteChannel(String channelId) {
	 boolean result=true;
	repo.deleteById(channelId);
	 return result;
}

public Channel createChannel(Channel c) {
      return repo.save(c);
}

public Channel updateChannel(Channel c) {
	Channel saved=getChannel(c.getId());
	if(saved != null) {
		if(c.getTitle() != null) {
			saved.setTitle(c.getTitle());
		}
		if(c.getQuality() != null) {
			saved.setQuality(c.getQuality());
		}
		if(c.getUrl() != null) {
			saved.setUrl(c.getUrl());
		}
		if(c.getConment()!=null) {
			saved.getConment().addAll(c.getConment());
		}else {
			saved.setConment(c.getConment());
		}
	}
	 return repo.save(saved);
}

public List<Channel> searchTitle(String title) {
	return repo.findByTitle(title);
}
public List<Channel> searchQuality(String quality) {
	return repo.findByQuality(quality);
}
public List<Channel> getLastLocalDateTimeChannel() {
	LocalDateTime now=LocalDateTime.now();
	LocalDateTime today=LocalDateTime.of(now.getYear(),now.getMonthValue(),now.getDayOfMonth(),0,0);
	return repo.findByConmentDtAfter(today);
}

}
