using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TYPPrototype.ProductService;
using TYPPrototype.UserService;

namespace TYPPrototype
{
    public partial class Transactions : System.Web.UI.Page
    {
        ProductServiceClient prodService;
        UserServiceClient userService;
        protected void Page_Load(object sender, EventArgs e)
        {
            userService = new UserServiceClient();
            prodService = new ProductServiceClient();
            Invoice[] invoices = prodService.GetAllInvoices();
            Product[] products = prodService.GetAllProducts();
            User[] users = userService.GetAllUsers();
            string display = "";
            Product pro = null;
            User u = null;
           
            

            //foreach (Invoice inv in invoices)
            for(int i = invoices.Length-1; i>=0; i--)
            {
                //User u = userService.GetUserbyID(inv.UserID);
                foreach (User us in users)
                {
                    if (us.UserID.Equals(invoices[i].UserID))
                    {
                        u = us;
                    }
                }
                foreach (Product p in products)
                {
                    if (p.P_Code.Equals(invoices[i].P_Code))
                    {
                        pro = p;
                    }
                }if (pro != null)
                {
                    display += "<tr>"
                           + "<td><input type='checkbox' class='input-chk'></td>"
                           + "<td>"
                           + "<p class='text'>" + invoices[i].INV_Date + "</p>"
                           + "</td>"
                           + "<td><span class='badge badge-primary'>" + pro.P_Name + " " + invoices[i].P_Code + "</span></td>"
                           + "<td><p class='text'>" + invoices[i].Quantity + "</p></td>"
                           + "<td><span class='badge badge-danger'>" + u.Name + "</span></td>"
                           + "<td><span class='badge badge-primary'>" + invoices[i].Inv_Type + "</span></td>"
                           + "</tbody>"
                           ;
                }
            }
            trans.InnerHtml = display;

        }
    }
}