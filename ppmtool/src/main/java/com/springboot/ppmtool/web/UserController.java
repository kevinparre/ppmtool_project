package com.springboot.ppmtool.web;

import static com.springboot.ppmtool.security.SecurityConstants.TOKEN_PREFIX;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.ppmtool.domain.User;
import com.springboot.ppmtool.payload.JWTLoginSucessReponse;
import com.springboot.ppmtool.payload.LoginRequest;
import com.springboot.ppmtool.repositories.UserRepository;
import com.springboot.ppmtool.security.JwtTokenProvider;
import com.springboot.ppmtool.services.MapValidationErrorService;
import com.springboot.ppmtool.services.UserService;
import com.springboot.ppmtool.validator.UserValidator;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
     private UserRepository userRepository;
    
    @Autowired
     private PasswordEncoder passwordEncoder;




    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = TOKEN_PREFIX +  tokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JWTLoginSucessReponse(true, jwt));
    }
    
    
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user, BindingResult result){
        // Validate passwords match
        userValidator.validate(user,result);

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null)return errorMap;

        User newUser = userService.saveUser(user);

        return  new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }

//    @PostMapping("/register")
//    public ResponseEntity<?> registerUser(@RequestBody User user){
//        // Validate passwords match
//    	System.out.println("miracle hit");
////        userValidator.validate(user,result);
//
////        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
////        if(errorMap != null)return errorMap;
//
//        User newUser = userService.saveUser(user);
//
//        return  new ResponseEntity<User>(newUser, HttpStatus.CREATED);
//    }
//    @GetMapping("/testing")
//    public String testing() {
//    	return "testing working";
//    }
}
