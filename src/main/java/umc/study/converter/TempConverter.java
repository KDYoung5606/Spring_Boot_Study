package umc.study.converter;

import lombok.Builder;
import lombok.Getter;
import umc.study.web.dto.TempResponse;

@Builder
@Getter
public class TempConverter {
    public static TempResponse.TempTestDTO toTempTestDTO(){
        return TempResponse.TempTestDTO
                .builder().testString("This is Test!").build();
    }

    public static  TempResponse.TempExceptionDTO toTempExceptionDTO(Integer flag){
        return TempResponse.TempExceptionDTO.builder()
                .flag(flag)
                .build();
    }


}
