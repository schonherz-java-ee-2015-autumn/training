package hu.neuron.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.neuron.java.service.MessageConverter;
import hu.neuron.java.service.MessageService;
import hu.neuron.java.service.vo.MessageVO;
import hu.schonherz.java.dao.MessageDao;

@Service("messageService")
@Transactional(propagation = Propagation.REQUIRED)
public class MessagesServiceImpl implements MessageService {
	@Autowired
	MessageDao messageDao;

	@Override
	public void send(MessageVO messageVO) {
		messageDao.save(MessageConverter.toEntity(messageVO));

	}

	@Override
	public List<MessageVO> getMessages(Long from, Long to) {
		return MessageConverter.toVo(messageDao.findMessages(from, to));
	}

}
