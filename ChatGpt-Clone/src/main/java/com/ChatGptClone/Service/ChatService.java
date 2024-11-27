package com.ChatGptClone.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ChatGptClone.Model.ChatMessage;
import com.ChatGptClone.Repository.ChatMessageRepository;

@Service
public class ChatService {
	@Autowired
    private ChatMessageRepository chatMessageRepository;

    public ChatMessage saveChatMessage(ChatMessage message) {
        return chatMessageRepository.save(message);
    }
}
