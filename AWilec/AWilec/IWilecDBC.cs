using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace AWilec
{
   
    [ServiceContract]
    public interface IWilecDBC
    {
        [OperationContract]
        bool Login(string un,string psw);

        [OperationContract]
        void Register( string FN, string surname, string uname, string password,  string Gender);

        [OperationContract]
        string AddProduct(string name, int price, string image, int quantity, string status);

        [OperationContract]
        string DeleteProduct(string Name);

        [OperationContract]
        string getProduct(string Name);

        [OperationContract]
        string UpdateProductPrice(string name,int Price);

    }
}
