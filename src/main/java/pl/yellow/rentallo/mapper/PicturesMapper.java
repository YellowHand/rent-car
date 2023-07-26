package pl.yellow.rentallo.mapper;

import pl.yellow.rentallo.domain.Pictures;
import pl.yellow.rentallo.dto.PicturesDto;

public class PicturesMapper implements Mapper<Pictures, PicturesDto> {

    @Override
    public PicturesDto fromEntityToDto(Pictures entity) {
        return PicturesDto.builder()
                .mainPictureUrl(entity.getMainPictureUrl())
                .picturesUrls(entity.getPicturesUrls())
                .build();
    }

    @Override
    public Pictures fromDtoToEntity(PicturesDto dto) {
        return Pictures.builder()
                .mainPictureUrl(dto.mainPictureUrl())
                .picturesUrls(dto.picturesUrls())
                .build();
    }
}
