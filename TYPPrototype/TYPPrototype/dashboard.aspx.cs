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

        protected void Page_Load(object sender, EventArgs e)
        {

            userClient = new UserServiceClient();

            List<Product> DamagedProds = new List<Product>();
            //foreach (Damaged prod in Dproducts)
            {
                Product p;
                //p = prodService.GetProductbyID(prod.P_ID);
                //DamagedProds.Add(p);
            }
        }
    }
}