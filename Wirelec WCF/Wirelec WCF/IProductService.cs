using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace Wirelec_WCF
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IProductService" in both code and config file together.
    [ServiceContract]
    public interface IProductService
    {



        [OperationContract]
        [WebGet(UriTemplate = "GetProducts")]
        List<Product> GetAllProducts();

        [OperationContract]
        [WebGet(UriTemplate = "GetProductbyID")]
        Product GetProductbyID(int id);

        [OperationContract]
        [WebInvoke(Method = "DELETE", UriTemplate = "DeleteProduct", BodyStyle = WebMessageBodyStyle.WrappedRequest,
            RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json)]
        string DeleteProduct(int id);

        [OperationContract]
        [WebGet(UriTemplate = "SearchProduct")]
        Product SearchProduct(string name);

        [OperationContract]
        [WebInvoke(Method = "POST", UriTemplate = "AddProduct", BodyStyle = WebMessageBodyStyle.WrappedRequest,
            RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json)]
        string AddProduct(Product product);
        
        [OperationContract]
        [WebInvoke(Method = "PUT", UriTemplate = "UpdateProduct", BodyStyle = WebMessageBodyStyle.WrappedRequest,
            RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json)]
        string UpdateProduct(int id, string name, int price, string image, int quant, string sname, string type, int wid);
    }

    
}
