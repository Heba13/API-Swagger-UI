package swagger.endpoint;

public class BaseAPI {
    protected static final String Token = "bearerToken";
    public static  String BaseURL = "https://practice-react.sdetunicorns.com/api/test";
    public static final  String BrandsEndPoint = "/brands";
    public static String BrandIdEndPoint = "/{id}";
    public static String Get_Brands_URL = BaseURL+ BrandsEndPoint;
    public static String Retrieve_Brands_URL = BaseURL+ BrandsEndPoint;
    public static String Retrieve_Brand_URL = BaseURL+ BrandsEndPoint+BrandIdEndPoint;

}
