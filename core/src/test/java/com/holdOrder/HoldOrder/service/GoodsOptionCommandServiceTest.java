package com.holdOrder.HoldOrder.service;

import com.holdOrder.HoldOrder.core.domain.goods.Goods;
import com.holdOrder.HoldOrder.core.domain.goodsOption.GoodsOption;
import com.holdOrder.HoldOrder.core.domain.goodsOption.GoodsOptionRepository;
import com.holdOrder.HoldOrder.core.dto.goodsOption.GoodsOptionDto;
import com.holdOrder.HoldOrder.core.mapper.GoodsOptionMapper;
import com.holdOrder.HoldOrder.core.service.GoodsOptionCommandService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class GoodsOptionCommandServiceTest {
    @InjectMocks
    GoodsOptionCommandService goodsOptionCommandService;
    @Mock
    GoodsOptionRepository goodsOptionRepository;

    GoodsOption dummyGoodsOption1;
    GoodsOption dummyGoodsOption2;
    GoodsOption dummyGoodsOption3;
    GoodsOptionDto goodsOptionDto;

    @BeforeEach
    void initDummyObject() {
        dummyGoodsOption1 = GoodsOption.builder()
                .id(1L)
                .name("DummyGoodsOptionName1")
                .optionPrice(1000)
                .sort(1)
                .build();
        dummyGoodsOption2 = GoodsOption.builder()
                .id(2L)
                .name("DummyGoodsOptionName2")
                .optionPrice(1000)
                .sort(2)
                .build();
        dummyGoodsOption3 = GoodsOption.builder()
                .id(3L)
                .name("DummyGoodsOptionName3")
                .optionPrice(1000)
                .sort(3)
                .build();
        goodsOptionDto = GoodsOptionDto.builder()
                .goods(Goods.builder().build())
                .build();
    }

    @Test
    void GoodsOption을_저장하면_DB의_sort값을_읽어서_1을_더한_후_저장한다() {
        // given
        GoodsOption goodsOption = GoodsOption.builder().build();

        Integer topSortValue = 5;
        when(goodsOptionRepository.findTopByGoodsIdOrderBySortDesc(1L)).thenReturn(topSortValue);
        when(goodsOptionRepository.save(any(GoodsOption.class))).thenReturn(goodsOption);

        goodsOptionCommandService.saveWithSort(goodsOptionDto, 1L);

        // Then
        ArgumentCaptor<GoodsOption> goodsOptionArgumentCaptor = ArgumentCaptor.forClass(GoodsOption.class);
        verify(goodsOptionRepository).save(goodsOptionArgumentCaptor.capture());
        GoodsOption capturedGoodsOption = goodsOptionArgumentCaptor.getValue();

        assertEquals(topSortValue + 1, capturedGoodsOption.getSort());
    }

    @Test
    void GoodsOption_하나를_수정한다() {
        // Given
        List<GoodsOption> goodsOptionList = Arrays.asList(dummyGoodsOption1, dummyGoodsOption2, dummyGoodsOption3);
        goodsOptionDto = GoodsOptionDto.builder()
                .id(1L)
                .name("수정된 이름")
                .optionPrice(1000)
                .sort(4)
                .build();

        GoodsOption goodsOption = GoodsOptionMapper.INSTANCE.goodsOptionDtoToGoodsOption(goodsOptionDto);

        // stub
        when(goodsOptionRepository.findAllByGoodsId(any(Long.class))).thenReturn(goodsOptionList);
        when(goodsOptionRepository.save(any(GoodsOption.class))).thenReturn(goodsOption);

        // When
        GoodsOptionDto modify = goodsOptionCommandService.modify(this.goodsOptionDto);

        // then
        assertNotNull(modify);
        assertEquals(modify.getName(), "수정된 이름");
        assertEquals(modify.getId(), 1L);

    }

    @Test
    void GoodsOption_하나를_수정할_때_같은_상품안에서_같은_정렬값이_존재하다면_애러를_내뱉는다() {
        int DUPLICATESORTVALUE = 1;

        // Given
        List<GoodsOption> goodsOptionList = Arrays.asList(dummyGoodsOption1, dummyGoodsOption2, dummyGoodsOption3);
        goodsOptionDto = GoodsOptionDto.builder()
                .id(1L)
                .name("수정된 이름")
                .optionPrice(1000)
                .sort(DUPLICATESORTVALUE)
                .build();

        // stub
        when(goodsOptionRepository.findAllByGoodsId(any(Long.class))).thenReturn(goodsOptionList);

        // When
        DataIntegrityViolationException throwException = assertThrows(DataIntegrityViolationException.class, () -> goodsOptionCommandService.modify(goodsOptionDto));

        // then
        assertEquals("중복된 정렬이 존재합니다", throwException.getMessage());
    }

    @Test
    void GoodsOption_하나를_수정할_때_중복된_이름이_있다면_오류를_내뱉는다() {
        // Given
        List<GoodsOption> goodsOptionList = Arrays.asList(dummyGoodsOption1, dummyGoodsOption2, dummyGoodsOption3);
        goodsOptionDto = GoodsOptionDto.builder()
                .id(1L)
                .name("DummyGoodsOptionName2")
                .optionPrice(1000)
                .sort(4)
                .build();

        // stub
        when(goodsOptionRepository.findAllByGoodsId(any(Long.class))).thenReturn(goodsOptionList);

        // When
        DataIntegrityViolationException throwException = assertThrows(DataIntegrityViolationException.class, () -> goodsOptionCommandService.modify(goodsOptionDto));

        // then
        assertEquals("중복된 이름이 존재합니다", throwException.getMessage());
    }

    @Test
    void 삭제하는_도중에_일치하는_굿즈옵션을_찾을_수_없다면_에러를_내뱉는다() {
        EntityNotFoundException entityNotFoundException = assertThrows(EntityNotFoundException.class, () -> goodsOptionCommandService.remove(1L));
        assertEquals(entityNotFoundException.getMessage(), "일치하는 굿즈 옵션을 찾을 수 없습니다.");
    }
}