package pl.yellow.rentallo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import lombok.Data;

import java.util.List;

@Data
@Embeddable
public class Pictures {
    String mainPictureUrl;
    List<String> picturesUrls;
}
