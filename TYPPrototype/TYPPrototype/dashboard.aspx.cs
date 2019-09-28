using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TYPPrototype.UserService;
using TYPPrototype.ProductService;


namespace TYPPrototype
{
    public partial class dashboard : System.Web.UI.Page
    {

        UserServiceClient userClient;
        ProductServiceClient prodClient;

        protected void Page_Load(object sender, EventArgs e)
        {

            userClient = new UserServiceClient();
            prodClient = new ProductServiceClient();

            tasks.InnerHtml = userClient.GetTasks().Length.ToString();
            users.InnerHtml = userClient.GetAllUsers().Length.ToString();

            int incomingcount = 0;
            int outgoingcount = 0;
            Invoice[] invs = prodClient.GetAllInvoices();
            foreach (Invoice inv in invs)
            {
                if (inv.Inv_Type.Equals("incoming"))
                {
                    incomingcount += inv.Quantity;
                } else if (inv.Inv_Type.Equals("dispatch"))
                {
                    outgoingcount += inv.Quantity;
                }
            }

            string display = " ";

            Invoice[] invoices = prodClient.GetInvoicebyType("dispatch");
            foreach(Invoice inv in invoices)
            {
                Product pro = prodClient.SearchProduct(inv.P_Code);
                User u = userClient.GetUserbyID(inv.UserID);
                display += "<tr>"
                        + "<td class='text-truncate'>"+pro.P_Name +" "+inv.P_Code +"</td>"
                        + "<td class='text-truncate p-1'>"
                        + "<ul class='list-unstyled users-list m-0'>"
                        + "<li data-toggle='tooltip' data-popup='tooltip-custom' data-original-title='"+u.Name+"' class='avatar avatar-sm pull-up'>"
                        + "<img class='" + u.pphoto + "' alt='Avatar'> "
                        + "</li>"
                        + "</ul>"
                        + "</td>"
                        + "<td class='text-truncate'>"+inv.Total_Price+"</td> "
                        + "</tr>"
                        ;
            }
            ordertable.InnerHtml = display;
            incoming.InnerHtml = incomingcount.ToString();
            outgoing.InnerHtml = outgoingcount.ToString();
        }
    }
}