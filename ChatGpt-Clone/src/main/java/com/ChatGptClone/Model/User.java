package com.ChatGptClone.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String username;
	    private String password;
	    private String role; // "USER" or "ADMIN"

	    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	    private List<ChatMessage> chatMessages;
	    
	    // Getters and Setters
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public List<ChatMessage> getChatMessages() {
			return chatMessages;
		}

		public void setChatMessages(List<ChatMessage> chatMessages) {
			this.chatMessages = chatMessages;
		}

	  
	    
}
