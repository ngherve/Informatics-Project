using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TYPPrototype.ProductService;

namespace TYPPrototype
{
    public partial class deleteDamages : System.Web.UI.Page
    {
        ProductServiceClient prodClient;
        protected void Page_Load(object sender, EventArgs e)
        {
            string code = Request.QueryString["ID"];
            prodClient = new ProductServiceClient();
            int id = int.Parse(code);
            string x = prodClient.DeleteDamages(id);
            Response.Write("<script>alert('" + "Damages " + id + x + "')</script>");
            Response.Redirect("DamagedProducts.aspx");
        
    }
    }
}