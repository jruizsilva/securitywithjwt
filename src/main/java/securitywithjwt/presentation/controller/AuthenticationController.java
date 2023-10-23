package securitywithjwt.presentation.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import securitywithjwt.business.facade.UserFacade;
import securitywithjwt.domain.dto.user.AuthenticationResponse;
import securitywithjwt.domain.dto.user.request.AuthenticationRequest;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserFacade userFacade;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid final AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(userFacade.login(authenticationRequest));
    }

    @GetMapping("/public-access")
    public ResponseEntity<String> publicAccess() {
        return ResponseEntity.ok("Public access");
    }
}
