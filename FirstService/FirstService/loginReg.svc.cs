
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace FirstService
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "loginReg" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select loginReg.svc or loginReg.svc.cs at the Solution Explorer and start debugging.
    public class loginReg : IloginReg
    {
        TestDataContext db = new TestDataContext();

        public List<User> getAllUsers()
        {
            var allItems = new List<User>();
            var items = (from i in db.Users
                         select i);

            foreach (User u in items)
            {
                allItems.Add(u);
            }

            return allItems;
        }

        public List<User> getFemaleUsers()
        {
            var allItems = new List<User>();
            var items = (from i in db.Users
                         where i.Email.Equals("Female")
                         select i);

            foreach (User u in items)
            {
                allItems.Add(u);
            }

            return allItems;

        }

        public bool Login(string usrername, string password)
        {
            var user = (from u in db.Users
                        where u.Username.Equals(usrername) && u.Password.Equals(password)
                        select u).FirstOrDefault();

            if (user != null)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public string Register(string title, string FN, string surname, string email, string username, string password)
        {
            var user = (from u in db.Users
                        where u.Username.Equals(username) && u.Password.Equals(password)
                        select u).FirstOrDefault();

            if (user == null)
            {
                var RegUser = new User
                {
                    Title = title,
                    FirstName = FN,
                    Surname = surname,
                    Email = email,
                    Username = username,
                    Password = password
                };

                db.Users.InsertOnSubmit(RegUser);
                try
                {
                    db.SubmitChanges();
                    return "Successful";
                }
                catch (Exception ex)
                {
                    ex.GetBaseException();
                    return ex.ToString();
                }
            }
            else
            {
                return "User already exists";
            }
        }
    }
}
