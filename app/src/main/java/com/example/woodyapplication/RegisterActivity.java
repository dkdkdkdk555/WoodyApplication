package com.example.woodyapplication;

public class RegisterActivity {

    // API 서버의 기본 URL
//    private static final String BASE_URL = "http://localhost/api/v1/account";
//
//    // Retrofit 인스턴스 생성
//    private Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build();
//
//    // ApiService 인터페이스의 구현체 생성
//    private ApiService apiService = retrofit.create(ApiService.class);
//
//    // 실제로 회원가입을 수행하는 메서드
//    private void performRegistration(User user) {
//        Call<ApiResponse<User>> call = apiService.registerUser(user);
//        call.enqueue(new Callback<ApiResponse<User>>() {
//            @Override
//            public void onResponse(Call<ApiResponse<User>> call, Response<ApiResponse<User>> response) {
//                if (response.isSuccessful()) {
//                    ApiResponse<User> apiResponse = response.body();
//                    // 처리 로직을 추가하세요 (성공 시 또는 실패 시)
//                } else {
//                    // 오류 처리 로직을 추가하세요
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ApiResponse<User>> call, Throwable t) {
//                // 실패 시 처리 로직을 추가하세요
//            }
//        });
//    }
}



//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//public class RegistrationManager {
//
//    private static final String BASE_URL = "http://localhost/api/v1/account";
//
//    private ApiService apiService;
//
//    public RegistrationManager() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        apiService = retrofit.create(ApiService.class);
//    }
//
//    public void registerUser(String username, String email, String password) {
//        Call<ApiResponse> call = apiService.registerUser(username, email, password);
//        call.enqueue(new Callback<ApiResponse>() {
//            @Override
//            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
//                if (response.isSuccessful()) {
//                    // 회원가입 성공 처리
//                    ApiResponse apiResponse = response.body();
//                    // 여기에서 서버 응답에 따른 추가 처리를 수행할 수 있습니다.
//                } else {
//                    // 회원가입 실패 처리
//                    // 여기에서 서버 응답에 따른 추가 처리를 수행할 수 있습니다.
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ApiResponse> call, Throwable t) {
//                // 네트워크 오류 등에 대한 처리
//                t.printStackTrace();
//            }
//        });
//    }
//}