package com.ChatGptClone.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ChatGptClone.Model.User;
import com.ChatGptClone.Repository.UserRepository;
import com.ChatGptClone.Service.OTPService;

@RestController
public class UserController {

	   @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private OTPService otpService;

	    @PostMapping("/register")
	    public ResponseEntity<String> registerUser(@RequestBody User user) {
	        user.setVerified(false);
	        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
	        user.setOtp(otpService.generateOTP());
	        userRepository.save(user);

	        // Send OTP to the email
	        otpService.sendEmail(user.getEmail(), user.getOtp());
	        return ResponseEntity.ok("User registered. Check your email for the OTP.");
	    }

	    @PostMapping("/verify")
	    public ResponseEntity<String> verifyUser(@RequestBody Map<String, String> request) {
	        String email = request.get("email");
	        String otp = request.get("otp");

	        User user = userRepository.findByEmail(email)
	                .orElseThrow(() -> new RuntimeException("User not found"));

	        if (user.getOtp().equals(otp)) {
	            user.setVerified(true);
	            userRepository.save(user);
	            return ResponseEntity.ok("User verified successfully.");
	        } else {
	            return ResponseEntity.badRequest().body("Invalid OTP.");
	        }
	    }
}
