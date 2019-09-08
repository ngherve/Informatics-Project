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

            incoming.InnerHtml = incomingcount.ToString();
            outgoing.InnerHtml = outgoingcount.ToString();
        }
    }
}