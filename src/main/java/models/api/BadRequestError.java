package models.api;

import lombok.Data;

import java.util.List;
@Data
public class BadRequestError {
    private String type;
    private String title;
    private Message message;

}
