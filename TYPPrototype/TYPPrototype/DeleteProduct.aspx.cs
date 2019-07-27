using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TYPPrototype.ProductService;

namespace TYPPrototype
{
    public partial class DeleteProduct : System.Web.UI.Page
    {
        ProductServiceClient prodClient;
        protected void Page_Load(object sender, EventArgs e)
        {
            string code = Request.QueryString["ID"];
            prodClient = new ProductServiceClient();
            int id = int.Parse(code);
            string x = prodClient.DeleteProduct(id);
            Response.Write("<script>alert('" + "Product " + id + x + "')</script>");
            Response.Redirect("Productlist.aspx");
        }
    }
}