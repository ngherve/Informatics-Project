using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

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
        [WebGet(UriTemplate = "GetNotifications")]
        List<Notification> GetNotifications();

        [OperationContract]
        [WebInvoke(Method = "POST", UriTemplate = "GetUserbyID", BodyStyle = WebMessageBodyStyle.WrappedRequest,
            RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json)]
        User GetUserbyID(int id);

        [OperationContract]
        [WebInvoke(Method = "POST", UriTemplate = "GetNotifByUser", BodyStyle = WebMessageBodyStyle.WrappedRequest,
            RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json)]
        List<Notification> GetNotifByUser(int id);

        [OperationContract]
        [WebInvoke(Method = "POST", UriTemplate = "RegisterUser", BodyStyle = WebMessageBodyStyle.WrappedRequest,
            RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json)]
        string RegisterUser(User user);

        [OperationContract]
        [WebInvoke(Method = "POST", UriTemplate = "SaveNotification", BodyStyle = WebMessageBodyStyle.WrappedRequest,
           RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json)]
        string SaveNotif(Notification notif);

        [OperationContract]
        [WebInvoke(Method = "POST", UriTemplate = "LoginUser", BodyStyle = WebMessageBodyStyle.WrappedRequest,
            RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json)]
        bool LoginUser(string username, string password);

        [OperationContract]
        [WebInvoke(Method = "DELETE", UriTemplate = "DeleteUser", BodyStyle = WebMessageBodyStyle.WrappedRequest,
            RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json)]
        string DeleteUser(int id);

        [OperationContract]
        [WebInvoke(Method = "POST", UriTemplate = "SearchUser", BodyStyle = WebMessageBodyStyle.WrappedRequest,
            RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json)]
        User SearchUser(string name);

        [OperationContract]
        [WebInvoke(Method = "PUT", UriTemplate = "UpdateUser", BodyStyle = WebMessageBodyStyle.WrappedRequest,
            RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json)]
        string UpdateUser(User user);
    }
}
