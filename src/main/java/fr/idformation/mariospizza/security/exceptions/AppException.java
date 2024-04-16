package fr.idformation.mariospizza.security.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 *class app ex.
 */
@Getter
public class AppException extends RuntimeException {
    /**
     * status.
     */
    private final HttpStatus status;

    /**
     * @param message mes error.
     * @param pStatus status
     */
    public AppException(final String message, final HttpStatus pStatus) {
        super(message);
        this.status = pStatus;
    }
}
//
//    /**
//     *
//     * @return status.
//     */
//    public HttpStatus getStatus() {
//        return status;
//    }
//}
