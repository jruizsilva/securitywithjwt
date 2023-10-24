package securitywithjwt.business.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import securitywithjwt.business.service.JwtService;
import securitywithjwt.business.service.UserService;
import securitywithjwt.domain.dto.user.AuthenticationResponse;
import securitywithjwt.domain.dto.user.request.AuthenticationRequest;
import securitywithjwt.domain.entity.UserEntity;
import securitywithjwt.persistence.UserRepository;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Override
    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                                                        authenticationRequest.getPassword());
        authenticationManager.authenticate(authenticationToken);
        UserEntity userEntity =
                userRepository.findByUsernameIgnoreCase(authenticationRequest.getUsername())
                              .orElseThrow(() -> new RuntimeException("User not found"));
        String jwt = jwtService.generateToken(userEntity,
                                              generateExtraClaims(userEntity));
        return new AuthenticationResponse(jwt);
    }

    private Map<String, Object> generateExtraClaims(UserEntity userEntity) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name",
                        userEntity.getName());
        extraClaims.put("role",
                        userEntity.getRole()
                                  .name());
        extraClaims.put("permissions",
                        userEntity.getAuthorities());
        return extraClaims;
    }
}
