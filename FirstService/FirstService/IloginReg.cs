using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace FirstService
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IloginReg" in both code and config file together.
    [ServiceContract]
    public interface IloginReg
    {
        [OperationContract]
        Boolean Login(string usrername, string password);

        [OperationContract]
        String Register(string title, string FN, string surname, string email, string username, string password);

        [OperationContract]
        List<User> getAllUsers();

        [OperationContract]
        List<User> getFemaleUsers();
    }
}
