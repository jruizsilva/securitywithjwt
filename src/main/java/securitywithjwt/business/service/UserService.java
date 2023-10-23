package securitywithjwt.business.service;

import securitywithjwt.domain.dto.user.AuthenticationResponse;
import securitywithjwt.domain.dto.user.request.AuthenticationRequest;

public interface UserService {
    AuthenticationResponse login(AuthenticationRequest authenticationRequest);
}
