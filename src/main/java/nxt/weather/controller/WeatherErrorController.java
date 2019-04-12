package nxt.weather.controller;

import javax.servlet.http.HttpServletRequest;
import nxt.weather.controller.dto.ReturnDto;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WeatherErrorController implements ErrorController {

    @RequestMapping("/error")
    @ResponseBody
    public ReturnDto<Object> handleError(HttpServletRequest request) {
        String errorMsg = "";
        int httpErrorCode = getErrorCode(request);
        switch (httpErrorCode) {
            case 400: {
                errorMsg = "00. Bad Request";
                break;
            }
            case 401: {
                errorMsg = "401. Unauthorized";
                break;
            }
            case 403: {
                errorMsg = "403. Forbidden";
                break;
            }
            case 404: {
                errorMsg = "404. Resource not found";
                break;
            }
            default: {
                errorMsg = "500. Internal Server Error";
                break;
            }
        }
        return new ReturnDto<>(httpErrorCode, errorMsg);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest
                .getAttribute("javax.servlet.error.status_code");
    }

}
