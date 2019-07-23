using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using static WirelecWCFService.UserService;

namespace WirelecWCFService
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IService1" in both code and config file together.
    [ServiceContract]
    public interface IUserService
    {
        [OperationContract]
        [WebGet(UriTemplate = "GetUsers")]
        List<User> GetAllUsers();

        [OperationContract]
        [WebGet(UriTemplate = "GetUserbyID")]
        User GetUserbyID();

        [OperationContract]
        [WebInvoke(Method = "POST", UriTemplate = "RegisterUser", BodyStyle = WebMessageBodyStyle.WrappedRequest,
            RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json)]
        string RegisterUser(User user);

        [OperationContract]
        [WebInvoke(Method = "POST", UriTemplate = "UpdateUser", BodyStyle = WebMessageBodyStyle.WrappedRequest,
            RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json)]
        string Update(User user);

        [OperationContract]
        [WebInvoke(Method = "POST", UriTemplate = "LoginUser", BodyStyle = WebMessageBodyStyle.WrappedRequest,
            RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json)]
        bool LoginUser(string username, string password);

           [OperationContract]
            [WebGet(UriTemplate = "GetProducts")]
            List<Products> GetProducts();
 
        [OperationContract]
            [WebInvoke(Method = "POST", UriTemplate = "CreateProduct ", BodyStyle = WebMessageBodyStyle.WrappedRequest,
               RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json)]
            string CreateProduct(Products product);

 
        [OperationContract]
        [WebInvoke(Method = "POST", UriTemplate = "DeleteProduct", BodyStyle = WebMessageBodyStyle.WrappedRequest,
           RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json)]
        string DeleteProduct();
       
        }
}
