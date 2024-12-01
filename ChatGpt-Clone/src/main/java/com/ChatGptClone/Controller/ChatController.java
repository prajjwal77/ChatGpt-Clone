package com.ChatGptClone.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ChatGptClone.Model.ChatHistory;
import com.ChatGptClone.Model.User;
import com.ChatGptClone.Repository.ChatHistoryRepository;
import com.ChatGptClone.Service.AIService;
@RestController
public class ChatController {


    @Autowired
    private AIService aiService;

    @Autowired
    private ChatHistoryRepository chatHistoryRepository;

    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestParam Long userId, @RequestBody String message) {
        ChatHistory chatHistory = new ChatHistory();
        chatHistory.setUser(new User()); // Assuming User exists in DB
        chatHistory.setMessage(message);
        chatHistory.setResponse(aiService.getAIResponse(message));
        chatHistory.setTimestamp(LocalDateTime.now());

        chatHistoryRepository.save(chatHistory);
        return ResponseEntity.ok(chatHistory);
    }

    @GetMapping("/history/{userId}")
    public ResponseEntity<List<ChatHistory>> getChatHistory(@PathVariable Long userId) {
        return ResponseEntity.ok(chatHistoryRepository.findByUserId(userId));
    }
}
