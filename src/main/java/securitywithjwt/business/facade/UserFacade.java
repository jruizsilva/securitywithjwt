package securitywithjwt.business.facade;

import securitywithjwt.domain.dto.user.AuthenticationResponse;
import securitywithjwt.domain.dto.user.request.AuthenticationRequest;

public interface UserFacade {
    AuthenticationResponse login(AuthenticationRequest authenticationRequest);
}
