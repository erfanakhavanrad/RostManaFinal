package com.example.rostmanafinal.Interfaces;

import com.example.rostmanafinal.Pojo.GetHello;
import com.example.rostmanafinal.Pojo.ModelChartsTables.ChartsModel;
import com.example.rostmanafinal.Pojo.ModelChoosePlant.SeasonalModel;
import com.example.rostmanafinal.Pojo.ModelChoosePlant.SingleFlowerModel;
import com.example.rostmanafinal.Pojo.ModelEditProfile;
import com.example.rostmanafinal.Pojo.ModelFirstPage.AllUserInfoModel;
import com.example.rostmanafinal.Pojo.ModelRegister;
import com.example.rostmanafinal.Pojo.ModelSMS.VerifyModel;
import com.example.rostmanafinal.Pojo.PojoEnterPost.Example;
import com.example.rostmanafinal.Pojo.TicketModel;
import com.example.rostmanafinal.Pojo.Users;
import com.google.gson.JsonArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface RetrofitApiService {
    // GET test
    @GET("hello")
    Call<GetHello> getHellovalue();

    // POST test
    @POST("goodbye")
    Call<GetHello> postGoodbyeValue();


    // This is for the login page
    @FormUrlEncoded
    @POST("login")
    Call<Users> getUserPostToken(@Field("phonenumber") String phoneNumber,
                                 @Field("password") String password);

    // This is for the EditProfile page
    @FormUrlEncoded
    @POST("Updatauser")
    Call<ModelEditProfile> PostEditProfileAPIService(@Header("Dynamic-Header") String header,
                                                     @Field("sex") Boolean sex,
                                                     @Field("profileImage") String profileImage,
                                                     @Field("name") String name,
                                                     @Field("lastName") String lastName,
                                                     @Field("phonenumber") String phonenumber,
                                                     @Field("address") String address,
                                                     @Field("birth") String birth
    );

    //This is for register page
    @FormUrlEncoded
    @POST("register")
    Call<ModelRegister> postRegisterPage(@Field("phonenumber") String phonenumber,
                                         @Field("password") String password,
                                         @Field("c_password") String c_password
    );


    // This is for logged in User to receive data
//    @FormUrlEncoded
//    @POST("Mobile/User")
//    Call<Example> postLoggedInUser();

    //    @POST("Mobile/User")
//    Call<AllUserInfoModel> postLoggedInUser();
    @POST("Mobile/User")
    Call<AllUserInfoModel> postLoggedInUser();

//    Get Flowers list pic and name
//    @GET("Category/{number}")
//    Call<SeasonalModel> getPlantList(
//            @Path("number") String number
//    );

    //    This is for the plants list
    @GET()
    Call<List<SeasonalModel>> getPlantList(
            @Url String number
    );

    //    This is for the Temperature Chart POST

    //    @FormUrlEncoded
//    @POST()
//    Call<ChartsModel> postForCharts(@Url String builderId),
//    @POST()
//    Call<ChartsModel> postforCharts(@Body List<Day> dayList);

    //    @Multipart
//    @POST()
//    Call<ChartsModel> postForCharts(@Url String builderId,
//                                    @Body String date1,
//                                    @Body String date2
//    );
    @FormUrlEncoded
    @POST()
    Call<List<ChartsModel>> postForCharts(@Url String builderId,
                                          @Field("date1") String date1,
                                          @Field("date2") String date2
    );
//    @Field("date1")
//    String day1,
//    @Field("date2")
//    String day 2

//    @FormUrlEncoded
//    @POST()
//    Call<ChartsModel> postForCharts(@Url String builderId,
//                                    @Field("date1") String date1,
//                                    @Field("date2") String date2
//    );


    //    This is for plant's details using id
    @FormUrlEncoded
    @POST("rostmana.com/api/Mobile/Plant/")
    Call<SingleFlowerModel> postIdForDetails(@Url String id);


    //    This is for the register SMS Activity
    @FormUrlEncoded
    @POST("Mobile/vitrifiedChk")
    Call<VerifyModel> post6DigitsCode(@Field("vcode") Integer vCode
    );

    //    @Header("access_token") String token
    //    @FormUrlEncoded
//    @POST("Mobile/User")
//    Call<List<ModelLogedinUser>> postLoggedInUser(@Header("access_token") String token);
//    @FormUrlEncoded
//    @POST(URL) Call<ResponseBody> getdata(@Field("jdata") String jdata);

    //    This is for tickets page
    @FormUrlEncoded
    @POST("Mobile/Ticket")
    Call<TicketModel> postTicket(@Field("type_tiket") String type_tiket
            , @Field("subject") String subject,
                                 @Field("description") String description
    );

    // This is for add Plant
    @FormUrlEncoded
    @POST("Mobile/addPlant")
    Call<TicketModel> postPlantId(@Field("plant_id") String plant_id);


}
