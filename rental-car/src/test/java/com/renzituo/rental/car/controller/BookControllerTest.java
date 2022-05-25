package com.renzituo.rental.car.controller;

import com.renzituo.rental.car.common.exception.RentalCarException;
import com.renzituo.rental.car.common.util.JsonUtil;
import com.renzituo.rental.car.domain.enums.ResultCodeEnum;
import com.renzituo.rental.car.domain.request.BookOrderRequest;
import com.renzituo.rental.car.domain.request.CarDetailRequest;
import com.renzituo.rental.car.domain.request.CarListRequest;
import com.renzituo.rental.car.domain.request.PayRequest;
import com.renzituo.rental.car.domain.response.BaseResponse;
import com.renzituo.rental.car.service.BookService;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService mockBookService;

    @Test
    void testQueryCarList() throws Exception {
        // Setup
        // Configure BookService.queryCarList(...).
        final BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.setCode(0);
        baseResponse.setMsg("desc");
        baseResponse.setData(null);
        when(mockBookService.queryCarList(new CarListRequest())).thenReturn(baseResponse);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/book/carList")
                        .content(JsonUtil.obj2String(new CarListRequest())).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void testQueryCarList_BookServiceReturnsFailure() throws Exception {
        // Setup
        // Configure BookService.queryCarList(...).
        final BaseResponse baseResponse = BaseResponse.genByException(new RentalCarException(ResultCodeEnum.SUCCESS));
        when(mockBookService.queryCarList(new CarListRequest())).thenReturn(baseResponse);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/book/carList")
                        .content(JsonUtil.obj2String(new CarListRequest())).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void testQueryCarDetail() throws Exception {
        // Setup
        // Configure BookService.queryCarDetailById(...).
        final BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.setCode(0);
        baseResponse.setMsg("desc");
        baseResponse.setData(null);
        when(mockBookService.queryCarDetailById(new CarDetailRequest())).thenReturn(baseResponse);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/book/carDetail")
                        .content(JsonUtil.obj2String(new  CarDetailRequest())).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        // assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testQueryCarDetail_BookServiceReturnsFailure() throws Exception {
        // Setup
        // Configure BookService.queryCarDetailById(...).
        final BaseResponse baseResponse = BaseResponse.genByException(new RentalCarException(ResultCodeEnum.SUCCESS));
        when(mockBookService.queryCarDetailById(new CarDetailRequest())).thenReturn(baseResponse);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/book/carDetail")
                        .content(JsonUtil.obj2String(new CarDetailRequest())).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        //assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testBookOrder() throws Exception {
        // Setup
        // Configure BookService.bookOrder(...).
        final BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.setCode(0);
        baseResponse.setMsg("desc");
        baseResponse.setData(null);
        when(mockBookService.bookOrder(new BookOrderRequest())).thenReturn(baseResponse);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/book/book")
                        .content(JsonUtil.obj2String(new BookOrderRequest())).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        // assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testBookOrder_BookServiceReturnsFailure() throws Exception {
        // Setup
        // Configure BookService.bookOrder(...).
        final BaseResponse baseResponse = BaseResponse.genByException(new RentalCarException(ResultCodeEnum.SUCCESS));
        when(mockBookService.bookOrder(new BookOrderRequest())).thenReturn(baseResponse);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/book/book")
                        .content(JsonUtil.obj2String(new BookOrderRequest())).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
       // assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testPay() throws Exception {
        // Setup
        // Configure BookService.payOrder(...).
        final BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.setCode(0);
        baseResponse.setMsg("desc");
        baseResponse.setData(null);
        when(mockBookService.payOrder(new PayRequest())).thenReturn(baseResponse);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/book/pay")
                        .content(JsonUtil.obj2String(new PayRequest())).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        // assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testPay_BookServiceReturnsFailure() throws Exception {
        // Setup
        // Configure BookService.payOrder(...).
        final BaseResponse baseResponse = BaseResponse.genByException(new RentalCarException(ResultCodeEnum.SUCCESS));
        when(mockBookService.payOrder(new PayRequest())).thenReturn(baseResponse);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/book/pay")
                        .content(JsonUtil.obj2String(new PayRequest())).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        //assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }
}
