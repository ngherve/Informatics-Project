using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace Wirelec_WCF
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IIUserService" in both code and config file together.
    [ServiceContract]
    public interface IIUserService
    {
        [OperationContract]
        [WebGet(UriTemplate = "GetUsers")]
        List<User> GetAllUsers();

        [OperationContract]
        [WebGet(UriTemplate = "GetUserbyID")]
        User GetUserbyID(int id);

        [OperationContract]
        [WebInvoke(Method = "POST", UriTemplate = "RegisterUser", BodyStyle = WebMessageBodyStyle.WrappedRequest,
            RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json)]
        string RegisterUser(User user);

        [OperationContract]
        [WebInvoke(Method = "POST", UriTemplate = "LoginUser", BodyStyle = WebMessageBodyStyle.WrappedRequest,
            RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json)]
        bool LoginUser(string username, string password);

        [OperationContract]
        [WebInvoke(Method = "DELETE", UriTemplate = "DeleteUser", BodyStyle = WebMessageBodyStyle.WrappedRequest,
            RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json)]
        string DeleteUser(int id);

        [OperationContract]
        [WebGet(UriTemplate = "SearchUser")]
        User SearchUser(string name);

        [OperationContract]
        [WebInvoke(Method = "PUT", UriTemplate = "UpdateUser", BodyStyle = WebMessageBodyStyle.WrappedRequest,
            RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json)]
        string UpdateUser(int id, string name, string username, string email, string pass, string tel, string addr, string gender, string dob, string type);
    }
}
