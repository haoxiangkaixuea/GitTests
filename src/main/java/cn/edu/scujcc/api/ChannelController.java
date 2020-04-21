package cn.edu.scujcc.api;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.scujcc.model.Channel;
import cn.edu.scujcc.service.ChannelService;
//	频道接口
@RestController
@RequestMapping("/channel")
public class ChannelController {
	public static final Logger logger=
			LoggerFactory.getLogger(ChannelController.class);
	@Autowired
	private ChannelService service; 
//	获取所有你频道
	@GetMapping
	public List<Channel> getAllChannel() {
	logger.info("正在返回打印全部信息：");
	List<Channel>  result=service.getAllChannel();
		logger.debug("所以频道数："+result.size());
		return result;
		
	}
//	获取一个指定频道
	@GetMapping("/{id}")
	public  Channel  getChannel(@PathVariable String id) {
		Channel c=service.getChannel(id);
		logger.info("正在打印"+id+"信息：");
		if(c!=null) {
			return c;
		}else {
			logger.error("找不到指定频道");
			return null;
		}
		
	}
//	删除一个指定频道
	@DeleteMapping("/{id}")
 public ResponseEntity<String> deleteChannel(@PathVariable String id){
		System.out.println("即将删除指定频道,id="+id);
		boolean result=service.deleteChannel(id);
		if(result) {
			return ResponseEntity.ok().body("删除成功");
		}else {
			return ResponseEntity.ok().body("删除失败");
		}
	 
 }
//	新建一个频道
	@PostMapping
	public Channel createChannel1(@RequestBody Channel c) {
		System.out.println("即将创建频道"+c);
		Channel saved=service.createChannel(c);
		return saved;
	}
	@PutMapping
	public Channel updateChannel(@RequestBody Channel c) {
		System.out.println("即将更新频道"+c);
		Channel update=service.updateChannel(c);
		return update;
	}
	@GetMapping("/s/{title}")
	public List<Channel> searchTitle(@PathVariable String title) {
		System.out.println("即将寻找标题"+title);
		List<Channel> t=service.searchTitle(title);
		return t;
	}
	@GetMapping("/q/{quality}")
	public List<Channel> searchQuality(@PathVariable String quality) {
		System.out.println("即将寻找清晰度"+quality);
		List<Channel> q=service.searchQuality(quality);
		return q;
	}
	@GetMapping("/hot")
	public List<Channel> gethotChannel() {
		return service.getLastLocalDateTimeChannel();
	}
}
