using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TYPPrototype.ProductService;

namespace TYPPrototype
{
    public partial class Location : System.Web.UI.Page
    {
        
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnMech_Click(object sender, EventArgs e)
        {
            Response.Redirect("Bins.aspx");
        }

        protected void btnInd_Click(object sender, EventArgs e)
        {
            Response.Redirect("Warehouse2.aspx");
        }

        protected void btnElec_Click(object sender, EventArgs e)
        {
            Response.Redirect("Warehouse3.aspx");
        }

        protected void btnsec_Click(object sender, EventArgs e)
        {
            Response.Redirect("Warehouse1.aspx");
        }
    }
}