package umc.study.apiPayLoad.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.study.apiPayLoad.code.BaseErrorCode;
import umc.study.apiPayLoad.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException{
    private BaseErrorCode baseErrorCode;

    public ErrorReasonDTO getErrorReason(){
        return this.baseErrorCode.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.baseErrorCode.getReasonHttpStatus();
    }

}
