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
//	Ƶ���ӿ�
@RestController
@RequestMapping("/channel")
public class ChannelController {
	public static final Logger logger=
			LoggerFactory.getLogger(ChannelController.class);
	@Autowired
	private ChannelService service; 
//	��ȡ������Ƶ��
	@GetMapping
	public List<Channel> getAllChannel() {
	logger.info("���ڷ��ش�ӡ��Ϣ��");
	List<Channel>  result=service.getAllChannel();
		logger.debug("����Ƶ������"+result.size());
		return result;
		
	}
//	��ȡһ��ָ��Ƶ��
	@GetMapping("/{id}")
	public  Channel  getChannel(@PathVariable String id) {
		Channel c=service.getChannel(id);
		if(c!=null) {
			return c;
		}else {
			logger.error("�Ҳ���ָ��Ƶ��");
			return null;
		}
		
	}
//	ɾ��һ��ָ��Ƶ��
	@DeleteMapping("/{id}")
 public ResponseEntity<String> deleteChannel(@PathVariable String id){
		System.out.println("����ɾ��ָ��Ƶ��,id="+id);
		boolean result=service.deleteChannel(id);
		if(result) {
			return ResponseEntity.ok().body("ɾ���ɹ�");
		}else {
			return ResponseEntity.ok().body("ɾ��ʧ��");
		}
	 
 }
//	�½�һ��Ƶ��
	@PostMapping
	public Channel createChannel1(@RequestBody Channel c) {
		System.out.println("��������Ƶ��"+c);
		Channel saved=service.createChannel(c);
		return saved;
	}
	@PutMapping
	public Channel updateChannel(@RequestBody Channel c) {
		System.out.println("��������Ƶ��"+c);
		Channel update=service.updateChannel(c);
		return update;
	}
	@GetMapping("/s/{title}")
	public List<Channel> searchTitle(@PathVariable String title) {
		System.out.println("����Ѱ�ұ���"+title);
		List<Channel> t=service.searchTitle(title);
		return t;
	}
	@GetMapping("/q/{quality}")
	public List<Channel> searchQuality(@PathVariable String quality) {
		System.out.println("����Ѱ��������"+quality);
		List<Channel> q=service.searchQuality(quality);
		return q;
	}
	@GetMapping("/hot")
	public List<Channel> gethotChannel() {
		return service.getLastLocalDateTimeChannel();
	}
}
