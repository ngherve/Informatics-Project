using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace AWilec
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "WilecDBC" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select WilecDBC.svc or WilecDBC.svc.cs at the Solution Explorer and start debugging.
    public class WilecDBC : IWilecDBC
    {
     
        DBDataContext db = new DBDataContext();

        public string AddProduct(string name, int price, string image, int quantity, string status)
        {
            name.ToUpper().Trim();
            wProduct p = new wProduct(name, price, image, quantity, status);
            product pro = new product
            {
                productname = p.getName(),
                price = p.getPrice(),
                Proimage = p.getImage(),
                quantity = p.getPrice(),
                status = p.getStatus(),
            };
            db.products.InsertOnSubmit(pro);
            db.SubmitChanges();
            return "succefully Added Product";

        }

       

        public string DeleteProduct(string Name)
        {
            
               var product = (from p in db.products
                           where p.productname.Equals(Name)
                           select p).FirstOrDefault();
            db.products.DeleteOnSubmit(product);
            db.SubmitChanges();
            return ("Succefully Deleted" + Name);
        }

        public string getProduct(string Name)
        {
            wProduct tmp;
            var product = (from p in db.products
                           where p.productname.Equals(Name)
                           select p).FirstOrDefault();
            tmp = new wProduct(product.productname, (Int32)product.price, product.Proimage, (Int32)product.quantity, product.status);

            string resu= ("Product Name:"+ tmp.getName()+"Product Price:"+ tmp.getPrice());
            
            return resu;
        }

        public bool Login(string un, string psw)
        {
            var user = (from u in db.users
                        where u.username.Equals(un) && u.psw.Equals(psw)
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

        public void Register(string FN, string surname, string uname, string password, string Gender)
        {
            employee e = new employee
            {
                
                firstName = FN,
                lastName = surname,
                gender = Gender
            };
            user u = new user
            {
                
                username = uname,
                psw = password,
                
            };
            
            
            db.employees.InsertOnSubmit(e);
            db.users.InsertOnSubmit(u);
            db.SubmitChanges();
            
        }

        public string UpdateProductPrice(string name,int Price)
        {
            
          
            var query =
                from pro in db.products
                where pro.productname == name
                select pro;

            int prevP=0;

            foreach (product pro in query)
            {
                prevP = (Int32)pro.price;
                pro.price = Price;
            }
                db.SubmitChanges();
            




            return "Updated product price from "+prevP+"to "+Price;
        }
    }
}
