package com.dtu.socialnetwork.mapper;

import com.dtu.socialnetwork.dto.reel.ReelDto;
import com.dtu.socialnetwork.models.Reel;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReelMapper {
    Reel toEntity(ReelDto reelDto);

    ReelDto toDto(Reel reel);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Reel partialUpdate(ReelDto reelDto, @MappingTarget Reel reel);
}