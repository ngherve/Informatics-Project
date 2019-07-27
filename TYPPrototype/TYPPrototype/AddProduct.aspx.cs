using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace TYPPrototype
{
    public partial class addProduct : System.Web.UI.Page
    {
        ProductService.ProductServiceClient Pclient;
        protected void Page_Load(object sender, EventArgs e)
        {
            Pclient = new ProductService.ProductServiceClient();
        }

        protected void Savebtn_Click(object sender, EventArgs e)
        {
            ProductService.Product Pro = new ProductService.Product
            {
                P_Name = Pname.Value,
                P_Price = Int32.Parse(Pprice.Value),
                P_Image = Pimage.Value,
                P_Quantity = Int32.Parse(PQuant.Value),
                P_Type = Ptype.Value,
                P_Code = PCode.Value,
                Supplier_Name = SName.Value,
                W_Name = WName.Value
            };
            string result = Pclient.AddProduct(Pro);

            Response.Write("<script>alert('" + result + "')</script>");
        }

        protected void btnCancelPro_Click(object sender, EventArgs e)
        {
            Response.Redirect("home.aspx");
        }
    }
}