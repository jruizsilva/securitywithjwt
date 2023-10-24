package securitywithjwt.business.facade.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import securitywithjwt.business.facade.UserFacade;
import securitywithjwt.business.service.UserService;
import securitywithjwt.domain.dto.user.AuthenticationResponse;
import securitywithjwt.domain.dto.user.request.AuthenticationRequest;

@Component
@RequiredArgsConstructor
public class UserFacadeImpl implements UserFacade {
    private final UserService userService;

    @Override
    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
        return userService.login(authenticationRequest);
    }
}
