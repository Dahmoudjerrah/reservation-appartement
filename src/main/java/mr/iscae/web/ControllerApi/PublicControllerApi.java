package mr.iscae.web.ControllerApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import mr.iscae.Dto.AuthRequest;
import mr.iscae.Dto.RegisterModel;
import mr.iscae.utils.Constants;
@RequestMapping(Constants.AUTH)
public interface PublicControllerApi {
    @PostMapping(Constants.REGISTER)
    public ResponseEntity<?> register(@RequestBody RegisterModel registerModel);

    @PostMapping(Constants.LOGIN)
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest);
}
