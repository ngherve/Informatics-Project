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
           
            

            foreach (Invoice inv in invoices)
            {
                //User u = userService.GetUserbyID(inv.UserID);
                foreach (User us in users)
                {
                    if (us.UserID.Equals(inv.UserID))
                    {
                        u = us;
                    }
                }
                foreach (Product p in products)
                {
                    if (p.P_Code.Equals(inv.P_Code))
                    {
                        pro = p;
                    }
                }if (pro != null)
                {
                    display += "<tr>"
                           + "<td><input type='checkbox' class='input-chk'></td>"
                           + "<td>"
                           + "<p class='text'>" + inv.INV_Date + "</p>"
                           + "</td>"
                           + "<td><span class='badge badge-primary'>" + pro.P_Name + " " + inv.P_Code + "</span></td>"
                           + "<td><p class='text'>" + inv.Quantity + "</p></td>"
                           + "<td><span class='badge badge-danger'>" + u.Name + "</span></td>"
                           + "<td><span class='badge badge-primary'>" + inv.Inv_Type + "</span></td>"
                           + "</tbody>"
                           ;
                }
            }
            trans.InnerHtml = display;

        }
    }
}