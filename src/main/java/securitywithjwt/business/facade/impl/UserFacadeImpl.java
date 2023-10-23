package securitywithjwt.business.facade.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import securitywithjwt.business.facade.UserFacade;
import securitywithjwt.domain.dto.user.AuthenticationResponse;
import securitywithjwt.domain.dto.user.request.AuthenticationRequest;

@Component
@RequiredArgsConstructor
public class UserFacadeImpl implements UserFacade {
    @Override
    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
        return null;
    }
}
