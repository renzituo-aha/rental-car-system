package com.renzituo.rental.car.controller;

import com.renzituo.rental.car.common.exception.RentalCarException;
import com.renzituo.rental.car.common.util.JsonUtil;
import com.renzituo.rental.car.domain.enums.ResultCodeEnum;
import com.renzituo.rental.car.domain.request.BaseRequest;
import com.renzituo.rental.car.domain.request.OrderRequest;
import com.renzituo.rental.car.domain.request.ReturnCarRequest;
import com.renzituo.rental.car.domain.response.BaseResponse;
import com.renzituo.rental.car.service.PersonService;
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
@WebMvcTest(PersonalController.class)
class PersonalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService mockPersonService;

    @Test
    void testQueryOrderList() throws Exception {
        // Setup
        // Configure PersonService.orderList(...).
        final BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.setCode(0);
        baseResponse.setMsg("desc");
        baseResponse.setData(null);
        when(mockPersonService.orderList(new BaseRequest())).thenReturn(baseResponse);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/personal/orderList")
                        .content(JsonUtil.obj2String(new BaseRequest())).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        //assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testQueryOrderList_PersonServiceReturnsFailure() throws Exception {
        // Setup
        // Configure PersonService.orderList(...).
        final BaseResponse baseResponse = BaseResponse.genByException(new RentalCarException(ResultCodeEnum.SUCCESS));
        when(mockPersonService.orderList(new BaseRequest())).thenReturn(baseResponse);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/personal/orderList")
                        .content(JsonUtil.obj2String(new BaseRequest())).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
       // assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testQueryOrderDetail() throws Exception {
        // Setup
        // Configure PersonService.orderDetail(...).
        final BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.setCode(0);
        baseResponse.setMsg("desc");
        baseResponse.setData(null);
        when(mockPersonService.orderDetail(new OrderRequest())).thenReturn(baseResponse);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/personal/orderDetail")
                        .content(JsonUtil.obj2String(new BaseRequest())).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
       // assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testQueryOrderDetail_PersonServiceReturnsFailure() throws Exception {
        // Setup
        // Configure PersonService.orderDetail(...).
        final BaseResponse baseResponse = BaseResponse.genByException(new RentalCarException(ResultCodeEnum.SUCCESS));
        when(mockPersonService.orderDetail(new OrderRequest())).thenReturn(baseResponse);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/personal/orderDetail")
                        .content(JsonUtil.obj2String(new BaseRequest())).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        // assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testReturnCar() throws Exception {
        // Setup
        // Configure PersonService.returnCar(...).
        final BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.setCode(0);
        baseResponse.setMsg("desc");
        baseResponse.setData(null);
        when(mockPersonService.returnCar(new ReturnCarRequest())).thenReturn(baseResponse);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/personal/returnCar")
                        .content(JsonUtil.obj2String(new BaseRequest())).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        // assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testReturnCar_PersonServiceReturnsFailure() throws Exception {
        // Setup
        // Configure PersonService.returnCar(...).
        final BaseResponse baseResponse = BaseResponse.genByException(new RentalCarException(ResultCodeEnum.SUCCESS));
        when(mockPersonService.returnCar(new ReturnCarRequest())).thenReturn(baseResponse);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/personal/returnCar")
                        .content(JsonUtil.obj2String(new BaseRequest())).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        // assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }
}
