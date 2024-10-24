package swagger.endpoint;

public class BaseAPI {
    protected static final String Token = "bearerToken";
    public static  String BaseURL = "https://practice-react.sdetunicorns.com/api/test";
    public static final  String BrandsEndPoint = "/brands";
    public static String BrandIdEndPoint = "brand/";
    public static String Retrieve_Brands_URL = BaseURL+ BrandsEndPoint;
    public static String Retrieve_Brand_BY_ID_URL = BaseURL+BrandIdEndPoint;

}
